(ns chess.board
  (:require [clojure.string :as str]
    	    [clojure.edn :as edn]
    	    [clojure.pprint :as pp]))

(defn char-to-int [ch]
  (- (int ch) 97))

;function for exponents
(defn exp [x n]
  (if (zero? n) 1
    (* x (exp x (dec n)))))
    
(defn notation-to-bin [notation]
  (if (> (count notation) 2)
    (println notation " is greater than 2 characters.")
    (exp 2 (+ (char-to-int (char (subs notation 0 1)))
      	      (* 8 (int (char (subs notation 1 2))))))))
      
(defn notation-to-board [& notation]
  (map #(notation-to-bin %) notation)