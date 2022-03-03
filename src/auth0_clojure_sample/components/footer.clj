(ns auth0-clojure-sample.components.footer)

(def html
  [:footer {:class "bg-gray-100 p-5 text-center text-sm"}
   [:div {:class "flex flex-col items-center"}
    [:img {:src "auth0.svg" :class "w-10 mb-3"}]]
   [:p "Sample project provided by "
    [:a {:href "https://auth0.com" :class "text-blue-700 underline"} "Auth0"]]])