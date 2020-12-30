package com.ptit.tcp.inputstream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ByteStreamServer {

    private static Logger logger = Logger.getLogger(String.valueOf(ByteStreamServer.class));

    private static final int PORT = 1108;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            logger.info("listening to port:" + PORT);

            while(true){
                Socket socket = serverSocket.accept();
                logger.info("connecting with client: " + socket.getInetAddress() + ":" + socket.getPort());

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream;

                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream;

                dataInputStream = new DataInputStream(inputStream);
                String studentInfoReceived = dataInputStream.readUTF();
                String[] studentInfoStringArrays = studentInfoReceived.split(";");
                logger.info("student info: " + studentInfoStringArrays[0].toLowerCase());

                dataOutputStream = new DataOutputStream(outputStream);
                if (studentInfoStringArrays[0].toLowerCase().equals("b17dccn123")) {
                    logger.info("Student's information exactly!");
                    String exam = "";
                    for (int index = 0; index <= 10; index ++){
                        exam += Math.random() + " ";
                    }
                    exam += Math.random();
                    exam = "1;2;3;4;5";
                    logger.info("exam for student: " + exam);
                    byte[] examBytesArray = exam.getBytes();
                    logger.info("all byte count: " + examBytesArray.length);
                    dataOutputStream.write(examBytesArray);
                    logger.info("send exam to student with student's code: " + studentInfoStringArrays[0].toLowerCase() + " successful.");
                    dataOutputStream.close();
                }
                else {
                    logger.warning("Incorrect student's information");
                    String returnResultVerifyStudentInfo = "Incorrect student's information. Please check your student's information !!!";
                    byte[] returnResultVerifyStudentInfoBytesArray = returnResultVerifyStudentInfo.getBytes();
                    dataOutputStream.write(returnResultVerifyStudentInfoBytesArray);
                    dataOutputStream.close();
                }



            }

        } catch (IOException e) {
            logger.warning("I/O error: " + e);
            e.printStackTrace();
        }
    }

}
