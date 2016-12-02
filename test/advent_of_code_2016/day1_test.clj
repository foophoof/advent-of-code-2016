(ns advent-of-code-2016.day1-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2016.day1 :refer :all]))

(deftest move-noop-test
  (testing "L0 from start position"
    (is (=
         {:pos [0 0] :dir :west}
         (move {:pos [0 0] :dir :north} "L0")))))

(deftest move-noop-test
  (testing "L5 from start position"
    (is (=
         {:pos [-5 0] :dir :west}
         (move {:pos [0 0] :dir :north} "L5")))))

(deftest apply-moves-1
  (testing "R2, L3"
    (is (=
         {:pos [2 3] :dir :north}
         (apply-moves (split-moves "R2, L3"))))))

(deftest apply-moves-2
  (testing "R2 R2 R2"
    (is (=
         {:pos [0 -2] :dir :west}
         (apply-moves (split-moves "R2, R2, R2"))))))

(deftest distance-from-start-1
  (testing "R2, L3"
    (is (= 5 (distance-from-start (split-moves "R2, L3"))))))
