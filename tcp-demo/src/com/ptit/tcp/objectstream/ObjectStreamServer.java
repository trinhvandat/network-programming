package com.ptit.tcp.objectstream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ObjectStreamServer {

    private static final Logger logger = Logger.getLogger(String.valueOf(ObjectStreamServer.class));

    private static final int SERVER_PORT = 1108;

    public static void main(String[] args) {

        try {
            final ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            logger.info("listening to port " + SERVER_PORT);

            while (true){
                Socket socket = serverSocket.accept();
                logger.info("connected to client . . .");

                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                Object objectInfo = objectInputStream.readObject();
                Student studentInfo = (Student) objectInfo;
                logger.info("Student's info: " + studentInfo.toString());

            }
        } catch (IOException e) {
            logger.warning("I/O error at line 16");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.info("class not found exception.");
            e.printStackTrace();
        }

    }

}
