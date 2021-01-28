(ns binary)

(defn to-decimal [val]
  (or (when (re-find #"^[01]+$" val)
         (let [reverse-digits (map #({\0 0 \1 1} %) (reverse val))
               pow-2-series (iterate #(* % 2) 1)]
           (->> (map * reverse-digits pow-2-series)
                (reduce +))))
      0))
