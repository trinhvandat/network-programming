package string;

import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

public class Client {

    private static final Logger logger = Logger.getLogger(String.valueOf(Client.class));

    private static final int PORT = 1108;
    private static final String HOST = "localhost";


    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getByName(HOST);
            DatagramSocket socket = new DatagramSocket(1109);

            String message = "hello";
            byte[] bytes = message.getBytes();
            DatagramPacket receiveMessage = new DatagramPacket(bytes, bytes.length, address, PORT);
            socket.send(receiveMessage);

            byte[] responseBytes = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBytes, responseBytes.length, address, PORT);
            socket.receive(response);
            System.out.println(new String(responseBytes, 0, responseBytes.length));

        } catch (UnknownHostException e) {
            logger.warning("Unknown host: " + HOST);
            e.printStackTrace();
        } catch (SocketException e) {
            logger.warning("socket exception . . .");
            e.printStackTrace();
        } catch (IOException e) {
            logger.warning("I/O error");
        }
    }
}
