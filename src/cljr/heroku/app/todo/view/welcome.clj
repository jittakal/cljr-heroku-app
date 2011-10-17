(ns cljr.heroku.app.todo.view.welcome
  (:require [cljr.heroku.app.todo.view.common :as common])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpage "/welcome" []
         (common/layout
          [:h1 "Welcome to my-website"]
          [:p "Hope you like it.Check for interactive development"]))
