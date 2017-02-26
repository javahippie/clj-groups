package de.cljgroups;

import org.jgroups.JChannel;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.Message;

public class ReceiverAdapterWrapper extends ReceiverAdapter {
    
    public void viewAccepted(View view) {
        System.out.println("** view: " + view);
    }

    public void receive(Message msg) {
        System.out.println(msg.getObject().toString());
    }

}
