package com.ptit.tcp.datainputstream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;


public class DataInputSteamServer {

    private static final Logger logger = Logger.getLogger(String.valueOf(DataInputSteamServer.class));

    private static final int SERVER_PORT = 1108;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            logger.info("Server is listening on port: " + SERVER_PORT);

            while (true){
                Socket socket = serverSocket.accept();
                logger.info("New client connected . . .");
                logger.info("host: " + socket.getInetAddress() + "; port: " + socket.getPort());

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                String studentInfo = dataInputStream.readUTF();
                String[] studentInfoArrayString = studentInfo.split(";");

                String example = "";
                if (studentInfoArrayString[0].toLowerCase().endsWith("b17dccn123")){
                    for (int index = 0; index <= 10; index ++){
                        example = example + Math.random() + " ";
                    }
                    example += Math.random();
                    String loggingExample = "example: " + example;
                    logger.info(loggingExample);
                    dataOutputStream.writeUTF(example);
                }

                String receiveResultExam = dataInputStream.readUTF();
                if (receiveResultExam.endsWith(example.split(";")[0])){
                    String returnResult = "true";
                    dataOutputStream.writeUTF(returnResult);
                }
                else {
                    logger.warning("invalid student code . . .");
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
