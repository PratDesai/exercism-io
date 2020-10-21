(ns run-length-encoding)

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> (partition-by identity plain-text)
       (mapcat #(if (<= (count %) 1) % [(count %) (first %)]))
       (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (letfn [(decode [[match g1 g2]]
                  (if (nil? g1) match (apply str (repeat (Integer. g1) g2))))]
    (->> (re-seq #"(\d+)(.)|(.)" cipher-text)
         (map decode)
         (apply str))))