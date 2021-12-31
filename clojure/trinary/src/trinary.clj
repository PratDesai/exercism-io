(ns trinary
  (:require [clojure.math.numeric-tower :as math]))

(defn to-decimal [n]
  (->> (or (re-find #"^[0-2]+$" n) "0")
       reverse
       (map #(Character/digit % 10))
       (map #(* %2 (math/expt 3 %1)) (range))
       (apply +)))