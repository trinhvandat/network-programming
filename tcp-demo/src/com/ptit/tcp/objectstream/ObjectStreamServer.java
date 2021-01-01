package com.ptit.tcp.objectstream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
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

                Object objectInfo = objectInputStream.readObject();
                Student studentInfo = (Student) objectInfo;

                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                String studentCode = studentInfo.getStudentCode();
                logger.info("student's code: " + studentCode);

                if (isStudent(studentCode)){
                    String exam = getExample();
                    objectOutputStream.writeObject((Object) exam);
                    objectOutputStream.flush();
                }
                else {
                    String message = "Invalid student's code.";
                    objectOutputStream.writeObject((Object) message);
                    objectOutputStream.flush();
                }

            }
        } catch (IOException e) {
            logger.warning("I/O error at line 16");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            logger.info("class not found exception.");
            e.printStackTrace();
        }

    }

    private static boolean isStudent(String studentCode){
        boolean result = false;
        if (studentCode.toLowerCase().equals("b17dccn123")){
            result = true;
        }
        return result;
    }

    private static String getExample(){
        /**
         * random variable with int value between 0 to 25;
         */
        Random random = new Random();

        String exam = "";
        for (int index = 0; index < 9; index ++){
            exam += random.nextInt(25) + ";";
        }
        exam += random.nextInt(25);

        return exam;
    }

}
