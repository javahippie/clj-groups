(ns clj-groups.protocols)

(defn- apply-parameters!
  "Calls the 'setField' method for each key value pair provided"
  [protocol parameters]
  (map #(.setValue protocol 
                   (name (key %)) 
                   (val %))
       parameters)
  protocol)

(defn udp
  "IP multicast transport based on UDP."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.UDP.) parameters))

(defn ping
  "Retrieves the initial membership by mcasting a discovery request."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.PING.) parameters))

(defn merge-3
  "Discovers subgroups, e.g. existing due to network partition."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.MERGE3.) parameters))

(defn fd-sock
  "Failure dection protocol, based on sockets."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_SOCK.) parameters))

(defn fd-all
  "Failure detection based on simple heartbeat."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_ALL.) parameters))

(defn verify-suspect
  "Catches SUSPECT events, traveling up the stack."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.VERIFY_SUSPECT.) parameters))

(defn barrier
  "Blocks all multicast threads when closed."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.BARRIER.) parameters))

(defn nakack-2
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.NAKACK2.) parameters))

(defn unicast-3
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.UNICAST3.) parameters))

(defn stable
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.STABLE.) parameters))

(defn gms
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.GMS.) parameters))

(defn ufc
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.UFC.) parameters))

(defn mfc
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.MFC.) parameters))

(defn frag-2
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FRAG2.) parameters))
