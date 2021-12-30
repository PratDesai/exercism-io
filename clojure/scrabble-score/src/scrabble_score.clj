(ns scrabble-score
  (:require [clojure.string :as str]))

(def letter-points {#{"A" "E" "I" "O" "U" "L" "N" "R" "S" "T"} 1
                    #{"D" "G"} 2
                    #{"B" "C" "M" "P"} 3
                    #{"F" "H" "V" "W" "Y"} 4
                    #{"K"} 5
                    #{"J" "X"} 8
                    #{"Q" "Z"} 10})

(defn score-letter [w]
  (let [c (str/upper-case w)]
    (->> letter-points
         (filter #((key %) c))
         first
         val)))

(defn score-word [w]
  (->> w
       (map score-letter)
       (apply +)))