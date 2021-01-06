package example;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private static RMIInterface look_up;

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        Registry registry = LocateRegistry.getRegistry(1108);
        look_up = (RMIInterface) registry.lookup("greeting");

        String text = JOptionPane.showInputDialog("what is your name?");
        String response = look_up.greeting(text);
        JOptionPane.showMessageDialog(null, response);
    }

}
