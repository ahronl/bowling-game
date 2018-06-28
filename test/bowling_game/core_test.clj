(ns bowling-game.core-test
  (:require [clojure.test :refer :all]
            [bowling-game.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(deftest gutter-game-test
    (testing "When calculating the score of a bowling game it returns a zero score for a complete gutter game"
        (is (= (score (repeat 20 0)) 0))))
