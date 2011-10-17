(ns cljr.heroku.app.todo.server
  (:require [noir.server :as server]))

(server/load-views "src/cljr/heroku/app/todo/view/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'cljr.heroku.app.todo})))

