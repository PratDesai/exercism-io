(ns octal)

(defn- char->digit [c]
  (Character/getNumericValue c))

(defn- octal? [s]
  (re-matches #"[0-7]*" s))

(defn- pow-seq [x]
  (map #(reduce *' (repeat % x)) (range)))

(defn to-decimal [s]
  (if (octal? s)
    (->>
     (reverse s)
     (map char->digit)
     (map * (pow-seq 8))
     (reduce +))
    0))