(ns trinary)

(defn to-decimal [n]
  (letfn [(exp [x n] (reduce * (repeat n x)))]
    (->> (or (re-find #"^[0-2]+$" n) "0")
         reverse
         (map #(Character/digit % 10))
         (map #(* %2 (exp 3 %1)) (range))
         (apply +))))