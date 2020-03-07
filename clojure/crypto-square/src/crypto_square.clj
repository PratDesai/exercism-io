(ns crypto-square)

(defn- digit-alphabet? [c]
  (or (Character/isDigit c) (Character/isLetter c)))

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
  ([s pad] (let [norm-text (normalize-plaintext s)
                 n (square-size norm-text)]
             (->> (partition n n pad norm-text)
                  (mapv #(apply str %))))))

(defn- ciphertext-segments
  ([s] (ciphertext-segments s nil))
  ([s c] (->> (plaintext-segments s (repeat \space))
              (transpose)
              (map #(.trim %))
              (interpose c)
              (apply str))))

(defn ciphertext [s]
  (ciphertext-segments s))

(defn normalize-ciphertext [s] 
  (ciphertext-segments s \space))