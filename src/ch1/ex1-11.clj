(ns ch1.ex1-11)

(comment
  ;; Exercise 1.11: A function f is defined by the rule that 
  ;;  f(n) = n if n<3,
  ;;  f(n) = f(n−1) + 2f(n−2) + 3f(n−3) if n ≥ 3.
  ;; 1. Write a procedure that computes f by means of a recursive process. 
  ;; 2. Write a procedure that computes f by means of an iterative process.

  (defn f-recursive [n]
    (if (< n 3)
      n
      (+ (f-recursive (- n 1))
         (f-recursive (- n 2))
         (f-recursive (- n 3)))))

  (f-recursive 32)
  ;; Will slow down on 32, evaluation is very expensive

  (defn count-to
    [n]
    (loop [start 0
           stop n]
      (prn start stop)
      (if (= start stop)
        stop
        (recur (inc start) stop))))

  (count-to 4)

  (defn f-iterative [n]
    (loop [i 0, a 0, b 1, c 2]
      (if (= i n)
        a
        (recur (inc i) b c (+ a b c)))))

  (f-iterative 60)

  :rcf)