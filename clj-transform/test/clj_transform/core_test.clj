(ns clj-transform.core-test
  (:use midje.sweet)
  (:require [clj-transform.core :refer :all]))


(facts "xml to map transform"
  (fact "can transform a single element to map"
        (x-to-j "<a/>") => { :tag :a :content nil :attrs nil })
  (fact "can transform a single element with a value"
        (x-to-j "<a>v</a>") => { :tag :a :content ["v"] :attrs nil})
  (fact "can transform multiple elements"
        (x-to-j "<g><a>v1</a><b>v2</b></g>") => {:tag :g 
                                                 :attrs nil
                                                 :content [{:tag :a 
                                                            :content ["v1"] 
                                                            :attrs nil}
                                                           {:tag :b 
                                                            :content ["v2"] 
                                                            :attrs nil}]})
        


        )
