(ns ch1.ex1-5)

(comment

;; Exercise 1.5: Ben Bitdiddle has invented a test to determine whether the 
;; interpreter he is faced with is using applicative- order evaluation 
;; or normal-order evaluation. He defines the following two procedures:
;;   (define (p) (p))
;;   (define (test x y)
;;     (if (= x 0) 0 y))
;; Then he evaluates the expression
;;   (test 0 (p))
  
;; What behavior will Ben observe with an interpreter that uses 
;; applicative-order evaluation? What behavior will he observe
;; with an interpreter that uses normal-order evaluation? 
;; Explain your answer. (Assume that the evaluation
;; rule for the special form if is the same whether the 
;; interpreter is using normal or applicative order:  
;; the predicate expression is evaluated first, 
;; and the result determines whether to evaluate 
;; the consequent or the alternative expression.)
  
  "
   Actually, in Clojure this will be written a little bit different:
  "
  (defn p [] (p))
  (defn test [x y]
    (if (= x 0)
      x
      y))

  (test 0 (p))

  "
   With normal-order evaluation the second argument to `test` call 
   will not be executed early. We can treat arguments as black boxes for 
   simplicity and expand function calls to the end:
  
  
  1. (test XXX YYY)
  2. (if (= XXX 0) XXX YYY)
  
  Here we need to execute XXX value to do the comparison:
  
  3. (if (= 0 0) 0 YYY)
  4. (if true 0 YYY)
  5. 0
  
   With normal order we will never execute second function argument
   if first is zero.
   "

  "
   With applicative order, which almost every real language use, 
   we have to execute arguments first. So we will fall in StackOverflowError
   in Clojure before even going to the body of test function. 
   In Scheme (and Racket) there will be infinite recursion loop.
  "
  
  :rcf)