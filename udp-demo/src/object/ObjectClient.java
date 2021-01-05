package object;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ObjectClient {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            final String hostName = "localhost";
            final InetAddress ipAddress = InetAddress.getByName(hostName);
            final int port = 1108;

            Student student = new Student("b17dccn123", "Trinh Van Dat");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(student);
            byte[] requestData = outputStream.toByteArray();

            final DatagramPacket request = new DatagramPacket(requestData, requestData.length, ipAddress, port);
            socket.send(request);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
