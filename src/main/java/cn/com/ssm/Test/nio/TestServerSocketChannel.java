package cn.com.ssm.Test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class TestServerSocketChannel {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        while(true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            int bytes = socketChannel.read(byteBuffer);

            while(bytes  != -1){
                CharBuffer charBuffer = CharBuffer.allocate(bytes);
                byteBuffer.flip();
                charsetDecoder.decode(byteBuffer,charBuffer,false);
                charBuffer.flip();
                while(charBuffer.hasRemaining()){
                    System.out.println(charBuffer.get());
                }
                charBuffer.clear();
            }
            socketChannel.close();
        }

    }
}
