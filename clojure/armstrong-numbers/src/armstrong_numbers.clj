(ns armstrong-numbers)

(defn number-of-digits [num]
  (count (str num)))

(defn char->int [chr]
  (Integer/parseInt (str chr)))

(defn num->num-seq [num]
  (map char->int (str num)))

(defn pow [p v]
  (reduce *' (repeat p v)))

(defn armstrong? [num] ;; <- arglist goes here
  ;; your code goes here
  (let [number-of-digits (number-of-digits num)
        num-seq (num->num-seq num)
        raised-pow (map (partial pow number-of-digits) num-seq)
        summed-raised-pow (apply + raised-pow)]
    (= num summed-raised-pow)))

