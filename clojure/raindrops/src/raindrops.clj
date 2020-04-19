(ns raindrops)

(defn check-factor [div response num]
  (when (= 0 (rem num div))
    response))

(defn convert [num]
  (let [check-factors (juxt (partial check-factor 3 "Pling")
                            (partial check-factor 5 "Plang")
                            (partial check-factor 7 "Plong"))
        response (apply str (check-factors num))]
    (if (empty? response)
      (str num)
      response)))