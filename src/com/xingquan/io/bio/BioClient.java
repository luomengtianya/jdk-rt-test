package com.xingquan.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * socket客户端
 *
 * @author pan jianghong
 * @version 1.0.0
 * @createdate 2023/6/19 15:08
 * @description socket客户端
 */
public class BioClient {

    public static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8088);

        executorService.scheduleAtFixedRate(()-> {
            try {
                OutputStream out = socket.getOutputStream();

                String message = socket.getLocalSocketAddress() + " hello word";
                out.write(message.getBytes());
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, 0, 3, TimeUnit.SECONDS);
    }
}
