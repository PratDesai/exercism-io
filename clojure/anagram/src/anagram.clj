(ns anagram
  (:require [clojure.string :as str]))

(defn- anagram? [word-lc word-fs prospect]
  (let [prospect-lc (str/lower-case prospect)]
    (and (not= word-lc prospect-lc)
         (= word-fs (frequencies prospect-lc)))))

(defn anagrams-for [word prospect-list]
  (let [word-lc (str/lower-case word)
        word-fs (frequencies word-lc)]
    (filter (partial anagram? word-lc word-fs) prospect-list)))