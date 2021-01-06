package hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloIml extends UnicastRemoteObject implements Hello {

    protected HelloIml() throws RemoteException {
        super();
    }

    @Override
    public String greeting(String name) throws RemoteException {
        return "Hello " + name;
    }
}
