(ns cljr.heroku.app.test.todo.model.todoitem
  (:use [cljr.heroku.app.todo.model.todoitem])
  (:use [clojure.test]))

(def test-all
  (is (= 1 (count (all)))))

;;(deftest test-create
;;  (is (. "Todo Task 1" String/equals (:description (create {:description "Todo Task 1" :todolistid 1})))))
