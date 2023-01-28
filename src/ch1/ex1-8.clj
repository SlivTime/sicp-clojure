(ns ch1.ex1-8)

;; Exercise 1.8: Newton’s method for cube roots is based on 
;; the fact that if y is an approximation to the cube root of x, 
;; then a better approximation is given by the value
;; ((x / y^2) + 2*y) / 3
;; Use this formula to implement a cube-root procedure 
;; analogous to the square-root procedure.
(comment
  (def epsilon 0.00001)

  (defn- square [n]
    (* n n))

  (defn- improve [guess x]
    (double (/ (+ (/ x (square guess))
                  (* 2 guess))
               3)))

  (defn- small-enough? [n]
    (< n epsilon))

  (defn cube-iter [guess x]
    (let [next-improve (improve guess x)
          improve-diff (abs (- guess next-improve))
          nowhere-to-improve (small-enough? improve-diff)]
      (prn next-improve)
      (if nowhere-to-improve
        guess
        (cube-iter next-improve x))))

  (defn cube-root [n]
    (double (cube-iter 1 n)))

  (cube-root 8)
  (cube-root 100)
  (cube-root 1000010)
  (cube-root 1000000000000001)
  (cube-root 1234567890987654321)

  (cube-root 0.1)
  (cube-root 0.01)
  (cube-root 0.001)
  (cube-root 0.0001)
  (cube-root 0.00001)
  (cube-root 0.000000000001)

  :rcf)
