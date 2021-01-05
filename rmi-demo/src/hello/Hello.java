package hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {

    public String greeting(String name) throws RemoteException;

}
