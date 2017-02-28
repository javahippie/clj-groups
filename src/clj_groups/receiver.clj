(ns clj-groups.receiver)

(defn build [{receive-one :receive 
              get-state :get-state 
              set-state :set-state 
              view-accepted :view-accepted 
              suspect :suspect 
              block :block 
              unblock :unblock}]

  (reify org.jgroups.Receiver
    (^void receive [this 
                    ^org.jgroups.Message msg]
      (if (not (nil? receive-one))
        (receive-one msg)))

    (getState [this
               output]
      (if (not (nil? get-state))
        (get-state output)))

    (setState [this
               input]
      (if (not (nil? set-state))
        (set-state input)))


    (viewAccepted [this
                   view]
      (if (not (nil? view-accepted))
        (view-accepted view)))

    (suspect [this
              mbr]
      (if (not (nil? suspect))
        (suspect mbr)))

    (block [this]
      (if (not (nil? block))
        (block)))

    (unblock [this]
      (if (not (nil? unblock))
        (unblock)))))

