(ns ch1.ex1-3)

;; Exercise 1.3: Define a procedure that takes three numbers 
;; as arguments and returns the sum of the squares 
;; of the two larger numbers.
(comment

  (defn- square [n]
    (* n n))

  (defn- extract-two-largest
    ([numbers]
     (take 2 (reverse (sort numbers)))))

  (defn squared-sum-of-two-largest
    "Returns the sum of the squares 
     of the two larger numbers.
     Can work with arbitrary number of arguments
     "
    [& numbers]
    (apply + (map square (extract-two-largest numbers))))

  (squared-sum-of-two-largest 1 2 3)
  ;; 13 

  (squared-sum-of-two-largest 1 2 3 4 5 5)
  ;; 50

  (squared-sum-of-two-largest)
  ;; 0
  
  (squared-sum-of-two-largest 2)
  ;; 4

  :rcf)
