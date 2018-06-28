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
