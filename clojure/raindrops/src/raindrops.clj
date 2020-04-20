(ns raindrops)

(def factors {3 "Pling"
              5 "Plang"
              7 "Plong"})

(defn check-factor [div response num]
  (when (zero? (rem num div))
    response))

(defn convert [num]
  (->> (map #(check-factor (key %) (val %) num) factors)
       (apply str)
       (#(if (empty? %) (str num) %))))