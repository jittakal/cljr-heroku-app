(ns cljr.heroku.app.todo.model.todolist
  (:use [cljr.heroku.app.todo.model.base])
  (:use [somnium.congomongo])
  (:use [somnium.congomongo.config :only [*mongo-config*]]))

(defn get-all
  "Return all the records of todolist collections"
  []
  (with-mongo (get-mdb-connection)
    (fetch :todolists)))

(defn get-by-id
  "Return todolist record filter by primary key"
  [id]
  (with-mongo (get-mdb-connection)
    (fetch-one :todolists
               :where {:_id id})))

(defn create
  "Create a record in todolist"
  [record]
  (with-mongo (get-mdb-connection)
    (insert! :todolists record)))

(defn get-name
  "Return name of todolist record"
  [id]
  (with-mongo (get-mdb-connection)
    (fetch-one :todolists
               :only [:name]
               :where {:_id id})))

(defn all-temp
  []
  [{:id 1 :name "Home"}
   {:id 2 :name "Business"}])