(ns cljr.heroku.app.todo.view.layout
  (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype include-css]]))

(defn hcomment
  "Wrap the supplied HTML in a comment"
  [html]
  (str "<!--" html "-->"))

(defn common [title & body]
  (html
   (doctype :html5)
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
    [:title title]
    [:link {:rel "stylesheet" :href "/css/screen.css" :type "test/css" :media "screen projection"}]
    [:link {:rel "stylesheet" :href "/css/screen.css" :type "test/css" :media "print"}]
    (hcomment "[if lt IE 8]><link href=\"/css/ie.css\" media=\"screen,projection\" rel=\"stylesheet\" type=\"text/css\" /><![endif]")
    [:link {:rel "stylesheet" :href "/css/plugins/fancy-type/screen.css" :type "test/css" :media "screen, projection"}]
    (include-css "http://fonts.googleapis.com/css?family=Sigmar+One&v1")
    [:script {:src "https://www.google.com/jsapi?key=ABQIAAAAbb3c4q3plY9Llxsn2O7SERSVhjZ2jchcMgrrlRYU9_ZU7rh8PRSgvXPGH3H8j4ysS4E9ednw-STV-A" :type "text/javascript"}]
    [:script {:src "/js/todo-script.js" :type "text/javascript"}]]
   [:body
    [:div {:class "container"}
     [:div {:id "header" :class "span-24 last"}
      [:h1 {:id "todo"}
       [:img {:src "/css/plugins/buttons/icons/tick.png" :alt "ToDo" :id "header-image"}] "All Tasks"]]
     [:hr]
     [:div {:id "main-content" :class "span-24 last"}
      [:div {:id "body" :class "span-16"} body]
      [:div {:id "searchcontrol" :class "span-8 last"} "Loading ..."]]
     [:hr]]]))

(defn four-oh-four
  []
  (common "Page Not Found"
          [:div {:id "four-oh-four"}
           "The page you requested could not be found"]))
