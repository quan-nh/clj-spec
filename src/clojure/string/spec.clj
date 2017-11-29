(ns clojure.string.spec
  "Spec clojure.string utilities."
  (:require [clojure.spec.alpha :as s])
  (:import (java.util.regex Pattern)))

(defn- pattern? [p] (instance? Pattern p))

(s/fdef clojure.string/replace
        :args (s/alt :string-string (s/cat :s string?
                                           :match string?
                                           :replacement string?)
                     :char-char (s/cat :s string?
                                       :match char?
                                       :replacement char?)
                     :pattern-string (s/cat :s string?
                                            :match pattern?
                                            :replacement string?)
                     :pattern-function (s/cat :s string?
                                              :match pattern?
                                              :replacement ifn?))
        :ret string?)
