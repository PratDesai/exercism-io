(ns series)

(defn slices [string length]
  (cond (empty? string) []
        (zero? length) [""]
        (> length (count string)) []
        :else (loop [acc [] s string]
                (if (< (count s) length)
                  acc
                  (recur (conj acc (apply str (take length s))) (rest s))))))