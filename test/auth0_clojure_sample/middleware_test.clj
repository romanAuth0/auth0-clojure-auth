(ns auth0-clojure-sample.middleware-test
  (:require [clojure.test :refer [deftest is testing]]
            [auth0-clojure-sample.middleware :as middleware]))

(def default-handler
  "A default handler, returning a successful result"
  (fn [_]
    {:status 200
     :headers {}
     :body nil}))

(deftest wrap-authorize-homepage
  (testing "Should return 200 for the homepage for anonymous user"
    (is (= 200 (:status (apply
                         (middleware/wrap-authorize default-handler)
                         [{:uri "/"}]))))))

(deftest wrap-authorize-login
  (testing "Should return 200 for the login page for anonymous user"
    (is (= 200 (:status (apply
                         (middleware/wrap-authorize default-handler)
                         [{:uri "/login"}]))))))

(deftest wrap-authorize-callback
  (testing "Should return 200 for the callback URL for anonymous user"
    (is (= 200 (:status (apply
                         (middleware/wrap-authorize default-handler)
                         [{:uri "/callback"}]))))))

(deftest wrap-authorize-profile-401
  (testing "Should return 401 for the profile page with an anonymous user"
    (is (= 401 (:status (apply
                         (middleware/wrap-authorize default-handler)
                         [{:uri "/profile"}]))))))

(deftest wrap-authorize-profile-200
  (testing "Should return 200 for the profile page with an authenticated user"
    (is (= 200 (:status (apply
                         (middleware/wrap-authorize default-handler)
                         [{:uri "/profile" :user {:name "test-user"}}]))))))