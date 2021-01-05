package hello;

import java.rmi.RemoteException;

public class HelloIml implements Hello {

    @Override
    public String greeting(String name) throws RemoteException {
        return "Hello " + name;
    }
}
