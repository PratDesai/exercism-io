(ns isbn-verifier)

(defn- parse [s]
  (->> s
       (remove #{\-})
       (apply str)
       (re-seq #"\d{9}[\dX]$")
       first))

(defn- digits [s]
  (->> s
       (map str)
       (replace {"X" "10"})
       (map #(Integer. %))))

(defn- isbn-calc-check [digits]
  (->> digits
       (map * (range 10 0 -1))
       (apply +)
       (#(mod % 11))
       (= 0)))

(defn isbn? [isbn] 
  (let [parsed (parse isbn)]
    (if parsed
      (->> parsed 
           digits
           isbn-calc-check)
      false)))