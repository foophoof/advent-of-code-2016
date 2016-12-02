(ns advent-of-code-2016.day2-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2016.day2 :refer :all]))

(deftest move-test
  (testing "up from top"
    (is (= 2 (move standard-keypad 2 :up))))
  (testing "down from bottom"
    (is (= 9 (move standard-keypad 9 :down))))
  (testing "left from left edge"
    (is (= 4 (move standard-keypad 4 :left))))
  (testing "right from right edge"
    (is (= 6 (move standard-keypad 6 :right))))
  (testing "up from center"
    (is (= 2 (move standard-keypad 5 :up)))))

(deftest decode-line-test
  (testing "ULL"
    (is (= [:up :left :left] (decode-line "ULL")))))

(deftest apply-moves-test
  (testing "ULL from 5"
    (is (= 1 (apply-moves standard-keypad 5 (decode-line "ULL"))))))

(deftest find-code-test
  (is (= [1 9 8 5] (find-code standard-keypad "ULL\nRRDDD\nLURDL\nUUUUD"))))

(deftest find-code-diamond-test
  (is (= [5 13 11 3] (find-code diamond-keypad "ULL\nRRDDD\nLURDL\nUUUUD"))))
