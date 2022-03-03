(ns auth0-clojure-sample.views.layouts
  (:require [hiccup.page :refer [html5 include-css include-js]]
            [auth0-clojure-sample.components.navbar :as navbar]
            [auth0-clojure-sample.components.footer :as footer]))

(def assets
  {:css ["/main.css"]
   :js []})

(defn default
  [title profile & body]
  (html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
    [:title title]
    [:base {:href "/"}]
    (map include-css (:css assets))]
   [:body
    [:div {:class "flex flex-col h-screen"}
     (navbar/html profile)
     [:main {:class "container mx-auto flex-grow mt-10"}
      body]
     footer/html]
    (map include-js (:js assets))]))
