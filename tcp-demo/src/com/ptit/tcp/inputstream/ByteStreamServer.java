package com.ptit.tcp.inputstream;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Logger;

public class ByteStreamServer {

    private static Logger logger = Logger.getLogger(String.valueOf(ByteStreamServer.class));

    private static final int PORT = 1108;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            logger.info("listening to port:" + PORT);

        } catch (IOException e) {
            logger.warning("I/O error: " + e);
            e.printStackTrace();
        }

    }

}
