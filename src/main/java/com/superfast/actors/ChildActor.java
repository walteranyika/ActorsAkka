package com.superfast.actors;

import akka.actor.AbstractActor;

import com.superfast.messages.PrintCompletedMessage;
import com.superfast.messages.PrintMessage;

/**
 * Created by waltersanchez on 8/17/18.
 */
public class ChildActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(PrintMessage.class, message->{
            System.out.println("Printing a certificate for "+message.getName());
            //tell the main actor that we have completed printing and what time?
            long time =System.currentTimeMillis();
            PrintCompletedMessage completed=new PrintCompletedMessage("Completed Printing "+message.getName(),time);
            this.getSender().tell(completed,this.getSelf());
        }).build();
    }
}
