(defproject clj-transform "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [org.clojure/data.json "0.2.2"]
                 [http.async.client "0.5.2"]]
  :plugins [[lein-ring "0.8.5"]]
  :min-lein-version "2.0.0"
  :uberjar-name "map-td-transform.jar"
  :ring {:handler clj-transform.web/app}
  :profiles {:dev {
                   :plugins [[lein-midje "3.0.0"]
                             [lein-ancient "0.4.0"]]
                   :dependencies [[midje "1.5.1"]
                                  ]}
             })
