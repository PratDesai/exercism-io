(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (#{\A \T \C \G} nucleotide) 
    (reduce #(if (#{nucleotide} %2) (inc %1) %1) 0 strand)
    (throw (IllegalArgumentException. (str "Invalid nucleotide " nucleotide)))))

(defn nucleotide-counts [strand]
  (reduce 
   (fn [acc val] (update acc val #(inc (or % 0)))) 
   {\A 0 \T 0 \C 0 \G 0} 
   strand))

