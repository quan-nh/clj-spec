(ns clojure.string.spec
  "Spec clojure.string utilities."
  (:require [clojure.spec.alpha :as s])
  (:import (java.util.regex Pattern)))

(defn- pattern? [p] (instance? Pattern p))

(s/fdef clojure.string/reverse
        :args (s/cat :s string?)
        :ret string?
        :fn (s/and #(= (count (:ret %)) (count (-> % :args :s)))
                   #(= (clojure.string/reverse (:ret %)) (-> % :args :s))))

(s/fdef clojure.string/re-quote-replacement
        :args (s/cat :replacement string?)
        :ret string?
        :fn #(>= (count (:ret %)) (count (-> % :args :replacement))))

(s/fdef clojure.string/replace
        :args (s/alt :char-char (s/cat :s string?
                                       :match char?
                                       :replacement char?)
                     :string-string (s/cat :s string?
                                           :match string?
                                           :replacement string?)
                     :pattern-string (s/cat :s string?
                                            :match pattern?
                                            :replacement string?)
                     :pattern-function (s/cat :s string?
                                              :match pattern?
                                              :replacement ifn?))
        :ret string?)

(s/fdef clojure.string/replace-first
        :args (s/alt :char-char (s/cat :s string?
                                       :match char?
                                       :replacement char?)
                     :string-string (s/cat :s string?
                                           :match string?
                                           :replacement string?)
                     :pattern-string (s/cat :s string?
                                            :match pattern?
                                            :replacement string?)
                     :pattern-function (s/cat :s string?
                                              :match pattern?
                                              :replacement ifn?))
        :ret string?)

(s/fdef clojure.string/join
        :args (s/alt :coll (s/cat :coll coll?)
                     :sep+coll (s/cat :separator any?
                                      :coll coll?))
        :ret string?)

(s/fdef clojure.string/capitalize
        :args (s/cat :s string?)
        :ret string?
        :fn #(= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/upper-case
        :args (s/cat :s string?)
        :ret string?
        :fn #(= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/lower-case
        :args (s/cat :s string?)
        :ret string?
        :fn #(= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/split
        :args (s/alt :re (s/cat :s string? :re pattern?)
                     :re+limit (s/cat :s string? :re pattern? :limit int?))
        :ret (s/coll-of string? :kind vector?))

(s/fdef clojure.string/split-lines
        :args (s/cat :s string?)
        :ret (s/coll-of string? :kind vector?)
        :fn #(<= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/trim
        :args (s/cat :s string?)
        :ret string?
        :fn #(<= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/triml
        :args (s/cat :s string?)
        :ret string?
        :fn #(<= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/trimr
        :args (s/cat :s string?)
        :ret string?
        :fn #(<= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/trim-newline
        :args (s/cat :s string?)
        :ret string?
        :fn #(<= (count (:ret %)) (count (-> % :args :s))))

(s/fdef clojure.string/blank?
        :args (s/cat :s string?)
        :ret boolean?)

(s/fdef clojure.string/escape
        :args (s/cat :s string?
                     :cmap (s/map-of char? any?))
        :ret string?)

(defn- str-or-char? [s] (or (string? s) (char? s)))

(s/fdef clojure.string/index-of
        :args (s/alt :idx (s/cat :s string?
                                 :value str-or-char?)
                     :idx+from (s/cat :s string?
                                      :value str-or-char?
                                      :from-index int?))
        :ret (s/nilable int?))

(s/fdef clojure.string/last-index-of
        :args (s/alt :idx (s/cat :s string?
                                 :value str-or-char?)
                     :idx+from (s/cat :s string?
                                      :value str-or-char?
                                      :from-index int?))
        :ret (s/nilable int?))

(s/fdef clojure.string/starts-with?
        :args (s/cat :s string?
                     :substr string?)
        :ret boolean?)

(s/fdef clojure.string/ends-with?
        :args (s/cat :s string?
                     :substr string?)
        :ret boolean?)

(s/fdef clojure.string/includes?
        :args (s/cat :s string?
                     :substr string?)
        :ret boolean?)
