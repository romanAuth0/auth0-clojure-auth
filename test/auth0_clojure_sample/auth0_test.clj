(ns auth0-clojure-sample.auth0-test
  (:require [clojure.test :refer [deftest is testing]]
            [auth0-clojure-sample.auth0 :as auth0]))

(deftest config-doman
  (testing "The domain should be set correctly"
    (is (= (:domain auth0/config) "your domain"))))