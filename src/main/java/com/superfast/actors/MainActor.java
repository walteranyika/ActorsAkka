package com.superfast.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.superfast.messages.PrintCompletedMessage;
import com.superfast.messages.PrintMessage;
import com.superfast.messages.StartMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waltersanchez on 8/17/18.
 */
public class MainActor extends UntypedActor {
    @Override
    public void onReceive(Object receivedMessage) throws Throwable {
        if (receivedMessage instanceof StartMessage){
            PrintMessage printMessage1=new PrintMessage("John Mark","http://mark@yahoo.com","p11/222/3333");
            PrintMessage printMessage2=new PrintMessage("John Mary","http://mary@yahoo.com","p11/222/3334");
            PrintMessage printMessage3=new PrintMessage("John Juma","http://juma@yahoo.com","p11/222/3335");
            PrintMessage printMessage4=new PrintMessage("John Mike","http://mike@yahoo.com","p11/222/3336");
            List<PrintMessage> list=new ArrayList<>();
            list.add(printMessage1);
            list.add(printMessage2);
            list.add(printMessage3);
            list.add(printMessage4);
            for (PrintMessage message: list) {
                Props props =Props.create(ChildActor.class);
                ActorRef actorRef=this.context().actorOf(props);
                actorRef.tell(message,this.getSelf());
            }

        }else if(receivedMessage instanceof PrintCompletedMessage){
            PrintCompletedMessage printCompletedMessage= (PrintCompletedMessage) receivedMessage;
            System.out.println(printCompletedMessage.getMessage()+" "+printCompletedMessage.getTime());

        }else{
            this.unhandled(receivedMessage);
        }
    }
}
