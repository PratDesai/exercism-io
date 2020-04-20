(ns series)

(defn slices [string length]
  (cond 
    (zero? length) [""]
    :else (->> (partition length 1 string)
               (map #(apply str %)))))