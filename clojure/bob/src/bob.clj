(ns bob)

(defn- alphabets? [s]
  (some #(Character/isLetter %) s))

(defn- question? [s]
  (= (last s) \?))

(defn- yelling? [s]
  (when (alphabets? s)
    (= s (.toUpperCase s))))

(defn response-for [s]
  (let [trimmed (.trim s)]
    (cond
      (empty? trimmed) "Fine. Be that way!"
      :else (let [is-question (question? trimmed)
                  is-yelling (yelling? trimmed)]
              (cond
                (and is-question is-yelling) "Calm down, I know what I'm doing!"
                is-question "Sure."
                is-yelling "Whoa, chill out!"
                :else "Whatever.")))))