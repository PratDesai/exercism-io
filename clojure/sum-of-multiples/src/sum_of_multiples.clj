(ns sum-of-multiples)

(defn- next-multiples [multiples multiplier]
  (map #(* % multiplier) multiples))

(defn- less-than-multiples [multiples max-val]
  (filter #(< % max-val) multiples))

(defn sum-of-multiples [multiples num]
  (->>
   (loop [acc #{} multiplier 1]
     (let [next-multiples (-> (next-multiples multiples multiplier)
                              (less-than-multiples num))]
       (if (seq next-multiples)
         (recur (into acc next-multiples) (inc multiplier))
         acc)))
   (apply +)))