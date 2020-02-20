(ns robot-name)

(def robots (atom []))
(def alphabets "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(def numbers "0123456789")

(defn- take-rand [coll n]
  (apply str (take n (repeatedly #(rand-nth coll)))))

(defn- create-name []
  (str (take-rand alphabets 2) 
       (take-rand numbers 3)))

(defn robot []
  (let [robot (atom {:name (create-name)})]
    (swap! robots #(conj % robot))
    robot))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (reset! robot {:name (create-name)}))
