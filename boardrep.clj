(ns chess.board
  (:require [clojure.string :as str]
    	    [clojure.edn :as edn]
    	    [clojure.pprint :as pp]))

;converts char to int
(defn char-to-int [ch]
  (- (int ch) 97))

;function for exponents
(defn exp [x n]
  (if (zero? n) 1
    (* x (exp x (dec n)))))


;converts chess notation to 64 bit integer    
(defn notation-to-int [notation]
  (if (> (count notation) 2)
    (println notation " is greater than 2 characters.")
    (exp 2 (+ (char-to-int (char (subs notation 0 1)))
      	      (* 8 (int (subs notation 1 2))))))))

(defn bin-to-board [bin]
  (let [board (apply str (reverse bin))]
  
  
;converts notation to bitmap
(defn notation-to-board [& notation]
  (bin-to-board Integer/toBinaryString (reduce + (map #(notation-to-int %) notation))))
    
(defn king-moves [notation])