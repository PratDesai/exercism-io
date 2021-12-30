(ns leap)

(defn leap-year? [year]
  (let [is-divisible? (fn [n] (zero? (mod year n)))]
    (or (is-divisible? 400)
        (and (is-divisible? 4) (not (is-divisible? 100))))))