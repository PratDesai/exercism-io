(ns etl)

(defn transform [source]
  (let [kys (keys source)
        vls (vals source)
        key-vals (map (fn [k vls] (map #(hash-map (.toLowerCase %) k) vls)) kys vls)]
    (into {} (mapcat identity key-vals))))