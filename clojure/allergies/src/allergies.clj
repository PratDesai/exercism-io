(ns allergies)

(def all-allergies {:eggs 1
                    :peanuts 2
                    :shellfish 4
                    :strawberries 8
                    :tomatoes 16
                    :chocolate 32
                    :pollen 64
                    :cats 128})

(defn allergic-to? [score allergy]
  (->> (allergy all-allergies)
       (bit-and score)
       zero?
       not))

(defn allergies [score]
  (filterv #(allergic-to? score %) (keys all-allergies)))
