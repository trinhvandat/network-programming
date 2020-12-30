package com.ptit.tcp.inputstream;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ByteStreamClient {

    private final static Logger logger = Logger.getLogger(String.valueOf(ByteStreamClient.class));

    private static final int PORT = 1108;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try{
            Socket socket = new Socket(HOST, PORT);

            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String studentInfo = "B17DCCN123;1108";
            dataOutputStream.writeUTF(studentInfo);

            String myExam = "";
            logger.info("exam: " + myExam);
            int examValueInt = 0;
            while ((examValueInt = dataInputStream.read()) != -1){
                myExam += (char) examValueInt;
            }
            logger.info("exam: " + myExam);

            String[] myExamStringsArray = myExam.split(";");
            List<Double> myExamDoubleList = new ArrayList<>();
            for (String exam : myExamStringsArray){
                myExamDoubleList.add(Double.valueOf(exam));
            }
            logger.info("double list: " + myExamDoubleList.toString());
        } catch (UnknownHostException e) {
            logger.warning("unknown host tcp server");
            e.printStackTrace();
        } catch (IOException e) {
            logger.warning("I/O error: please check instance socket at line: 17");
            e.printStackTrace();
        }
    }

}
