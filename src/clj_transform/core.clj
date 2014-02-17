(ns clj-transform.core
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]
            [clj-transform.http-wrapper :as http]
            ))

;;copy-pasta from clojure docs
(defn zip-str [s]
  (zip/xml-zip (xml/parse (java.io.ByteArrayInputStream. (.getBytes s)))))

(defn x-to-j [xml-data]
  (let [parsed-data (zip-str xml-data)
        non-nil-vals (filter #(not= % nil) parsed-data)]
    (first non-nil-vals)
    ))

(defn get-osm-data [left bottom right top]
  (->> (str "http://api.openstreetmap.org/api/0.6/map?bbox=" left "," bottom "," right "," top)
      http/get-string-response
      x-to-j
      :content
      (group-by :tag)
      ))

