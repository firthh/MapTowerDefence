(ns clj-transform.http-wrapper
  (:require [clojure.data.json :refer (read-json json-str)]
            [http.async.client :as c]))

(defn- validate-response [response]
  (let [error (c/error response)]
    (if error
      (throw (Exception. (.getMessage error)))
      response)))

(defn- validate-response-code [response]
  (let [status (c/status response)]
    (if (= 200 (:code status))
      response
      (throw (Exception. (str "HTTP Response status is " (:code status) " from " (:url response)))))))

(defn get-string-response
  ([url] (get-string-response url nil))
  ([url cookies]
    (with-open [client (c/create-client)]
      (let [response-data (-> (c/GET client url :cookies cookies)
                            c/await
                            validate-response
                            validate-response-code
                            c/string)]
        (if (empty? response-data)
          (throw (Exception. "No Data Returned"))
          response-data)
        ))))
