(ns phone-number)

(def ^:private invalid-response "0000000000")
(def ^:private minimum-digits 10)

(defn number [num-string]
  (let [digits (apply str (re-seq #"\d+" num-string))
        num-digits (count digits)]
    (cond (< num-digits minimum-digits) invalid-response
          (= num-digits minimum-digits) digits
          :else (if (= \1 (first digits))
                  (subs digits 1)
                  invalid-response))))

(defn area-code [num-string]
  (subs (number num-string) 0 3))

(defn pretty-print [num-string]
  (->> (number num-string)
       (#(str "(" (subs % 0 3) ") " (subs % 3 6) "-" (subs % 6 10)))))
