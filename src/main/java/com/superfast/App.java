package com.superfast;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import com.superfast.actors.MainActor;
import com.superfast.messages.StartMessage;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        ActorSystem actorSystem=ActorSystem.create("printerSystem");
        Props props =Props.create(MainActor.class);
        ActorRef mainCoordinator = actorSystem.actorOf(props);
        StartMessage startMessage=new StartMessage("Start Printing!!!!!!");
        Patterns.ask(mainCoordinator,startMessage,1000l);
    }
}
