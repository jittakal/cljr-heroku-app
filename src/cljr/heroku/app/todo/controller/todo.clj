(ns cljr.heroku.app.todo.controller.todo
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [cljr.heroku.app.todo.view.todolist :as todolist-v]
            [cljr.heroku.app.todo.model.todolist :as todolist-m]))

(defn index []
  (todolist-v/index (do
                      (todolist-m/get-tdl-mdb)
                      (todolist-m/get-all-tdl-mdb))))

(defroutes routes
  (GET "/" [] (index)))
;;(POST "/" {params :params} (create params))


  
