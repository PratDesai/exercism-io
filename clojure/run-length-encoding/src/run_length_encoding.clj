(ns run-length-encoding
  (:require [clojure.edn :as edn]))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (let [char-groups (map first (re-seq #"(.)\1+|." plain-text))]
    (->> char-groups
         (map #(if (> (count %) 1)
                 (str (count %) (first %))
                 %))
         (apply str))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (let [encoded-groups (re-seq #"\d+.|." cipher-text)
        read-first-number (comp edn/read-string #(re-find #"\d+" %))]
    (->> encoded-groups
         (map
          #(if (number? (read-first-number %))
             (apply str (repeat (read-first-number %) (last %)))
             %))
         (apply str))))