(ns etl)

(defn transform [source]
  (let [kys (keys source)
        vls (vals source)
        vls-kys (map (fn [k vls] (map #(hash-map (.toLowerCase %) k) vls)) kys vls)]
    (into {} (mapcat identity vls-kys))))