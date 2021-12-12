(ns space-age)

(defn- on-planet [planet-seconds seconds]
  (/ seconds planet-seconds))

(def on-mercury (partial on-planet 7600543.81992))

(def on-venus (partial on-planet 1.9414149052176E7))

(def on-earth (partial on-planet 31557600))

(def on-mars (partial on-planet 5.9354032690079994E7))

(def on-jupiter (partial on-planet 3.74355659124E8))

(def on-saturn (partial on-planet 9.292923628848E8))

(def on-neptune (partial on-planet 5.200418560032001E9))

(def on-uranus (partial on-planet 2.6513700193296E9))
