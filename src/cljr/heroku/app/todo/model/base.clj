(ns cljr.heroku.app.todo.model.base
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
