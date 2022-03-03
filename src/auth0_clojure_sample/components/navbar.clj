(ns auth0-clojure-sample.components.navbar
  (:require [hiccup.core :as hc]
            [auth0-clojure-sample.components.profile-image :as img]))

(def navbar-button
  [:button {:class ""
            :type "button"
            :data-toggle "collapse"
            :data-target "#navbarNav"}
   [:span.navbar-toggler-icon]])

(defn- icon [name & [class args]]
  [:i (merge {:class (str "fa " "fa-" name " " class)} args)])

(defn- nav-list-item [args & content]
  [:li args content])

(defn- nav-link [[url name]]
  [:a {:href url} name])

(defn anonymous-menu []
  (nav-list-item
   [:a {:href "/login"} "Log in"]))

(defn user-menu-dropdown [profile]
  (nav-list-item {:class "dropdown d-none d-md-block"}
                 [:a.nav-link.dropdown-toggle {:id "profileDropDown" :data-toggle "dropdown" :href "#"}
                  (img/nav (:picture profile))]
                 [:div.dropdown-menu.dropdown-menu-left
                  [:div.dropdown-header (:name profile)]
                  [:a.dropdown-item.dropdown-profile {:href "/profile"} (icon "user" "mr-3") "Profile"]
                  [:a.dropdown-item {:href "/logout"} (icon "power-off" "mr-3") "Log out"]]))

(defn user-menu-mobile
  "A menu that shows only on mobile devices"
  [profile]
  [:span.d-block.d-md-none.mobile-menu
   [:strong.navbar-text (:name profile)]
   (nav-list-item (nav-link ["/profile" "Profile"]))
   (nav-list-item (nav-link ["/logout" "Log out"]))])

(defn user-menu [profile]
  [:span
   (user-menu-dropdown profile)
   (user-menu-mobile profile)])

(defn html [profile]
  [:div {:class "shadow-md"}
   [:nav {:class "bg-gray-100 p-5"}
    [:div {:class "container mx-auto flex justify-between"}
     [:ul {:class "flex"}
      (let [menu-items [(nav-link ["/" "Home"])
                        (when profile (nav-link ["/profile" "Profile"]))]]
        (map #(nav-list-item {:class "mr-10"} %) menu-items))]
     [:ul (when-not profile (anonymous-menu))]]]])

(comment
  (hc/html (img/nav "image.jpg"))
  (hc/html (img/nav "image.jpg" "This is a demo picture"))
  (hc/html (nav-list-item "Hello"))
  (hc/html (nav-list-item {:class "test"} [:li.dropdown [:a {:href "#"} "This is a link"]]))
  (hc/html (user-menu {:picture "http://my-img" :name "Demo User"}))
  (hc/html (icon "test" "mr-3")))