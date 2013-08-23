(ns clj-transform.osm-integration-test
  (:use midje.sweet)
  (:require [clj-transform.http-wrapper :refer :all]))


(facts "can get OSM data"
  (fact "returns some string"
        (type (get-string-response "http://api.openstreetmap.org/api/0.6/map?bbox=151,-27.001,151.001,-27"))
      => String)
  )
