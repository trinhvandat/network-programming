package com.ptit.tcp.characterstream;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * author: Leonard Trinh
 *
 * example: read by BufferReader
 * example: write by PrintWriter
 */
public class CharacterStreamClient {

    private static final Logger logger = Logger.getLogger(String.valueOf(CharacterStreamClient.class));

    private static final int SERVER_PORT = 1108;
    private static final String SERVER_HOST = "localhost";

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            logger.info("Connecting to server: " + SERVER_HOST + ":" + SERVER_PORT);

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            String studentInfo = "B17DCCN123;Trinh Van Dat";
            logger.info("Student's info is sent to server: " + studentInfo);
            printWriter.write(studentInfo);
            /**
             * when I send with printWriter, if I don't close it, it will not received by server.
             */

            String replyFromServer  = bufferReader.readLine();
            logger.info("reply from server: " + replyFromServer);

        } catch (IOException e) {
            logger.warning("I/O error: please check code at line: 16");
            e.printStackTrace();
        }
    }

}
