(ns bowling-game.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn is-strike
  [rolls]
  (= 10 (first rolls)))

(defn is-spare
  [rolls]
  (= 10 (apply + (take 2 rolls))))

(defn get-num-rolls-for-score
  [rolls]
  (cond
    (is-spare rolls) 3
    (is-strike rolls) 3
    :else 2))

(defn get-num-rolls-for-frames
  [rolls]
  (if (is-strike rolls) 1 2))

(defn make-frames
  [rolls]
  (lazy-seq
          (cons (take (get-num-rolls-for-score rolls) rolls)
                (make-frames (drop (get-num-rolls-for-frames rolls) rolls)))))

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
