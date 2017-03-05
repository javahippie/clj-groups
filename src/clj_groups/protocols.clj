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
  "Returns an instance of the UDP protocol"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.UDP.) parameters))

(defn ping
  "Returns an instance of the PING protocol"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.PING.) parameters))

(defn merge-3
  "Returns an instance of the MERGE3 protocol"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.MERGE3.) parameters))

(defn fd-sock
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_SOCK.) parameters))

(defn fd-all
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_ALL.) parameters))

(defn verify-suspect
  ""
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.VERIFY_SUSPECT.) parameters))

(defn barrier
  ""
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
