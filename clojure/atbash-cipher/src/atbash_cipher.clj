(ns atbash-cipher
  (:require [clojure.string :as str]))

(def cipher
  (let [alphas (map char (range (int \a) (inc (int \z))))
        nums (map char (range (int \0) (inc (int \9))))]
    (zipmap (concat alphas nums)
            (concat (reverse alphas) nums))))

(defn encode [data]
  (->> data
       (.toLowerCase)
       (keep cipher)
       (partition 5 5 "")
       (map #(apply str %1))
       (str/join " ")))