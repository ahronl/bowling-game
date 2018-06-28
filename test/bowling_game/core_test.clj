(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(deftest gutter-game-test
    (testing "When invoke score on a gutter game it returns a zero score"
        (is (= (score (repeat 20 0)) 0))))

(deftest two-pin-frames
  (testing "when invoke score on all two pin frames it returns socre 20"
        (is (= (score (repeat 20 1)) 20))))

(deftest game-with-a-spare
  (testing "when invoke score on a game with spare it adds the next roll to score"
        (is (= (score (concat '(8 2) '(3 7) (repeat 17 0))) 23))))

(deftest game-with-strike
  (testing "when invoke score on a game with strike it adds 10 points")
        (is (= (score (concat '(10) '(5 3) (repeat 16 0))) 26)))
