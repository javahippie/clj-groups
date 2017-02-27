(ns clj-groups.channel
  (:require [clj-groups.receiver :as receiver]))

(def channel (atom {}))

(defn- instantiate!
  "Joins to the specified cluster"
  [channel identifier callback]
  (.setReceiver channel callback)
  (.connect channel identifier))

(defn connect! 
  "Creates an instance of a channel and connects it via the given identifier. Uses default protocol settings" 
  [identifier callbacks]
  (swap! channel conj {identifier (org.jgroups.JChannel.)})
  (instantiate! (identifier @channel) (name identifier) (receiver/build callbacks)))

(defn connect-with-settings!
  "Creates an instance of a channel and connects it via the given identifier. Uses the passed settings"
  [identifier settings]
  (reset! channel (org.jgroups.JChannel. settings))
  (instantiate! @channel identifier))

(defn send-message! 
  "Sends a message into the channel"
  [{^org.jgroups.Address target :target
    ^java.lang.Object payload :message}]   
  (.send @channel (org.jgroups.Message. target 
                                        payload)))
 
(defn close!
  "Closes the existing JChannel"
  [identifier]
  (.close (identifier @channel))
  (swap! channel dissoc identifier))

 
