(ns cljr.heroku.app.test.todo.model.todolist
  (:use [cljr.heroku.app.todo.model.todolist])
  (:use [clojure.test]))

(deftest test-get-all
  (is (= "Home" (:name (first (get-all))))))

(deftest test-get-by-id
  (is (= "Home" (:name (get-by-id (:_id (first (get-all))))))))


;;(deftest test-create
;;  (is (. "Home" String/equals (:name (create {:name "Home"}))))
;;  (is (. "Business" String/equals (:name (create {:name "Business"})))))

;;(deftest test-get-name
;;  (is (. "Home" String/equals (:name (first (get-name 1))))))


