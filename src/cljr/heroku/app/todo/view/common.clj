(ns cljr.heroku.app.todo.view.common
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpartial layout [& content]
  (html5
   [:head
    [:title "my-website"]
    [:meta {:name "description" :content "Sample web application"}]
    [:meta {:name "author" :content "jitendra.takalkar@gmail.com"}]
    (include-css "/css/reset.css")
    (include-css "/css/bootstrap.min.css")
    [:style {:type "text/css"}
     "body {padding-top: 60px;"
     ".container-fluid > .sidebar-left {float: left; width: 220px;}"
     ".container-fluid > .sidebar-right {float: right; width: 220px;}"]]
   [:body
    [:div {:class "topbar"}
     [:div {:class "topbar-inner"}
      [:div {:class "container-fluid"}
       [:a {:class "brand" :href "#"} "Sample Project"]
       [:ul {:class "nav"}
        [:li {:class "active"}
         [:a {:href "#"} "Home"]]
        [:li
         [:a {:href "#about"} "About"]]
        [:li
         [:a {:href "#contact"} "Contact"]]]
       [:p {:class "pull-right"} "Logged in as "
        [:a {:href "#"} "Jitendra"]]]]]
    [:div {:class "container-fluid"}
     [:div {:class "sidebar"}
      [:div {:class "well"}
       [:h5 "Todo Lists"]
       [:ul
        [:li
         [:a {:href "#"} "Home"]]
        [:li
         [:a {:href "#"} "Business"]]]]]
     [:div {:class "content"} content
      [:footer
       [:p "&copy; Jitendra Takalkar 2011"]]]]]))
