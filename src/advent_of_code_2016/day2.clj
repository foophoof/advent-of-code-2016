(ns advent-of-code-2016.day2
  (:require [clojure.string :as str]))

(def standard-keypad
  {:up    [1 2 3 1 2 3 4 5 6]
   :down  [4 5 6 7 8 9 7 8 9]
   :left  [1 1 2 4 4 5 7 7 8]
   :right [2 3 3 5 6 6 8 8 9]})

(def diamond-keypad
  {:up    [1 2 1 4 5  2  3  4 9  6  7  8 11]
   :down  [3 6 7 8 5 10 11 12 9 10 13 12 13]
   :left  [1 2 2 3 5  5  6  7 8 10 10 11 13]
   :right [1 3 4 4 6  7  8  9 9 11 12 12 13]})

(defn up
  [keypad pos]
  (get (:up keypad) (- pos 1)))

(defn down
  [keypad pos]
  (get (:down keypad) (- pos 1)))

(defn left
  [keypad pos]
  (get (:left keypad) (- pos 1)))

(defn right
  [keypad pos]
  (get (:right keypad) (- pos 1)))

(def moves
  {:up up
   :down down
   :left left
   :right right})

(defn move
  [keypad pos direction]
  ((get moves direction) keypad pos))

(defn apply-moves
  [keypad start-position moves]
  (reduce (partial move keypad) start-position moves))

(def decode-move
  {\U :up
   \D :down
   \L :left
   \R :right})

(defn decode-line
  [input]
  (map #(get decode-move %) input))

(defn decode
  [input]
  (map decode-line (str/split-lines input)))

(defn find-code
  [keypad input]
  (let [decoded-input (decode input)]
    (rest
      (reductions (partial apply-moves keypad) 5 decoded-input))))
