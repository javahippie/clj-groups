(ns clj-groups.receiver)

(defn receiver [{receive :receive 
                 get-state :get-state 
                 set-state :set-state 
                 view-accepted :view-accepted 
                 suspect :suspect 
                 block :block 
                 unblock :unblock}]
  (reify org.jgroups.Receiver
    (^void receive [this 
                    ^org.jgroups.Message msg]
      (receive))
    (getState [this
                     output]
      (get-state))
    (setState [this
               input]
      (set-state))
    (viewAccepted [this
                   view]
      (view-accepted view))
    (suspect [this
              mbr]
      (suspect mbr))
    (block [this]
      (block))
    (unblock [this]
      (unblock))))

