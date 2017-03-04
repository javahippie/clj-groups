(ns clj-groups.protocols)

(defn udp
  ""
  [[tos :tos
    mcast-group-addr :mcast-group-addr
    mcast-port :mcast-port
    ip-mcast :ip-mcast
    ip-ttl :ip-ttl
    mcast-send-buffer-size :mcast-send-buffer-size
    mcast-recv-buffer-size :mcast-recv-buffer-size
    ucast-send-buffer-size :ucast-send-buffer-size
    ucase-recv-buffer-size :ucast-recv-buffer-size
    disable-loopback :disable-loopback
    suppress-time-out-of-buffer-space :suppress-time-out-of-buffer-space]])
