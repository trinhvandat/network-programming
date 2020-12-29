package com.ptit.tcp.datainputstream;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class DataInputStreamClient {

    private static final Logger looger = Logger.getLogger(String.valueOf(DataInputStreamClient.class));

    private static final int PORT = 1108;
    private static final String HOST_NAME = "localhost";

    public static void main(String[] args) {

        try {
            Socket socket = new Socket(HOST_NAME, PORT);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            String studentInfoSendingToServer = "B17DCCN123;TrinhVanDat";
            looger.info("send information of student to server with student's code = " + studentInfoSendingToServer.split(";")[0]);
            dataOutputStream.writeUTF(studentInfoSendingToServer);

            String reserveExam = dataInputStream.readUTF();
            looger.info("My exam: " + reserveExam);

            looger.info("send result: " + reserveExam.split(";")[0]);
            dataOutputStream.writeUTF(reserveExam.split(":")[0]);

            String result = dataInputStream.readUTF();
            looger.info("Result: " + result);

            socket.close();
        } catch (UnknownHostException e) {
            looger.warning("server not found " + e);
            e.printStackTrace();
        } catch (IOException e) {
            looger.warning("I/O error: " + e);
            e.printStackTrace();
        }
    }
}