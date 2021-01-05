package calculate;

import calculate.AdderRemote;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {
        try {
            AdderRemote adderRemote = new AdderRemote();
            System.out.println("Exporting calculate.Adder!");

            UnicastRemoteObject.exportObject(adderRemote);
            Naming.bind("rmi://localhost/add", adderRemote);
            System.out.println("Register adder");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
