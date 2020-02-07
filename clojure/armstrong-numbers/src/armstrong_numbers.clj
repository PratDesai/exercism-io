(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn- digits [num]
  (mapv #(Character/getNumericValue %) (str num)))

(defn armstrong? [num]
  (let [digits (digits num)
        num-digits (count digits)]
    (->> (map #(math/expt % num-digits) digits)
         (apply +)
         (= num))))