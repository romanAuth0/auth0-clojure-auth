(ns auth0-clojure-sample.auth0
  (:import [com.auth0.client.auth AuthAPI]
           [com.auth0.jwt JWT])
  (:require [auth0-clojure-sample.util :refer [hash-to-map]]
            [environ.core :refer [env]]))

(def config
  {:domain "YOUR DOMAIN"
   :client-id "YOUR CLINET ID"
   :client-secret "YOUR CLIENT SECRET"})

(defn api
  "Creates the Auth0 API object"
  []
  (AuthAPI. (config :domain) (config :client-id) (config :client-secret)))

(defn handle-callback
  "Exchanges the authorization code for the tokens"
  [code]
  (-> (api)
      (.exchangeCode code "http://localhost:3000/callback")
      (.setScope "openid profile email")
      (.execute)))

(defn login-url
  "Builds a URL that the user should redirect to for login"
  []
  (-> (api)
      (.authorizeUrl "http://localhost:3000/callback")
      (.withScope "openid profile email")
      (.build)))

(defn- map-claim
  "Maps a claim value as a string or as an integer"
  [claim]
  (or (.asString claim) (.asInt claim)))

(defn get-user-profile
  "Decodes the given ID token and returns the user profile as a Clojure map"
  [id-token]
  (-> (JWT.)
      (.decodeJwt id-token)
      (.getClaims)
      (hash-to-map keyword map-claim)))

