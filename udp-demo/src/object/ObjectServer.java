package object;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class ObjectServer {

    private static final int PORT = 1108;

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            InetAddress ipAddress = InetAddress.getByName("localhost");

            byte[] requestData = new byte[1024];
            DatagramPacket request = new DatagramPacket(requestData, requestData.length);
            socket.receive(request);
            byte[] requestObject = request.getData();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestObject);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student.toString());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
