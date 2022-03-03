(ns auth0-clojure-sample.views.index
  (:require
   [hiccup.element :refer [link-to]]))

(def index-hero
  "Defines the markup for the hero panel"
  [:div {:class "flex flex-col items-center pb-40 border-b-2 border-gray-100 mb-10"}
   [:img {:class "w-24 text-center" :src "/logo.png" :alt "Clojure logo"}]
   [:h1 {:class "text-3xl mb-4 font-bold text-gray-700"} "Clojure Sample Project"]
   [:p {:class "text-xl font-extralight mx-6 text-center"} "This is a sample application demonstrating the authentication flow, using "
    [:a {:href "https://clojure.org/" :class "font-bold text-blue-700 underline"} "Clojure"]]])

(def content-panel-data
  "Defines the data for the content panels. Returns an array of maps containing `title`, `url` and `content`."
  [{:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}
   {:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}
   {:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}
   {:title "Configure other identity providers"
    :url "https://auth0.com/docs/connections"
    :content "Auth0 supports social providers as Facebook, Twitter, Instagram and 100+, Enterprise providers as Microsoft Office 365, Google Apps, Azure, and more. You can also use any OAuth2 Authorization Server."}])

(defn- content-panel
  "Builds the markup for an individual pane on the content panel, given a map with `url`, `title` and `content`.
  `content` should just be a single paragraph of text."
  [{url :url
    title :title
    content :content}]
  [:div.content-panel {:class "md:w-5/12 mb-12"}
   [:div {:class "mb-5"}
    (link-to {:class "text-blue-500 font-medium"} url title)]
   [:p {:class "text-gray-700"} content]])

(def index-content
  "Builds the markup for the content panel on the index page"
  [:div {:class "md:flex justify-between md:flex-wrap p-5"}
   (map content-panel content-panel-data)])

(defn html
  "Builds the markup for the index page"
  []
  [:div index-hero
   [:h2 {:class "text-center text-xl font-bold text-gray-700 mb-16"} "What can I do next?"]
   index-content])
