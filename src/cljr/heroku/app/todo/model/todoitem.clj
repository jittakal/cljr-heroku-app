(ns cljr.heroku.app.todo.model.todoitem
  (:use [clojure.java.jdbc :as sql :only (with-connection with-query-results insert-record)])
  (:use [cljr.heroku.app.todo.model.base]))

(defn all
  []
  (sql/with-connection db
    (sql/with-query-results results
      ["select tdi.*,tdl.name as tdlname from todoitem tdi, todolist tdl where tdi.todolistid=tdl.id"]
      (into [] results))))

(defn all-temp
  []
  [{}])

(defn create
  [todoitem]
  (sql/with-connection db
    (sql/insert-record :todoitem todoitem)))
