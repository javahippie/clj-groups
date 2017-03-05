(ns clj-groups.channel-test
  (:require [clojure.test :refer :all]
            [clj-groups.channel :refer :all]
            [clj-groups.protocols :refer :all]))

(deftest channel-creation-single
  (let [channel-1 (connect! "test-case-1"
                            {:receive (fn [msg] (println "test-case-1"))})]
    
    (is (.isOpen channel-1))
    
    (close! channel-1)
    (is (.isClosed channel-1))))

(deftest channel-creation-multi
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

(deftest channel-creation-programmatically
  (let [channel-1 (connect-with-protocols! "test-case-1"
                                          {:receive (fn [msg] (println "test-case-1"))}
                                          [(udp {:bind-addr "127.0.0.1"})
                                           (ping)
                                           (merge-3)
                                           (fd-sock)
                                           (fd-all)
                                           (verify-suspect)
                                           (barrier)
                                           (nakack-2)
                                           (unicast-3)
                                           (stable)
                                           (gms)
                                           (ufc)
                                           (mfc)
                                           (frag-2)])]
    (is (.isOpen channel-1))

    (close! channel-1)
    
    (is (.isClosed channel-1))))
