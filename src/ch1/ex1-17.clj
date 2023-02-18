(ns ch1.ex1-17)

(comment
;; Exercise 1.17: The exponentiation algorithms in this section are 
;; based on performing exponentiation by means of repeated multiplication. 
;; In a similar way, one can perform integer multiplication by means of repeated addition. 
;; The following multiplication procedure 
;; (in which it is assumed that our language can only add, not multiply) 
;; is analogous to the expt procedure:
  (defn *
    [a b]
    (if (= b 0)
      0
      (+ a (* a (- b 1)))))
;; This algorithm takes a number of steps that is linear in b. 
;; Now suppose we include, together with addition, operations double, 
;; which doubles an integer, and halve, which divides an (even) integer by 2. 
;; Using these, design a multiplication procedure analogous to 
;; fast-expt that uses a logarithmic number of steps.

  (defn- double [n] (+ n n))
  (defn- halve [n] (quot n 2))

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

  (fast-mul 1000 0)  ;; 0
  (fast-mul 0 1000)  ;; 0
  (fast-mul 2 2)  ;; 4
  (fast-mul 2 3)  ;; 6
  (fast-mul 23 73)  ;; 1679
  (fast-mul 123456789 987654321)  ;; 121932631112635269

  :rcf)