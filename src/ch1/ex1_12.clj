(ns ch1.ex1-12)

(comment
  ;; Exercise 1.12: The following paern of numbers is called Pascal’s triangle.
  1
  1 1
  1 2 1
  1 3 3 1
  1 4 6 4 1
  ;; The numbers at the edge of the triangle are all 1, 
  ;; and each number inside the triangle is the sum of the 
  ;; two numbers above it. Write a procedure that computes 
  ;;   elements of Pascal’s triangle by means of a recursive process.

  ;; it is much more convenient to use 1-based indexing here
  (defn triangle-element
    [row item]
    (assert (and (>= row item)
                 (> row  0)
                 (> item 0)))
    (cond
      (= row 1) 1
      (= row item) 1
      (= item 1) 1
      :else (+ (triangle-element (dec row) (dec item))
               (triangle-element (dec row) item))))

  (triangle-element 1 1)
  (triangle-element 5 3)
  (triangle-element 10 5)


  (defn- print-row
    [row-num]
    (loop [item 1]
      (when (<= item row-num)
        (do
          (print (triangle-element row-num item) " ")
          (recur (inc item)))))
    (print "\n"))

  (defn print-rows
    [rows-num]
    (loop [row 1]
      (when (<= row rows-num)
        (do
          (print-row row))
        (recur (inc row)))))


  (print-rows 20)

    ;; This one is not very effective, so let's create iterative version
    ;; to build N rows

  (defn neighbor-pairs
    [seq]
    (map vector seq (rest seq)))

  (defn next-row-body
    [current-row]
    (map #(apply + %) (neighbor-pairs current-row)))

  (next-row-body '(1 3 3 1))

  (defn make-triangle
    [size]
    (loop [row-num 1
           row '(1)
           triangle [row]]
      (if (>= row-num size)
        triangle
        (let [next-row (concat '(1) (next-row-body row) '(1))]
          (recur (inc row-num)
                 next-row
                 (conj triangle next-row))))))

  (make-triangle 5)
  ;; [(1) (1 1) (1 2 1) (1 3 3 1) (1 4 6 4 1)]

  (defn- join-row
    [row]
    (clojure.string.join " " row))

  (defn as-string
    [triangle]
    (clojure.string.join "\n" (map #(join-row %) triangle)))

  (print (str (as-string (make-triangle 9)) "\n"))

  ;; 1
  ;; 1 1
  ;; 1 2 1
  ;; 1 3 3 1
  ;; 1 4 6 4 1
  ;; 1 5 10 10 5 1
  ;; 1 6 15 20 15 6 1
  ;; 1 7 21 35 35 21 7 1
  ;; 1 8 28 56 70 56 28 8 1

  :rcf)
