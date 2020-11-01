(ns grade-school)

(defn grade [school grade]
  (school grade []))

(defn add [school name grade]
  (update school grade (comp vec conj) name))

(defn sorted [school]
  (->> school
       (map (fn [[k x]] [k ((comp vec sort) x)]))
       (into (sorted-map))))