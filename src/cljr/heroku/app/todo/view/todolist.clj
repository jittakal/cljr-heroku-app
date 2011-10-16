(ns cljr.heroku.app.todo.view.todolist
  (:use [hiccup.core :only [html h]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]])
  (:require [cljr.heroku.app.todo.view.layout :as layout]))


(defn display-todo-items
  [todoitems]
  (map
   (fn [todoitem]
     [:h4 {:class "todoitem"} (h (:name todoitem))]) todoitems))

(defn display-todo-lists
  [todolists]
  (map
   (fn [todolist]
     [:h3 {:class "todolist"} (h (:name todolist))]) todolists))

(defn display-all-tasks
  [todoitems todolists]
  (list
   [:div {:id "content" :class "span-20"} (display-todo-items todoitems)]
   [:div {:id "rsidebar" :class "span-4 last"} (display-todo-lists todolists)]))

(defn index
  [todolists]
  (layout/common "Todo List"
                 (display-todo-lists todolists)))
