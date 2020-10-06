(ns phone-number)

(defn number [num-string]
  (let [clean-num (apply str (filter #(Character/isDigit %) num-string))
        num-count (count clean-num)]
    (cond (or (< num-count 10) (> num-count 11)) "0000000000"
          :else (->> (#(if (> (count %) 10) (rest %) %))))))

(defn area-code [num-string] 
  (let [number (number num-string)]
    (->> (take 3 number)
         (apply str))))

(defn pretty-print [num-string]
  (let [number (number num-string)
        area-code (area-code number)]
    area-code))

" G <G><NL>"