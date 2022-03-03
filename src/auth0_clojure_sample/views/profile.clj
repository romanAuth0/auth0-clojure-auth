(ns auth0-clojure-sample.views.profile
  (:require
   [auth0-clojure-sample.components.profile-image :as img]
   [clojure.pprint]
   [cheshire.core :refer [generate-string]]))

(defn html [profile]
  [:div.container.mt-5
   [:div.row.align-items-center.profile-header
    [:div.col-md-2 (img/large (:picture profile))]
    [:div.col-md
     [:h2 (:name profile)]
     [:p.lead.text-muted (:email profile)]]]
   [:div.row
    [:pre.rounded
     [:code.json (generate-string profile {:pretty true})]]]])