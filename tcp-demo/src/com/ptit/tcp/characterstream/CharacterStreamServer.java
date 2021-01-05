package com.ptit.tcp.characterstream;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Logger;

public class CharacterStreamServer {

    private final static Logger logger = Logger.getLogger(String.valueOf(CharacterStreamServer.class));
    private final static int SERVER_PORT = 1108;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            logger.info("listening to port: " + SERVER_PORT);

            while(true){
                Socket socket = serverSocket.accept();
                logger.info("connecting to client: " + socket.getInetAddress() + ":" + socket.getPort());

                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                String studentInfo = bufferedReader.readLine();
                logger.info("student's info: " + studentInfo);

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);

                System.out.println("output");

                if (verifyStudent(studentInfo.split(";")[0])){
                    logger.info("Correct student's code");
                    String exam = getExample();
                    printWriter.write(exam);
                    printWriter.flush();
                }
                else{
                    logger.warning("incorrect student's info");
                    String inValidInfo = "InCorrect student's code. Please check your student's code and try again. Thank you!!!";
                    printWriter.write(inValidInfo);
                    printWriter.flush();
                }

                printWriter.close();

            }
        } catch (IOException e) {
            logger.warning("I/O error: please check method instant serverSocket at line: 15");
            e.printStackTrace();

        }
    }

    private static boolean verifyStudent(String studentCode){
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
