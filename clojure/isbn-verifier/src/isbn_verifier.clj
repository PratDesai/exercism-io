(ns isbn-verifier
  (:require [clojure.string :as string]))

(defn- parse [s]
  (re-matches #"\d{9}[\dX]$" (string/replace s "-" "")))

(defn- digits [s]
  (->> s
       (map #(Character/digit % 10))
       (replace {-1 10})))

(defn- isbn-calc-check? [nums]
  (->> nums
       (map * (range 10 0 -1))
       (apply +)
       (#(mod % 11))
       zero?))

(defn isbn? [isbn]
  (true?
   (when-let [parsed (parse isbn)]
     (->> parsed
          digits
          isbn-calc-check?))))