(ns bob)

(defn- alphabets? [s]
  (some #(Character/isLetter %) s))

(defn- yelling? [s]
  (when (alphabets? s)
    (= s (.toUpperCase s))))

(defn- question? [s]
  (= (last s) \?))

(defn response-for [s]
  (let [trimmed (.trim s)
        is-empty (empty? trimmed)]
    (cond
      is-empty "Fine. Be that way!"
      :else (let [is-question (question? trimmed)
                  is-yelling (yelling? trimmed)]
              (cond
                (and is-question is-yelling) "Calm down, I know what I'm doing!"
                is-yelling "Whoa, chill out!"
                is-question "Sure."
                :else "Whatever.")))))

