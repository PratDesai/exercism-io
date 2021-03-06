(ns beer-song)

(def verse-data 
  {0 (str "No more bottles of beer on the wall, no more bottles of beer.\n"
          "Go to the store and buy some more, 99 bottles of beer on the wall.\n")
   1 (str "1 bottle of beer on the wall, 1 bottle of beer.\n"
          "Take it down and pass it around, no more bottles of beer on the wall.\n")
   2 (str "2 bottles of beer on the wall, 2 bottles of beer.\n"
          "Take one down and pass it around, 1 bottle of beer on the wall.\n")
   :bottles-of-beer "bottles of beer"
   :bottles-of-beer-on-the-wall "bottles of beer on the wall"
   :take-one-down-and-pass-it-around "Take one down and pass it around"})

(defn verse-for-multiple-bottles 
  "Returns the nth verse where n>2 which exhibit a common pattern."
  [num]
  (str num " " (verse-data :bottles-of-beer-on-the-wall) ", "
       num " " (verse-data :bottles-of-beer) ".\n"
       (verse-data :take-one-down-and-pass-it-around) ", "
       (dec num) " " (verse-data :bottles-of-beer-on-the-wall) ".\n"))

(defn reversed-num-seq
  "Returns a sequence of numbers in reverse order."
  ([start] (reverse (range (inc start))))
  ([start end] (reverse (range end (inc start)))))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (cond
    (contains? #{0 1 2} num) (verse-data num)
    :else  (verse-for-multiple-bottles num)))

(defn interpose-verses [reversed-num-seq]
  (let [verses (map verse reversed-num-seq)]
    (apply str (interpose "\n" verses))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (interpose-verses (reversed-num-seq start)))
  ([start end] (interpose-verses (reversed-num-seq start end))))