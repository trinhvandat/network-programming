package string;

import java.io.IOException;
import java.net.*;
import java.util.logging.Logger;

public class Server {

    private static final Logger logger = Logger.getLogger(String.valueOf(Server.class));

    private static final int PORT = 1108;
    private static final String HOST = "localhost";

    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getByName(HOST);
            DatagramSocket socket = new DatagramSocket(PORT);

            while (true){
                byte[] message = new byte[1024];
                DatagramPacket receiveMessage = new DatagramPacket(message, message.length, address, PORT);
                socket.receive(receiveMessage);

                String mess = new String(message, 0, message.length);
                System.out.println(mess);

                String response = "system ok";
                System.out.println(socket.getInetAddress() + ":" + socket.getPort());
                DatagramPacket sendPackage = new DatagramPacket(response.getBytes(), response.getBytes().length,InetAddress.getByName("localhost"), 1109);
                socket.send(sendPackage);
            }
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
