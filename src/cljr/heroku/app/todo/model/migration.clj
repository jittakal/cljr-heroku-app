(ns cljr.heroku.app.todo.model.migration
  (:use [cljr.heroku.app.todo.model :only (db)])
  (:require [clojure.java.jdbc :as sql]))

(defn create-todolist []
  (sql/with-connection db
    (sql/create-table :todolist
                      [:id :serial "PRIMARY KEY"]
                      [:name :varchar "NOT NULL"])))

;;[:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]

(defn -main []
  (print "Migrating database...") (flush)
  (create-shouts)
  (println " done"))
