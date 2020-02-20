(ns sum-of-multiples)

(defn multiple? [num div]
   (zero? (mod num div)))

(defn sum-of-multiples [coll limit]
  (let [factors (drop 1 (range limit))
        multiples? (fn [num] (some (partial multiple? num) coll))
        multiples (filter multiples? factors)]
    (apply + multiples)))