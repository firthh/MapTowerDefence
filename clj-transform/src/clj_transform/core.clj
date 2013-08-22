(ns clj-transform.core
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip])
  )

;;copy-pasta from clojure docs
(defn zip-str [s]
  (zip/xml-zip (xml/parse (java.io.ByteArrayInputStream. (.getBytes s)))))

(defn x-to-j [xml-data]
  (let [parsed-data (zip-str xml-data)
        non-nil-vals (filter #(not= % nil) parsed-data)]
    (first non-nil-vals)
 ))
