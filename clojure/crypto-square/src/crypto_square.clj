(ns crypto-square)

(defn- digit-alphabet? [c]
  (or (Character/isDigit c)
      (Character/isLetter c)))

(defn- transpose [coll]
  (->> (apply mapv vector coll)
       (map #(apply str %))))

(defn normalize-plaintext [s]
  (->> (filter #(digit-alphabet? %) (.toLowerCase s))
       (apply str)))

(defn square-size [s]
  (int (Math/ceil (Math/sqrt (count s)))))

(defn plaintext-segments 
  ([s] (plaintext-segments s nil))
  ([s padding] 
   (let [norm-text (normalize-plaintext s)
         n (square-size norm-text)]
     (->> (partition n n padding norm-text)
          (mapv #(apply str %))))))

(defn- ciphertext-segments [s]
  (->> (plaintext-segments s (repeat \space))
       (transpose)))

(defn ciphertext [s]
  (->> (ciphertext-segments s)
       (map #(.trim %))
       (apply str)))

(defn normalize-ciphertext [s] 
  (->> (ciphertext-segments s)
       (map #(.trim %))
       (interpose \space)
       (apply str)))