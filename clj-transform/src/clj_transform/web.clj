(ns clj-transform.web
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :refer (read-json json-str)])
)


(defroutes app-routes
  (GET "/test" [] (json-str {:test "test"}))
  )

(def app
  (handler/site app-routes))

(defn init []
  (println "Starting App"))

(defn destroy []
  (println "Stopping App"))
