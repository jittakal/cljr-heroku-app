(ns cljr.heroku.app.todo.model.base
  (:use [somnium.congomongo])
  (:use [somnium.congomongo.config :only [*mongo-config*]])
  (:require [clojure.string :as str]
            [clojure.java.jdbc :as sql])
  (:import (java.net URI)))

(def default-db-url "//postgres:postgres@localhost:5432/todo")
(def default-db-port 5432)

(defn db-spec
  []
  (let [url (URI. (if-let [db-url (System/getenv "DATABASE_URL")] db-url default-db-url))
        host (.getHost url)
        port (if (pos? (.getPort url)) (.getPort url) default-db-port)
        path (.getPath url)]
    (merge
     {:subname (str "//" host ":" port path)}
     (if-let [user-info (.getUserInfo url)]
       {:user (first (str/split user-info #":"))
        :password (second (str/split user-info #":"))}))))

(def db
  (merge
   {:classname "org.postgres.Driver"
    :subprotocol "postgresql"}
   (db-spec)))

;; MongoDB database configuration
(def default-mdb-url "mongodb://:@localhost:27017/test")
(def default-mdb-port "27017")

(defn split-mongo-url
  "Parse mongodb url e.g. mongodb://user:pass@localhost:1234/db"
  [url]
  (let [matcher (re-matcher #"^.*://(.*?):(.*?)@(.*?):(\d+)/(.*)$" url)]
    (when (.find matcher)
      (zipmap [:match :user :pass :host :port :db] (re-groups matcher)))))

(defn maybe-init
  "Checks if connection and collection exist, otherwise initialize"
  []
  (when (not (connection? *mongo-config*))
    (let [mongo-url (if-let [mdb-url (System/getenv "MONGOHQ_URL")]
                      mdb-url
                      default-mdb-url)
          config (split-mongo-url mongo-url)]
      ;;(println "connecting with url => " config)
      (set-connection! (make-connection  (:db config)
                                         :host (:host config)
                                         :port (Integer. (:port config))
                                         :user (:user config)
                                         :password (:pass config)))
      (or (collection-exists? :todolists)
          (create-collection! :todolists)
          (insert! :todolists {:name "Home"})
          (insert! :todolists {:name "Business"}))
      (or (collection-exists? :todoitems)
          (create-collection! :todoitems)))))

(defn get-mdb-connection
  []
  ;; TODO - create mdb specification and reuse
  (let [mongo-url (if-let [mdb-url (System/getenv "MONGOHQ_URL")]
                    mdb-url
                    default-mdb-url)
        config (split-mongo-url mongo-url)]
    (make-connection  (:db config)
                      :host (:host config)
                      :port (Integer. (:port config))
                      :user (:user config)
                      :password (:pass config))))


