package cn.com.ssm.Test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TestSocketChannel {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",9999));
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String str = "取";
        buf.put(str.getBytes());
        buf.flip();
        while(buf.hasRemaining()){
            int byteRead = socketChannel.write(buf);
            System.out.println("写入了："+byteRead);
        }
        socketChannel.close();
        System.out.println("点点滴滴");
    }
}
