(ns clj-transform.web
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :refer (read-json json-str)]
            [clj-transform.core :as core]
            [ring.util.response :as resp]
            [ring.adapter.jetty :as jetty])
)


(defroutes app-routes
  (GET "/" [] (resp/file-response "index.html" {:root "static"}))
  (GET "/osm/:left/:bottom/:right/:top" 
       [left bottom right top] 
       (json-str (core/get-osm-data left bottom right top)))
  (route/not-found (json-str {:error "not found"}))
  (route/files "/" {:root "static"})
  )

(def app
  (handler/site app-routes))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port) :join? false}))
