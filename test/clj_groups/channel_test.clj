(ns clj-groups.channel-test
  (:require [clojure.test :refer :all]
            [clj-groups.channel :refer :all]))

(deftest channel-creation
  (let [callbacks {:receive (fn receive [msg] (println (str "Message Accepted: " msg)) )
   :get-state nil
   :set-state nil
   :view-accepted (fn view-accepted [view] (println (str "View Accepted: " view)))
   :suspect nil
   :block (fn block [] (println "Block")) 
   :unblock (fn unblock [] (println "Unblock"))}]
    (is 
     (not 
      (nil? 
       (connect! :test-case 
               callbacks))))
    (is 
     (empty? 
         (close! :test-case)))))
