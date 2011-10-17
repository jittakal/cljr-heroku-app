(ns cljr.heroku.app.todo.model.todoitem
  (:use [cljr.heroku.app.todo.model.base])
  (:use [somnium.congomongo])
  (:use [somnium.congomongo.config :only [*mongo-config*]]))

(defn get-all
  "Return all the records of todoitem"
  []
  (with-mongo (get-mdb-connection)
    (fetch :todoitems)))

(defn get-by-id
  "Return todolist record filter by primary key"
  [id]
  (with-mongo (get-mdb-connection)
    (fetch-one :todoitems
               :where {:_id id})))

(defn create
  "Create new todoitem record"
  [record]
  (with-mongo (get-mdb-connection)
    (insert! :todoitems record)))


(defn all-temp
  []
  [{}])
