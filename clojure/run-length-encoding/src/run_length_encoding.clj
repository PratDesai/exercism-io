(ns run-length-encoding)

(defn- encode-run [run]
  (let [length (count run)]
    (if (<= length 1) run [length (first run)])))

(defn- decode-group [[_ g1 g2]]
  (if (empty? g1) g2 (apply str (repeat (Integer. g1) g2))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (mapcat encode-run)
       (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text 
       (re-seq #"(\d*)(\D)")
       (map decode-group)
       (apply str)))