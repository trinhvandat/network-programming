package hello;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server{

    public static void main(String[] args) {
        try {
            HelloIml helloIml = new HelloIml();
            Registry registry = LocateRegistry.createRegistry(1109);
            registry.bind("hello", helloIml);

            System.err.println("Server ready");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }


}
