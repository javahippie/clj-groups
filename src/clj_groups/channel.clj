(ns clj-groups.channel
  (:gen-class))

(def channel (atom {}))

(defn reify-test []
  (reify org.jgroups.Receiver
    (^void receive [this 
                    ^org.jgroups.Message msg]
      (println msg))
    (getState [this
                     output]
      (println output))
    (setState [this
               input]
      (println input))
    (viewAccepted [this
                   view]
      (println view))
    (suspect [this
              mbr]
      (println mbr))
    (block [this]
      (println "block"))
    (unblock [this]
      (println "unblock"))))

(defn- connect!
  "Joins to the specified cluster"
  [channel identifier callback]
  (.setReceiver channel (reify-test))
  (.connect channel identifier))

(defn setup! 
  "Creates an instance of a channel and connects it via the given identifier. Uses default protocol settings" 
  [identifier callback]
  (reset! channel (org.jgroups.JChannel.))
  (connect! @channel identifier callback))

(defn setup-with-settings!
  "Creates an instance of a channel and connects it via the given identifier. Uses the passed settings"
  [identifier settings]
  (reset! channel (org.jgroups.JChannel. settings))
  (connect! @channel identifier))

(defn send-message! 
  "Sends a message into the channel"
  [{^org.jgroups.Address target :target
    ^java.lang.Object payload :message}]   
  (.send @channel (org.jgroups.Message. target 
                                        payload)))
 
(defn teardown!
  "Closes the existing JChannel"
  []
  (.close @channel)
  (reset! channel {}))

