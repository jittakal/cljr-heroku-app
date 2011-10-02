(ns cljr.heroku.app.demo.web
  (:use ring.adapter.jetty))

(defn app [reg]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello, world"})

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty app {:port port})))

