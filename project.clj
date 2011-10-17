(defproject cljr-heroku-app "1.0.0-SNAPSHOT"
  :description "cljr-heroku-app"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure.contrib/trace "1.3.0-SNAPSHOT"]
                 [noir "1.2.0"]
                 [congomongo "0.1.7"]]               
  :dev-dependencies [[swank-clojure "1.3.3"]]
  :main cljr.heroku.app.todo.server
  :repositories {"sonatype-oss-public" "http://oss.sonatype.org/content/groups/public/"})
