(ns clj-transform.osm-integration-test
  (:use midje.sweet)
  (:require [clj-transform.http-wrapper :refer :all]
            [clj-transform.core :refer :all]))


(facts "can get OSM data"
  (fact "returns some string"
        (type (get-string-response "http://api.openstreetmap.org/api/0.6/map?bbox=151,-27.001,151.001,-27"))
      => String)
  )

(facts "get-osm-data"
  (let [data (get-osm-data 151 -27.001 151.001 -27)]
    (fact "there is more than one node"
          (> (count (:node data)) 1) => true)
    (fact "there are more than one type of elements"
          (> (count data) 1) => true)
    ))
