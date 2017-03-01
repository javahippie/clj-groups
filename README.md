[![Stories in Ready](https://badge.waffle.io/javahippie/clj-groups.png?label=ready&title=Ready)](https://waffle.io/javahippie/clj-groups)
# clj-groups

[![Build Status](https://travis-ci.org/javahippie/clj-groups.svg?branch=master)](https://travis-ci.org/javahippie/clj-groups)

This Clojure library should serve as an idiomatic wrapper around the great JGroups 4.0.0 Java library from Bela Ban. As a feature-complete wrapper is a challenging project and time is short on our hands, this is not complete, yet.

## Shortcomings
We are not there, yet. If you would like to work with us on this project, just send a short message, we are happy about any help, with any skilllevel. 
For now, you can create channels which will cluster automatically with other channels. You can not pass custom settings into the channel, this is planned for version 0.1.0.

## Usage
### Create channels
It is possible to create multiple channels, which are identified by keywords. As JGroups works with callbacks, you need to provide these callback functions upon creation of the channel in a map: 

```clojure
(clj-groups.channel/connect! :channel-id
							 {:receive (fn [msg] (println msg)}
```
You only need to specify the callbacks that you really want to use. Below is an example with all possible callbacks specified.

```clojure
(def callbacks
  {:receive 
  	(fn [msg] (println msg) )
   :get-state 
   	(fn [output] (println output)
   :set-state 
   	(fn [input] (println input)
   :view-accepted 
   	(fn [view] (println view))
   :suspect 
   	(fn [mbr] (println mbr))
   :block 
   	(fn [] (println "Block")) 
   :unblock 
   	(fn [] (println "Unblock"))})
   
(clj-groups.channel/connect! :channel-id 
						  	 callbacks)
```
This will create a channel which is stored in an atom inside the clj-channel namespace. It can be accessed in further operations via the given identifier.

### Send messages
One of these operations is sending messages:

```clojure
(clj-groups.channel/send-message! :channel-id 
								  {:target  nil 
								   :message "This is your message"})
```
This will propagate the message to the participiants of the cluster 'channel-id'. It will be processed inside the `receive` callback.

### Close channels
Channels can also be closed, to detach your application from the cluster. 

```clojure
(clj-groups.channel/close! :channel-id)
```

This will close the channel and remove it from the state. It is no longer accessible.

### List channels
It is possible to open multiple channels, which will be stored and can be accessed via their identifiers. To check which channels exist, the `opened-channels` function is available:

```clojure
(clj-groups.channel/opened-channels)

> {:channel-1 :channel-2}
```


## License
Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
