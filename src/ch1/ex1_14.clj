(ns ch1.ex1-14)

(comment
  ;; Exercise 1.14: Draw the tree illustrating the process generated 
  ;; by the count-change procedure of Section 1.2.2 in making change 
  ;; for 11 cents. What are the orders of growth of the space and 
  ;; number of steps used by this process as the amount 
  ;; to be changed increases?

  (def kind-of-coins [1 5 10 25 50])

  (defn- cc
    [amount coins]
    (prn amount coins)  ;; Uncomment to illustrate execution process
    (cond
      (zero? amount) 1
      (neg? amount) 0
      (empty? coins) 0
      :else (+ (cc (- amount (first coins))
                   coins)
               (cc amount
                   (rest coins)))))
  (defn count-change
    [amount]
    (cc amount (reverse (sort kind-of-coins))))

  (count-change 100)
  ;; 292

  (count-change 11)
  ;; We can simply illustrate execution with just one print at the beginning
  ;; of the function. We can change `kind-of-coins` or amount to see what happens.
  ;; Actually for initial numbers - couns from 1 to 50 and 11 as amount
  ;; we have 54 calls of `cc` function which seems to be not very effective
  ;; It's execution time will grow very fast.

  :rcf)