(ns robot-name)

(def alphabets "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(def robots (atom []))

(defn- take-rand [coll n]
  (apply str (take n (repeatedly #(rand-nth coll)))))

(defn- create-name []
   (str (take-rand alphabets 2) 
        (take-rand (range 10) 3)))

(defn- is-name-unique? [name]
  (not-any? #(= % name) (mapcat #(vals @%) @robots)))

(defn- create-unique-name []
  (->> (repeatedly create-name)
       (filter is-name-unique?)
       first))

(defn robot []
  (let [robot (atom {:name (create-unique-name)})]
    (swap! robots #(conj % robot))
    robot))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (reset! robot {:name (create-unique-name)}))