package com.ptit.tcp.objectstream;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class ObjectStreamClient {

    private static final Logger logger = Logger.getLogger(String.valueOf(ObjectStreamClient.class));

    private static final int SERVER_PORT = 1108;
    private static final String SERVER_HOST = "localhost";

    public static void main(String[] args) {

        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            logger.info("Connected with server");

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            Student studentInfo = new Student("b17ddcn123", "Trinh Van Dat");
            objectOutputStream.writeObject((Object) studentInfo);
            objectOutputStream.close();

        } catch (IOException e) {
            logger.warning("I/O error at line 17");
            e.printStackTrace();
        }


    }

}
