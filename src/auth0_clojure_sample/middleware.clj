(ns auth0-clojure-sample.middleware
  (:require [cheshire.core :refer [parse-string]]))

(defn wrap-user
  "Extracts the user profile from the session, parses the JSON and attaches it to the request for
easy consumption."
  [handler]
  (fn [{session :session :as request}]
    (let [profile-json (:user-profile session)]
      (handler (assoc request :user
                      (when profile-json (parse-string profile-json true)))))))

(defn wrap-host-url
  "Middleware for extracting out the URL of the site into something easily accessible."
  [handler]
  (fn [{scheme :scheme host :server-name port :server-port :as request}]
    (let [url (str (name scheme) "://" host (when port (format ":%s" port)))]
      (handler (assoc request :host-url url)))))

(def public-paths
  "Gets the list of paths that do not require authorization"
  ["/" ; The home page
   "/login"
   "/callback"])

(defn public-path?
  "Returns true if the given path can be accessed anonymously"
  [path]
  (some #(= path %) public-paths))

(defn wrap-authorize
  "Prevents access to a route if the user is not logged in, or the route is public"
  [handler]
  (fn [{uri :uri user :user :as request}]
    (if (or user (public-path? uri))
      (handler request)
      {:status 401
       :headers {}})))

(comment
  (apply (wrap-authorize (fn [_] {:status 200})) [{:uri "/"}]))