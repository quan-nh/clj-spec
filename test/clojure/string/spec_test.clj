(ns clojure.string.spec-test
  (:require [clojure.string.spec]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [orchestra.spec.test :as st]))

(st/instrument)
(set! s/*explain-out* expound/printer)

(clojure.string/replace 1 2 3)

(clojure.string/replace "1" 2 3)

(clojure.string/replace "1" "2" 3)

(clojure.string/replace "1" "2" \a)

(clojure.string/replace "1" "2" "3")

(clojure.string/replace "abc" \a :b)

(clojure.string/replace "abc" \a "b")

(clojure.string/replace "abc" \a \b)

(clojure.string/replace "abc" #"a" \b)

(clojure.string/replace "abc" #"a" "b")

(clojure.string/replace "abc" #"a" {"a" "b"})

(clojure.string/replace "abc" #"a" #(str % %))

(clojure.string/replace "abc" #"a" (fn [s] (str s s)))
