(ns armstrong-numbers)

(defn- digits [num]
  (mapv #(Character/getNumericValue %) (str num)))

(defn- exp [n x]
  (loop [acc 1 n n base x]
    (cond
      (zero? n) acc
      (even? n) (recur acc (/ n 2) (*' base base))
      :else (recur (*' acc base) (/ (- n 1) 2) (*' base base)))))

(defn armstrong? [num]
  (let [digits (digits num)
        num-digits (count digits)
        digits-raised-to-pow (map #(exp num-digits %) digits)]
    (->> digits-raised-to-pow
         (apply +)
         (= num))))