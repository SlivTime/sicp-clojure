(ns ch1.ex1-18)

(comment
;; Exercise 1.18: Using the results of Exercise 1.16 and Exercise 1.17, 
;; devise a procedure that generates an iterative process for multiplying 
;; two integers in terms of adding, doubling, and halving and uses a 
;; logarithmic number of steps.

  (defn- square [x] (* x x))
  (defn- double [n] (+ n n))
  (defn- halve [n] (quot n 2))

  (defn fast-expt
    [b n]
    (loop [a 1
           b b
           n n]
      (let [a-multiplier (if (even? n) 1 b)]
        (if (= n 0)
          a
          (recur (* a-multiplier a) (square b) (halve n))))))

  (defn fast-mul
    [a b]
    (cond
      (= a 0) 0
      (= b 0) 0
      (> b a) (fast-mul b a)
      :else (loop [a a b b acc 0]
              (let [carry (if (odd? b) a 0)]
                (if (= b 1)
                  (+ a acc)
                  (recur (double a) (halve b) (+ acc carry)))))))

  (fast-expt 2 0)  ;; 1
  (fast-expt 1 1)  ;; 1
  (fast-expt 2 2)  ;; 4
  (fast-expt 2 5)  ;; 32
  (fast-expt 2 20)  ;; 1048576

  (fast-mul 1000 0)  ;; 0
  (fast-mul 0 1000)  ;; 0
  (fast-mul 2 2)  ;; 4
  (fast-mul 2 3)  ;; 6
  (fast-mul 23 73)  ;; 1679
  (fast-mul 123456789 987654321)  ;; 121932631112635269
  :rcf)