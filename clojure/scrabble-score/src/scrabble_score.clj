(ns scrabble-score
  (:require [clojure.string :as str]))

<<<<<<< HEAD
(def letter-points {#{"A" "E" "I" "O" "U" "L" "N" "R" "S" "T"} 1
                    #{"D" "G"} 2
                    #{"B" "C" "M" "P"} 3
                    #{"F" "H" "V" "W" "Y"} 4
                    #{"K"} 5
                    #{"J" "X"} 8
                    #{"Q" "Z"} 10})

(defn score-letter [w]
  (let [c (str/upper-case w)]
=======
(def letter-points {(set "AEIOULNRST") 1
                    (set "DG") 2
                    (set "BCMP") 3
                    (set "FHVWY") 4
                    (set "K") 5
                    (set "JX") 8
                    (set "QZ") 10})

(defn score-letter [w]
  (let [c (first (str/upper-case w))]
>>>>>>> afaddbece57ad23ea69d538183eaf205bb82cf4d
    (->> letter-points
         (filter #((key %) c))
         first
         val)))

(defn score-word [w]
  (->> w
       (map score-letter)
       (apply +)))