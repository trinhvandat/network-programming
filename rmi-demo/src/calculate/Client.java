package calculate;

import calculate.Adder;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("find Object ...");
            Adder adder = (Adder) Naming.lookup("rmi://localhost:1108/add");

            System.out.println(adder.add(5, 6));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
