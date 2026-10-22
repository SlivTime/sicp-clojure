(ns sicp.ch2)



(defn make-segment [start-point end-point]
  (list start-point end-point))

(defn start-segment [segment]
  (first segment))

(defn end-segment [segment]
  (second segment))

(defn make-point [x y]
  (list x y))

(defn- x-point [p]
  (first p))

(defn- y-point [p]
  (second p))

(defn midpoint-segment [segment]
  (let [mid-x (/ (+ (x-point (start-segment segment))
                    (x-point (end-segment segment)))
                 2)
        mid-y (/ (+ (y-point (start-segment segment))
                    (y-point (end-segment segment)))
                 2)]
    (make-point mid-x mid-y)))


(defn print-point [p]
  (prn (str "(" (x-point p) "," (y-point p) ")\n")))



(prn (midpoint-segment (make-segment (make-point 0 0) (make-point 4 4))))
(prn (midpoint-segment (make-segment (make-point 1 1) (make-point 2 2))))

 