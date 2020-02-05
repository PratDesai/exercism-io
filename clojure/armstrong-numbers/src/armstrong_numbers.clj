(ns armstrong-numbers)

(defn- digits [num]
  (mapv #(Character/getNumericValue %) (str num)))

(defn- exp [n x]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn armstrong? [num]
  (->> (digits num)
       (#(map (partial exp (count %)) %))
       (apply +)
       (= num)))