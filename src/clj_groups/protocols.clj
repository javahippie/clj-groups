(ns clj-groups.protocols)

(defn- apply-parameters!
  "Calls the 'setField' method for each key value pair provided"
  [protocol parameters]
  (map #(.setValue protocol 
                   (name (key %)) 
                   (val %))
       parameters)
  protocol) ;; return the modified protocol

(defn abp
  "Alternating Bit Protocol, for reliable p2p unicasts. Experimental!"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.ABP.) parameters))

(defn asym-encrypt
  "Asymmetric encryption protocol. The secret key for encrypting and decrypting messages is fetched from a key server"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.ASYM_ENCRYPT.) parameters))

(defn auth
  "Provided authentication of joiners to prevent unauthorized joining to the cluster."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.AUTH.) parameters))

(defn barrier
  "Blocks all multicast threads when closed."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.BARRIER.) parameters))

(defn bping
  "Broadcast ping."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.BPING.) parameters))

(defn central-executor
  "Central executor service"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.CENTRAL_EXECUTOR.) parameters))

(defn central-lock
  "Locking protocol, which acquires locks by contacting the coordinator."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.CENTRAL_LOCK.) parameters))

(defn compress
  "Compresses messages to be sent, uncompresses received messages"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.COMPRESS.) parameters))

(defn counter
  "Protocol which provides a distributed counter"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.COUNTER.) parameters))

(defn daisychain
  "Implementation of daisychaining, sends messages to the next neighbor, and so on..."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.DAISYCHAIN.) parameters))

(defn delay-rnd
  "Delays in- and outgoing messages by a random number"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.DELAY.) parameters))

(defn delivery-time
  "Protocol measuring delivery time"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.DELIVERY_TIME.) parameters))

(defn discard
  "Discards up or down messages based on percentage"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.DISCARD.) parameters))

(defn discard-payload
  "Discards messages whose sequence number matches seqno 2 times"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.DISCARD_PAYLOAD.) parameters))

(defn dupl
  "Duplicates outgoing or incoming messages by copying them"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.DUPL.) parameters))

(defn fd
  "Failure detection based on simple heartbeat."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD.) parameters))

(defn fd-all
  "Failure detection based on simple heartbeat."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_ALL.) parameters))

(defn fd-all-2
  "Failure detection based on simple heartbeat."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_ALL2.) parameters))

(defn fd-host
  "Failure detection protocol which detects crashes or hangs of entire hosts"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_HOST.) parameters))

(defn fd-sock
  "Failure dection protocol, based on sockets."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FD_SOCK.) parameters))

(defn file-ping
  "Simple discovery protocol which uses a file on a shared storage."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FILE_PING.) parameters))

(defn flush
  "Forces group members to flush their pending messages."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.FLUSH.) parameters))

(defn fork
  "Multiplexes messages to different forks in the stack"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FORK.) parameters))

(defn forward-to-coord
  "Forwards a message to the current coordinator"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FORWARD_TO_COORD.) parameters))

(defn frag
  "Fragments packages larger than FRAG_SIZE into smaller packets."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FRAG.) parameters))

(defn frag-2
  "Fragments packages larger than FRAG_SIZE into smaller packets."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FRAG2.) parameters))

(defn frag-3
  "Fragments packages larger than FRAG_SIZE into smaller packets."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.FRAG3.) parameters))

(defn gms
  "Group membership protocol"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.GMS.) parameters))

(defn google-ping
  "Discovery protocol for google cloud storage."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.GOOGLE_PING.) parameters))

(defn hdrs
  "Prints the headers of all received or sent messages"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.HDRS.) parameters))

(defn jdbc-ping
  "Discovery protocol using a jdbc connection to a shared database"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.JDBC_PING.) parameters))

(defn make-batch
  "Intercepts individual up messages and passes them up as batches."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.MAKE_BATCH.) parameters))

(defn merge-3
  "Discovers subgroups, e.g. existing due to network partition."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.MERGE3.) parameters))

(defn mfc
  "Simple flow control protocol based on a credit system."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.MFC.) parameters))

(defn nakack-2
  "Negative acknowledgement layer"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.NAKACK2.) parameters))

(defn naming
  "Maintains mappings of addresses and their logical names"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.NAMING.) parameters))

(defn mping
  "Uses its own multicast socket to send and receive discovery requests"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.MPING.) parameters))

(defn pdc
  "Persistent discovery cache."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.PDC.) parameters))

(defn perf
  "Protocol measuring latency between stacks."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.PERF.) parameters))

(defn ping
  "Retrieves the initial membership by mcasting a discovery request."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.PING.) parameters))

(defn rackspace-ping
  "Discovery protocol based on Rackspace cloud storage."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.RACKSPACE_PING.) parameters))

(defn rate-limiter
  "Protocol which sends at most max_bytes in time_period milliseconds."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.RATE_LIMITER.) parameters))

(defn relay
  "Simple relaying protocol"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.RELAY.) parameters))

(defn rsvp
  "Implements synchronous acks for messages which have their rsvp flags set."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.RSVP.) parameters))

(defn s3-ping
  "Discovery protocol using Amazons S3 storage."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.S3_PING.) parameters))

(defn sasl
  "SASL protocol implements authentication."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SASL.) parameters))

(defn sequencer
  "Implementation of total order protocol using a sequencer"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SEQUENCER.) parameters))

(defn sequencer-2
  "Implementation of total order protocol using a sequencer_uum"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SEQUENCER2.) parameters))

(defn shared-loopback
  "Loopback transport shared by all channels within the same VM"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SHARED_LOOPBACK.) parameters))

(defn shared-loopback-ping
  "Discovery protocol running over shared-loopback only"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SHARED_LOOPBACK_PING.) parameters))

(defn shuffle
  "Reorders messages by buffering them and shuffling them after TIMEOUT ms"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SHUFFLE.) parameters))

(defn size
  "Protocol which prints out the real message size"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SIZE.) parameters))

(defn sniff
  "Protocol trying to print messages as strings"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SNIFF.) parameters))

(defn stable
  "Computes the broadcast messages that are stable"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.STABLE.) parameters))

(defn state
  "Streams the state to the state requester"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.STATE.) parameters))

(defn state-sock
  "Has the state provider create a server socket to which the state requester connects"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.STATE_SOCK.) parameters))

(defn state-transfer
  "Protocol based on byte array transfer"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.pbcast.STATE_TRANSFER.) parameters))

(defn stats
  "Provides various stats"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.STATS.) parameters))

(defn stomp
  "Protocol which provides STOMP support"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.STOMP.) parameters))

(defn swift-ping
  "Discovery protocol based on Openstack Swift"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SWIFT_PING.) parameters))

(defn sym-encrypt
  "Encrypts and decrypts communication by using a secret key shared by all cluster members"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.SYM_ENCRYPT.) parameters))

(defn tcp
  "TCP based protocol"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.TCP.) parameters))

(defn tcp-gossip
  "Retrieves the initial membership"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.TCPGOSSIP.) parameters))

(defn tcp-ping
  "Defines a static cluster membership"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.TCPPING.) parameters))

(defn tcp-nio2
  "Protocol using TCP for sending and retrieving messages. Uses nonblocking IO"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.TCP_NIO2.) parameters))

(defn trace
  "Trace."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.TRACE.) parameters))

(defn tunnel
  "Experimental replacement for UDP."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.TUNNEL.) parameters))


(defn udp
  "IP multicast transport based on UDP."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.UDP.) parameters))

(defn ufc
  "Simple flow control protocol based on a credit system."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.UFC.) parameters))

(defn unicast-3
  "Reliable unicast protocol using a combination of positive and negative acks"
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.UNICAST3.) parameters))


(defn verify-suspect
  "Catches SUSPECT events, traveling up the stack."
  [& [parameters]]
  (apply-parameters! (org.jgroups.protocols.VERIFY_SUSPECT.) parameters))
