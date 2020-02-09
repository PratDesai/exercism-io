(ns collatz-conjecture)

(defn collatz [num]
  (cond 
    (<= num 0) (throw (Exception. "Number cannot be zero or negative."))
    :else (loop [num num step 0]
            (cond 
              (= num 1) step
              (even? num) (recur (/ num 2) (inc step))
              :else (recur (+ 1 (* num 3)) (inc step))))))