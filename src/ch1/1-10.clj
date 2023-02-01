(ns ch1.1-10)

(comment
  ;; Exercise 1.10: The following procedure computes a mathematical 
  ;; function called Ackermann’s function.
  (defn A
    [x y]
    (prn x y)
    (cond
      (= y 0) 0
      (= x 0) (* 2 y)
      (= y 1) 2
      :else (A (- x 1)
               (A x (- y 1)))))

  ;; What are the values of the following expressions?
  (A 1 10)
  ;; 1024

  (A 2 4)
  ;; 65536

  (A 3 3)
  ;; 65536

  ;; Consider the following procedures, where A is the procedure defined above:
  (defn k [n] (* 5 n n))
  ;; Give concise mathematical definitions for the functions 
  ;; computed by the procedures f, g, and h for positive integer 
  ;; values of n. For example, (k n) computes 5n2.
  (defn f
    "f will multiply n by 2"
    [n] (A 0 n))

  (f 2)  ;; 4
  (f 10)  ;; 20
  (f -5)  ;; -10
  (f 0)  ;; 0

  (defn g
    "g will calculate 2^n for n > 0"
    [n] (A 1 n))

  (g 2)  ;; 4
  (g 5)  ;; 32 
  (g 16)  ;; 65536

  (defn h
    "Calculate 2 ^ (2 ^ (2 ... (n times))) for positive n"
    [n] (A 2 n))

  (map h (range 5))  ;; (0 2 4 16 65536)
  (h 6)  ;; stack overflow :)
  )