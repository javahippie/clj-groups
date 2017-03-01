(ns clj-groups.channel
  (:require [clj-groups.receiver :as receiver])
  (:gen-class))

(defn- instantiate
  "Joins to the specified cluster"
  [channel identifier callback]
  (.setReceiver channel callback)
  (.connect channel identifier)
  channel)

(defn connect! 
  "Creates an instance of a channel and connects it via the given identifier. Uses default protocol settings" 
  [identifier callbacks]
  (instantiate (org.jgroups.JChannel.) 
               identifier 
               (receiver/build callbacks)))

(defn connect-with-settings-file!
  "Creates an instance of a channel and connects it via the given identifier. Uses the passed settings"
  [identifier callbacks settings]
  (instantiate (org.jgroups.JChannel. settings) 
               identifier 
               (receiver/build callbacks)))

(defn send-message! 
  "Sends a message into the channel"
  [channel
   {^org.jgroups.Address target :target
    ^java.lang.Object payload :message}]   
  (.send  channel (org.jgroups.Message. target 
                                        payload)))
 
(defn close!
  "Closes the existing JChannel"
  [channel]
  (.close channel))
