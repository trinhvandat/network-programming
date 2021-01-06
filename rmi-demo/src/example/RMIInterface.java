package example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public String greeting(String name) throws RemoteException;

}
