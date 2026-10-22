(ns ch1.ex1-7)

;; Exercise 1.7: The good-enough? test used in computing square roots 
;; will not be very effective for finding the square roots of 
;; very small numbers. Also, in real computers, arithmetic 
;; operations are almost always performed with limited precision. 
;; This makes our test inadequate for very large numbers. 
;; Explain these statements, with examples showing how the 
;; test fails for small and large numbers. An alternative strategy 
;; for implementing good-enough? is to watch how guess 
;; changes from one iteration to the next and to stop when 
;; the change is a very small fraction of the guess. 
;; Design a square-root procedure that uses this kind of end test. 
;; Does this work better for small and large numbers?
(comment
  ;; Here is the inifial version of `sqrt` from the book

  (defn- average [a b]
    (/ (+ a b) 2))

  (defn- improve [guess x]
    (double (average guess (/ x guess))))

  (defn- square [n]
    (* n n))

  (defn- good-enough? [guess x]
    (< (abs (- (square guess)
               x))
       0.001))

  (defn sqrt-iter [guess x]
    (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x) x)))

  (defn sqrt [x]
    (float (sqrt-iter 1 x)))

  ;; I'll use verbose version of this function to check 
  ;; what's going on with numbers
  (defn- good-enough? [guess x]
    (prn (map float [guess x]))
    (< (abs (- (square guess)
               x))
       0.001))

  (sqrt 2)  ;; good result
  (sqrt 10000)  ;; good result
  (sqrt 1000010)  ;; slow with ratios, fail with floats, work with double
  (sqrt 1000000000000001)  ;; does not work even with floats

  (sqrt 0.1)  ;; ok result
  (sqrt 0.01)  ;; ok result
  (sqrt 0.001)  ;; bad result, 0.041245427 instead of ~0.03162277660168379
  (sqrt 0.0001)  ;; total garbage, will not change at all for lesser values
  (sqrt 0.00001)  ;; total garbage, almost the same result as in previous


  "
   There are several problems with this approach. 
   1. Fixed Epsilon at `good-enough?` does not scale. If we will try to use
      it to calculate square root of number less than this Epsilot, 
      all comparisons will make no sense. We have to select appropriate 
      Epsilon for small values.
   2. Large numbers. If we try to calculate sqrt of 100001 we will
      hit the precision limit: (improve 316.22934 100001) will return 
      the first argument itself, but this value will still be not good enough
      for this Epsilon.
   
   Clojure-specific problem:
      Ratio numbers. Clojure use Ratios as a result of division, so `improve` 
      will raise to very large numbers quickly:
      10028007000280001/8005600560008 as guess on 4th step of calculation
      (sqrt 10000). And this guess came to 2000+ symbols long 
      (in string representation) at the end of calculation.
      It will be much more faster and memory-efficient
      to use floats in `improve` function. 
  "

  (def epsilon 0.00001)
  (defn- small-enough? [n]
    (< n epsilon))

  (defn sqrt-iter-good [guess x]
    (let [next-improve (improve guess x)
          improve-diff (abs (- guess next-improve))
          nowhere-to-improve (small-enough? improve-diff)]
      (prn next-improve)
      (if nowhere-to-improve
        guess
        (sqrt-iter-good next-improve x))))

  (defn sqrt-good [n]
    (sqrt-iter-good 1 n))

  (sqrt-good 2)
  (sqrt-good 10000)
  (sqrt-good 1000010)
  (sqrt-good 1000000000000001)
  (sqrt-good 1234567890987654321)

  (sqrt-good 0.1)
  (sqrt-good 0.01)
  (sqrt-good 0.001)
  (sqrt-good 0.0001)
  (sqrt-good 0.00001)
  (sqrt-good 0.000000000001)
  ;; All calculations looks good now

  :rcf)
