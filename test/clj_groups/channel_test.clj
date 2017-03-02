(ns clj-groups.channel-test
  (:require [clojure.test :refer :all]
            [clj-groups.channel :refer :all]))

(deftest single-channel-creation
  (let [channel-1 (connect! "test-case-1"
                            {:receive (fn [msg] (println "test-case-1"))})]
    
    (is (.isOpen channel-1))
    
    (close! channel-1)
    (is (.isClosed channel-1))))

(deftest multi-channel-creation
  (let [channel-1 (connect! "test-case-1"
                            {:receive (fn [msg] (println "test-case-1"))})
        channel-2 (connect! "test-case-2"
                            {:receive (fn [msg] (println "test-case-2"))})]
    (is (.isOpen channel-1))
    (is (.isOpen channel-2))

    (close! channel-1)
    (close! channel-2)

    (is (.isClosed channel-1))
    (is (.isClosed channel-2))))
