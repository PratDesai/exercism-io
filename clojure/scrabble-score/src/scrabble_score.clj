(ns scrabble-score
  (:require [clojure.string :as str]))

(def letter-points {(set "AEIOULNRST") 1
                    (set "DG") 2
                    (set "BCMP") 3
                    (set "FHVWY") 4
                    (set "K") 5
                    (set "JX") 8
                    (set "QZ") 10})

(defn score-letter [w]
  (let [c (first (str/upper-case w))]
    (->> letter-points
         (filter #((key %) c))
         first
         val)))

(defn score-word [w]
  (->> w
       (map score-letter)
       (apply +)))