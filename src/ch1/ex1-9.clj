(ns ch1.ex1-9)

(comment
  ;; Exercise 1.9: Each of the following two procedures defines 
  ;; a method for adding two positive integers in terms of the 
  ;; procedures inc, which increments its argument by 1, and dec, 
  ;; which decrements its argument by 1.
  (defn +
    [a b]
    (if (= a 0)
      b
      (inc (+ (dec a) b))))

  (defn +
    [a b]
    (if (= a 0)
      b
      (+ (dec a) (inc b))))
  ;; Using the substitution model, illustrate the process
  ;; generated by each procedure in evaluating (+ 4 5).
  ;; Are these processes iterative or recursive?


  ;; First one
  (defn +
    [a b]
    (prn a b)
    (if (= a 0)
      b
      (inc (+ (dec a) b))))

  (+ 4 5)
  (if false 5 (inc (+ 3 5)))
  (if false 5 (inc ((if false 5 (inc (+ 2 5))))))
  (if false 5 (inc ((if false 5 (inc ((if false 5 (inc (+ 1 5)))))))))
  (if false 5 (inc ((if false 5 (inc ((if false 5 (inc ((if false 5 (inc (+ 0 5))))))))))))
  (if false 5 (inc ((if false 5 (inc ((if false 5 (inc ((if false 5 (inc ((if true 5 (...))))))))))))))
  (if false 5 (inc ((if false 5 (inc ((if false 5 (inc ((if false 5 (inc 5)))))))))))
  (if false 5 (inc ((if false 5 (inc ((if false 5 (inc 6))))))))
  (if false 5 (inc ((if false 5 (inc 7)))))
  (if false 5 (inc 8))
  9

  ;; We will go deeper and deeper accululating `inc` calls while a > 0
  ;; Then all this inc's will be executed and we will get the result
  ;; This is recursive process, call stack will grow linear


  ;; Second function
  (defn +
    [a b]
    (prn a b)
    (if (= a 0)
      b
      (+ (dec a) (inc b))))

  (+ 4 5)
  (if false 5 (+ (dec 4) (inc 5)))
  (+ 3 6)
  (if false 6 (+ (dec 3) (inc 6)))
  (+ 2 7)
  (if false 7 (+ (dec 2) (inc 7)))
  (+ 1 8)
  (if false 8 (+ (dec 1) (inc 8)))
  (+ 0 9)
  (if true 9 (...))
  9

  ;; This is iterative process, stack is not growing at all
  )