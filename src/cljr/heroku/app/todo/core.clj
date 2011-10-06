(ns cljr.heroku.app.todo.core
  (:use [compojure.core :only [defroutes]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]
            [cljr.heroku.app.todo.controller.todo :as todo-c]
            [cljr.heroku.app.todo.view.layout :as layout]))

(defroutes routes
  todo-c/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start [port]
  (ring/run-jetty (var application) {:port (or port 8080) :join? false}))

(defn -main []
  (let [port (Integer/parseInt
              (if-let [env-port (System/getenv "PORT")] env-port "8080"))]
    (start port)))
