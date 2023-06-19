package com.xingquan.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端
 *
 * @author pan jianghong
 * @version 1.0.0
 * @createdate 2023/6/19 14:56
 * @description socket服务端
 */
public class BioServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);

        while (true) {
            // 完全阻塞，只能监控一个链接的数据，只有这个链接断开之后，才能继续处理下一个链接的信息
            Socket accept = server.accept();
            System.out.println("建立新链接: " + accept.getInetAddress().getHostName() + ":" + accept.getPort());

            InputStream is = accept.getInputStream();

            byte[] in = new byte[1024];
            int len = 0;
            while ((len = is.read(in)) != -1) {
                System.out.println(new String(in, 0, len));
            }

        }

    }
}
