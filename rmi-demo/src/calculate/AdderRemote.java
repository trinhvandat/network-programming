package calculate;

import calculate.Adder;

import java.rmi.RemoteException;

public class AdderRemote implements Adder {

    @Override
    public int add(int x, int y)throws RemoteException{
        return x + y;
    }
}
