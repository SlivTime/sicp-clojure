(ns ch1.ex1-4)

;; Exercise 1.4: Observe that our model of evaluation 
;; allows for combinations whose operators are 
;; compound expres- sions. Use this observation 
;; to describe the behavior of the following procedure:
(comment
  (defn a-plus-abs-b
    [a b]
    ((if (> b 0) + -) a b))
  ;; Actually this is pretty straightforward
  ;; We calculate the body from left to right, 
  ;; so at first we will evaluate if expression to get the function 
  ;; to be applied to given arguments
  ;; (if (> b 0) + -)
  ;; For positive b we will get `+` and `-` otherwise 
  ;; so next step will be 
  ;; (+ a b) or (- a b)
  
  (a-plus-abs-b 1 2)
  ;; 3
  (a-plus-abs-b 1 -1)
  ;; 2
  (a-plus-abs-b 0 0)
  ;; 0
  (a-plus-abs-b 0 -1)
  ;; 1
  :rcf)
