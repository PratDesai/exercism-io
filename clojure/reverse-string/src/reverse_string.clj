(ns reverse-string)

(defn reverse-string [s] 
  (->> 
   (loop [acc '() s s]
     (if (empty? s) 
       acc 
       (recur (conj acc (first s)) (rest s))))
   (apply str)))