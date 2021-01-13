(ns atbash-cipher
  (:require [clojure.string :as str]))

(def cipher
  (zipmap "abcdefghijklmnopqrstuvwxyz0123456789"
          "zyxwvutsrqponmlkjihgfedcba0123456789"))

(defn encode [data]
  (->> data
       (.toLowerCase)
       (keep cipher)
       (partition-all 5)
       (map #(apply str %1))
       (str/join \space)))