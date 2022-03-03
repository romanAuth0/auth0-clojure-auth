(ns auth0-clojure-sample.views.components)

(defn icon [name]
  [:i {:class (str "mr-2 fa fa-" name)}])

(def link-icon
  (icon "link"))