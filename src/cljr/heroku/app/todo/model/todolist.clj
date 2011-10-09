(ns cljr.heroku.app.todo.model.todolist
  (:use [cljr.heroku.app.todo.model.base :only (db)])
  (:require [clojure.java.jdbc :as sql :only (with-connection with-query-results insert-record)]))

(defn all
  []
  (sql/with-connection db
    (sql/with-query-results results
      ["select * from todolist"]
      (into [] results))))

(defn all-temp
  []
  [{:id 1 :name "Home"} {:id 2 :name "Business"}])

(defn get-name
  [todolistid]
  (sql/with-connection db
    (sql/with-query-results results
      [(str "select name from todolist where id=" todolistid)]
      (into [] results))))

(defn create
  [todolist]
  (sql/with-connection db
    (sql/insert-record :todolist todolist)))
