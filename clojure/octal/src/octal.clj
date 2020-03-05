(ns octal)

(defn- char->digit [c]
  (Character/getNumericValue c))

(defn- not-octal? [s]
  (some #(or (not (Character/isDigit %))
             (> (char->digit %) 7)) s))

(defn- pow-seq [x]
  (map #(reduce *'  (repeat % x)) (range)))

(defn to-decimal [s]
  (cond
    (not-octal? s) 0
    :else (->>
           (reverse s)
           (map char->digit)
           (map * (pow-seq 8))
           (reduce +))))