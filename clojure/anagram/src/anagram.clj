(ns anagram
  (:require [clojure.string :as str]))

(defn- not-same? [word propect]
  (not= word (str/lower-case propect)))

(defn- match? [word-fs prospect]
  (= word-fs (frequencies (str/lower-case prospect))))

(defn anagrams-for [word prospect-list]
  (let [word-lower-case (str/lower-case word)
        word-fs (frequencies word-lower-case)
        anagram? (every-pred (partial not-same? word-lower-case)
                                    (partial match? word-fs))]
    (filter anagram? prospect-list)))