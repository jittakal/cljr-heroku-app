(ns cljr.heroku.app.todo.model.base
  (:use [somnium.congomongo])
  (:use [somnium.congomongo.config :only [*mongo-config*]]))


;; MongoDB database configuration
(def default-mdb-url "mongodb://mongodb:mongodb@localhost:27017/test")
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


