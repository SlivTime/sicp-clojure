(ns ch1.ex1-6)

(comment
;; Exercise 1.6: Alyssa P. Hacker doesn’t see why if needs to be provided 
;; as a special form. “Why can’t I just define it as an ordinary 
;; procedure in terms of cond?” she asks. 
;; Alyssa’s friend Eva Lu Ator claims this can indeed be done, 
;; and she defines a new version of if:

;; (define (new-if predicate then-clause else-clause) 
;;   (cond (predicate then-clause)
;;   (else else-clause)))
;; Eva demonstrates the program for Alyssa:
;;   (new-if (= 2 3) 0 5) 5
;;   (new-if (= 1 1) 0 5) 0

;; Delighted, Alyssa uses new-if to rewrite the square-root program:
;; (define (sqrt-iter guess x) 
;;   (new-if (good-enough? guess x)
;;           guess
;;           (sqrt-iter (improve guess x) x)))
;; What happens when Alyssa aempts to use this to compute square roots? Explain.
  
  
  "
   The reason why we need special form of `if` is the rules of evaluation of the branches
   Only one of two should be executed. Since we have applicative evaluation order 
   all function agruments will be executed before going to new stack frame. 
   So for `new-if` the `else` branch with recursive call will be evaluated 
   even before we determine the truthiness of our condition (first argument).
   This will lead us to infinite recursion and execution will be never completed.
  "

  :rcf)