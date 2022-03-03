(ns auth0-clojure-sample.components.profile-image
  (:require [hiccup.core :as h]))

(defn nav [url & [alt]]
  [:img.nav-user-profile.rounded-circle
   {:src url :alt (or alt "Profile picture") :style "width: 75px"}])

(defn large [src]
  [:img {:src src :class "rounded-circle img-fluid profile-picture mb-3 mb-md-0"}])

(comment
  (h/html (large "test.jpg"))
  (h/html (nav "test.jpg")))