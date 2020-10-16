(ns phone-number)

(def ^:private invalid-response "0000000000")
(def ^:private minimum-digits 10)

(defn- digits-only [num-string]
  (->> num-string
       (re-seq #"\d+")
       (apply str)))

(defn- validate-number [number]
  (let [num-digits (count number)]
    (cond
      (< num-digits minimum-digits) invalid-response
      (= num-digits minimum-digits) number
      :else (if (= \1 (first number))
              (apply str (rest number))
              invalid-response))))

(defn number [num-string]
  (->> num-string
       digits-only
       validate-number))

(defn area-code [num-string]
  (->> num-string
       number
       (re-find #"\d{3}")))

(defn pretty-print [num-string]
  (->> num-string
       number
       ((comp rest #(re-find #"(\d{3})(\d{3})(\d{4})" %)))
       (#(str "(" (first %) ") " (first (rest %)) "-" (last %)))))
