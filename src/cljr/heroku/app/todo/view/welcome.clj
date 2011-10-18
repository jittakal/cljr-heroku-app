(ns cljr.heroku.app.todo.view.welcome  
  (:use noir.core
        hiccup.core
        hiccup.page-helpers)
  (:require [cljr.heroku.app.todo.view.common :as common])
  (:require [noir.response :as resp]))

(defpage "/" []
   (resp/redirect "/welcome"))

(defpage "/welcome" []
  (common/layout
   [:h1 "Welcome to my website"]
   [:p "Hope you like it."]))
