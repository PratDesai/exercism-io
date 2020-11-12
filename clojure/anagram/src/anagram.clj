(ns anagram
  (:require [clojure.string :as str]))

(defn- not-same? [lower-case-word propect]
  (not= lower-case-word (str/lower-case propect)))

(defn- fs-match? [word-fs prospect]
  (= word-fs (frequencies (str/lower-case prospect))))

(defn anagrams-for [lower-case-word prospect-list]
  (let [lower-case-word (str/lower-case lower-case-word)
        word-fs (frequencies lower-case-word)
        anagram? (every-pred (partial not-same? lower-case-word)
                             (partial fs-match? word-fs))]
    (filter anagram? prospect-list)))