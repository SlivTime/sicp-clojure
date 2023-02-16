(ns ch1.ex1-16)

(comment
  ;; Exercise 1.16: Design a procedure that evolves an iterative exponentiation
  ;; process that uses successive squaring and uses a logarithmic number 
  ;; of steps, as does fast-expt. 
  ;; (Hint: Using the observation that (bn/2)2 = (b2)n/2, 
  ;; keep, along with the exponent n and the base b, an additional state variable a, 
  ;; and define the state transformation in such a way that the product abn is 
  ;; unchanged from state to state. At the beginning of the process a is taken to be 1, 
  ;; and the answer is given by the value of a at the end of the process. 
  ;; In general, the technique of defining an invariant quantity that remains 
  ;; unchanged from state to state is a powerful way to think about 
  ;; the design of iterative algorithms.)

  (defn- square [x] (* x x))
  (defn- half [x] (quot x 2))

  (defn fast-expt
    [b n]
    (loop [a 1
           b b
           n n]
      (let [a-multiplier (if (even? n) 1 b)]
        (if (= n 0)
          a
          (recur (* a-multiplier a) (square b) (half n))))))

  (fast-expt 2 0)
  ;; 1
  (fast-expt 1 1)
  ;; 1
  (fast-expt 2 2)
  ;; 4
  (fast-expt 2 5)
  ;; 32
  (fast-expt 2 20)
  ;; 1048576

  :rcf)