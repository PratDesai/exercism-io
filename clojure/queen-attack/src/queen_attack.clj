(ns queen-attack
  (:require [clojure.string :as str]))

(def empty-board
  (->> ["_" "_" "_" "_" "_" "_" "_" "_"]
       repeat
       (take 8)
       (into [])))

(defn board->str [board]
  (->> board
       (map #(str/join " " %))
       (map #(str % "\n"))
       (apply str)))

(defn update-board [board {:keys [w b]}]
  (-> (assoc-in board w \W)
      (assoc-in b \B)))

(defn straight? [{[wx wy] :w [bx by] :b}]
  (or (= wx bx) (= wy by)))

(defn diagonal? [{[wx wy] :w [bx by] :b}]
  (let [dx (Math/abs (- wx bx))
        dy (Math/abs (- wy by))]
    (= dx dy)))

(defn board-string [{:keys [w b] :as state}]
  (if (and  w b)
    (board->str (update-board empty-board state))
    (board->str empty-board)))

(defn can-attack [{:keys [w b] :as state}]
  (or (straight? state) (diagonal? state)))