(ns word-count
  (:require [clojure.string  :refer [lower-case]]))

(defn- count-words [acc word]
  (update acc word #(inc (or % 0))))

(defn word-count [s]
  (let [words (map lower-case (re-seq #"\b\w+\b" s))]
    (reduce count-words {} words)))
