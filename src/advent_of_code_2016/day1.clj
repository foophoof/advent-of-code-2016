(ns advent-of-code-2016.day1
  (:require [clojure.string :as str]))

(defn left-turn
  [dir]
  (case dir
    :north :west
    :east :north
    :south :east
    :west :south))

(defn right-turn
  [dir]
  (case dir
    :north :east
    :east :south
    :south :west
    :west :north))

(defn turn
  [turn-dir dir]
  (case turn-dir
    \L (left-turn dir)
    \R (right-turn dir)))

(defn go-north
  [distance pos]
  (update pos 1 #(+ % distance)))

(defn go-south
  [distance pos]
  (update pos 1 #(- % distance)))

(defn go-east
  [distance pos]
  (update pos 0 #(+ % distance)))

(defn go-west
  [distance pos]
  (update pos 0 #(- % distance)))

(defn move
  "Given a location and an operation, returns the new location"
  [state operation]
  (let [turn-dir (get operation 0)
        new-dir (turn turn-dir (:dir state))
        new-state (assoc state :dir new-dir)
        distance (Integer. (subs operation 1))]
    (case new-dir
      :north (update new-state :pos (partial go-north distance))
      :east (update new-state :pos (partial go-east distance))
      :south (update new-state :pos (partial go-south distance))
      :west (update new-state :pos (partial go-west distance)))))

(defn apply-moves
  [moves]
  (reduce move {:pos [0 0] :dir :north} moves))

(defn distance-from-start
  [moves]
  (let [position (:pos (apply-moves moves))]
    (+ (Math/abs (get position 0)) (Math/abs (get position 1)))))

(defn split-moves
  [string]
  (str/split string #", "))
