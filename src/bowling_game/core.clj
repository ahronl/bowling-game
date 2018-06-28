(ns bowling-game.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn is-spare
  [rolls]
  (= 10 (apply + (take 2 rolls))))

(defn get-frame-roll-count
  [rolls]
  (if
    (is-spare rolls) 3
    2))

(defn make-frames
  [rolls]
  (lazy-seq (cons (take (get-frame-roll-count rolls) rolls) (make-frames (drop 2 rolls)))))

(defn make-game
  [rolls]
  (take 10 (make-frames rolls)))

(defn calc-frame-score
  [roll]
  (reduce + roll))

(defn calc-game-score
  [frames]
  (reduce + frames))

(defn score
  [rolls]
  (calc-game-score (map calc-frame-score (make-game rolls))))
