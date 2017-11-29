(ns clojure.string.spec-test
  (:require [clojure.string.spec]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [expound.alpha :as expound]
            [orchestra.spec.test :as st]))

;(stest/instrument)
(st/instrument)
(set! s/*explain-out* expound/printer)

(clojure.string/reverse 123)
(clojure.string/reverse "abc")

(clojure.string/re-quote-replacement 123)
(clojure.string/re-quote-replacement "abc")
(clojure.string/re-quote-replacement "a\\bc$1")

(clojure.string/replace "1" 2 3)
(clojure.string/replace-first "1" 2 3)

(clojure.string/join 1)
(clojure.string/join 1 2)
(clojure.string/join 1 [2 3])

(clojure.string/capitalize 1)
(clojure.string/capitalize "heLLO")

(clojure.string/upper-case 1)
(clojure.string/upper-case "heLLO")

(clojure.string/lower-case 1)
(clojure.string/lower-case "heLLO")

(clojure.string/split 1 2)
(clojure.string/split "a b c" 2)
(clojure.string/split "a b c" #"\s")
(clojure.string/split "a b c" #"\s" "s")

(clojure.string/split-lines 1)
(clojure.string/split-lines "a")
(clojure.string/split-lines "a\n1")

(clojure.string/trim 1)
(clojure.string/trim " a  ")

(clojure.string/triml 1)
(clojure.string/triml " a  ")

(clojure.string/trimr 1)
(clojure.string/trimr " a  ")

(clojure.string/trim-newline 1)
(clojure.string/trim-newline " a\r\n")

(clojure.string/blank? 1)
(clojure.string/blank? "")

(clojure.string/escape 1 2)
(clojure.string/escape "a" 1)
(clojure.string/escape "abc" {"a" 1})
(clojure.string/escape "abc" {})
(clojure.string/escape "abc" {\a 1})

(clojure.string/index-of 1 2)
(clojure.string/index-of "abc" 2)
(clojure.string/index-of "abc" \a)
(clojure.string/index-of "abc" 1 2)

(clojure.string/last-index-of 1 2)
(clojure.string/last-index-of "abc" 2)
(clojure.string/last-index-of "abc" \a)
(clojure.string/last-index-of "abc" 0 0)

(clojure.string/starts-with? 1 2)
(clojure.string/starts-with? "abc" 2)
(clojure.string/starts-with? "abc" \a)
(clojure.string/starts-with? "abc" "a")

(clojure.string/ends-with? 1 2)
(clojure.string/ends-with? "abc" 2)
(clojure.string/ends-with? "abc" \a)
(clojure.string/ends-with? "abc" "a")

(clojure.string/includes? 1 2)
(clojure.string/includes? "abc" 2)
(clojure.string/includes? "abc" \a)
(clojure.string/includes? "abc" "a")
