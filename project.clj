(defproject auth0-clojure-sample "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [cheshire "5.9.0"]
                 [ring/ring-core "1.8.0"]
                 [ring/ring-defaults "0.3.2"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [compojure "1.6.1"]
                 [hiccup "1.0.5"]
                 [com.auth0/auth0 "1.14.2"]
                 [com.auth0/java-jwt "3.8.2"]
                 [environ "1.1.0"]]
  :plugins [[lein-ring "0.12.5"]
            [lein-environ "1.1.0"]
            [lein-pprint "1.2.0"]
            [lein-tailwind "0.1.2"]]
  :ring {:handler auth0-clojure-sample.core/app}
  :target-path "target/%s"
  :hooks [leiningen.tailwind]
  :profiles {:dev [:project/dev :profiles/dev]
             :test [:project/test :profiles/test]
           ;; only edit :profiles/* in profiles.clj
             :profiles/dev  {}
             :profiles/test {}
             :project/dev {}
             :project/test {}}
  :tailwind {:tailwind-dir "src/auth0_clojure_sample/css"
             :output-dir "resources/public"
             :tailwind-config "tailwind.config.js"
             :styles [{:src "main.css" :dst "main.css"}]})
