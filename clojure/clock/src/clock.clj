(ns clock)

(def minutes-per-day 1440)
(def minutes-per-hour 60)

(defn- hours->minutes [hours]
  (* hours minutes-per-hour))

(defn- normalized-minutes [minutes]
  (cond (neg? minutes) (+ (rem minutes minutes-per-day) minutes-per-day)
        :else (rem minutes minutes-per-day)))

(defn- minutes->clock [minutes]
  (let [rem-minutes (rem minutes 60)
        total-hours (quot minutes 60)
        hours (rem total-hours 24)]
    {:hours hours :minutes rem-minutes}))

(defn clock->string [clock]
  (format "%02d:%02d" (:hours clock) (:minutes clock)))

(defn clock [hours minutes]
  (->>  (+ (hours->minutes hours) minutes)
        normalized-minutes
        minutes->clock))

(defn add-time [clock minutes]
  (->> (+ (hours->minutes (:hours clock)) (:minutes clock))
       (+ minutes)
       normalized-minutes
       minutes->clock))