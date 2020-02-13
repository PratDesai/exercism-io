(ns etl)

(defn transform [source]
  (let [k (key (first source))
        v (val (first source))]))

(def aaa {1 ["WORLD" "GSCHOOLERS"]})

(def k (key (first aaa)))
(def v (val (first aaa)))

(mapv #(hash-map % k) v)
(zipmap (map clojure.string/lower-case v) (repeat k))

(+ 1 2)

(def test-str "abcdefhi")