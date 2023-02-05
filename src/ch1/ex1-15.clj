(ns ch1.ex1-15)

(comment
  ;; Exercise 1.15: The sine of an angle (specified in radians) 
  ;; can be computed by making use of the approximation 
  ;; sin x ≈ x if x is sufficiently small, and the trigonometric identity
  ;; sinx = 3 * sin(x/3) − 4 * (sin(x/3) ^ 3)
  ;; to reduce the size of the argument of sin. 
  ;; (For purposes of this exercise an angle is considered 
  ;; “sufficiently small” if its magnitude is not greater 
  ;; than 0.1 radians.) These ideas are incorporated in the 
  ;; following procedures:

  (def epsilon 0.1)
  (defn cube
    [x] (* x x x))
  (defn p
    [x]
    ;; (prn x)
    (- (* 3 x) (* 4 (cube x))))
  (defn sine
    [angle]
    ;; (prn angle)
    (if-not (> (abs angle) epsilon)
      angle
      (p (sine (/ angle 3.0)))))

  (sine 12.15)

  ;; a. How many times is the procedure p applied 
  ;; when (sine 12.15) is evaluated?

  "7 times with x being:"
  0.049999999999999996
  0.1495
  0.4351345505
  0.9758465331678772
  -0.7895631144708228
  -0.39980345741334

  (sine 100000)

  ;; b. What is the order of growth in space and number of 
  ;; steps (as a function of a) used by the process generated 
  ;; by the sine procedure when (sine a) is evaluated?

  "
   - Number of steps grow as log[3](a) , very slow
   - space is growing very slow too
   
   So it looks like logarythmic complexity function
   "

  :rcf)