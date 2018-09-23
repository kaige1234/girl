package cn.com.ssm.Test.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class TestNioSelector {

    public static void getSelector() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\tests.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //byteBuffer.position(3);
        int count = fileChannel.read(byteBuffer);
        fileChannel.truncate(3);
        while(count != -1){
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                System.out.println(byteBuffer.get());
            }
            byteBuffer.clear();
        }
        fileChannel.close();
        randomAccessFile.close();

    }

    public static void put() throws IOException {
        File file = new File("D:\\tests.txt");
        FileOutputStream  fileOutputStream = new FileOutputStream(file);
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(6);
           String str="123456";
        fileChannel.position(0);
           byteBuffer.put(str.getBytes());
           byteBuffer.flip();
           System.out.println("fileChannel.position()的值："+fileChannel.position());
          while(byteBuffer.hasRemaining()){
              fileChannel.write(byteBuffer);
              System.out.println("插入数据");
          }
        fileChannel.close();
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        TestNioSelector.getSelector();
    }
}
