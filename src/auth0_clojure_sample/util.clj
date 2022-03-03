(ns auth0-clojure-sample.util)

(defn hash-to-map
  "Turns a Java hash into a Clojure map"
  [hash fn-k fn-v]
  (into {} (for [[k v] hash] [(fn-k k) (fn-v v)])))