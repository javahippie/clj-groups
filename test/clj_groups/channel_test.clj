(ns clj-groups.channel-test
  (:require [clojure.test :refer :all]
            [clj-groups.channel :refer :all]))

(def callbacks
  {:receive (fn receive [msg] (println (str "Message Accepted: " msg)) )
   :get-state nil
   :set-state nil
   :view-accepted (fn view-accepted [view] (println (str "View Accepted: " view)))
   :suspect nil
   :block (fn block [] (println "Block")) 
   :unblock (fn unblock [] (println "Unblock"))})


(deftest single-channel-creation
  
  (is 
   (not 
    (nil? 
     (connect! :test-case-1 
               callbacks))))

  (is
   (.contains (open-channels) :test-case-1))

  (close! :test-case-1)

  (is
   (not
    (.contains (open-channels) :test-case-1))))

(deftest multi-channel-creation

  (is 
   (not 
    (nil? 
     (connect! :test-case-1
               callbacks))))
  
  (is
   (.contains (open-channels) :test-case-1))

  (is
   (not
    (nil?
     (connect! :test-case-2
               callbacks))))

  (is
   (.contains (open-channels) :test-case-2))
    (close! :test-case-1)


  (is 
   (not
    (.contains (open-channels) :test-case-1)))

  (close! :test-case-2)

  (is
   (not
    (.contains (open-channels) :test-case-1))))
