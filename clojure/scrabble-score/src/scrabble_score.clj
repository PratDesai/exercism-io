(ns scrabble-score)

(def letter-scores
  [[#{\A, \E, \I, \O, \U, \L, \N, \R, \S, \T} 1]
   [#{\D, \G} 2]
   [#{\B, \C, \M, \P} 3]
   [#{\F, \H, \V, \W, \Y} 4]
   [#{\K} 5]
   [#{\J \X} 8]
   [#{\Q \Z} 10]])

(defn score-letter [l]
  (let [upper-case (first (clojure.string/upper-case l))
        [_ score] (first (filter (fn [[letters score]] (letters upper-case)) letter-scores))]
    score))

(defn score-word [word]
  (->> word
       (clojure.string/upper-case)
       (map score-letter)
       (apply +)))
