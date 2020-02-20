(ns allergies)

(def allergy-data {:eggs 1
                   :peanuts 2
                   :shellfish 4
                   :strawberries 8
                   :tomatoes 16
                   :chocolate 32
                   :pollen 64
                   :cats 128})

(defn allergic-to? [score allergy]
  (not (zero? (bit-and score (allergy allergy-data)))))

(defn allergies [score]
  (filterv #(allergic-to? score %) (keys allergy-data)))
