package calculate;

import calculate.AdderRemote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {
        try {
            AdderRemote adderRemote = new AdderRemote();
            System.out.println("Exporting calculate.Adder!");

            Registry registry = LocateRegistry.createRegistry(1109);
            registry.bind("add", adderRemote);
            System.out.println("register ok");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
