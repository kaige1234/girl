package cn.com.ssm.Test.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class test {
    public static void main(String[] args) throws IOException {
       ByteArrayOutputStream byteArrayOutputStream =
               new ByteArrayOutputStream();
       ObjectOutputStream objectOutputStream =
               new ObjectOutputStream(byteArrayOutputStream);
       //objectOutputStream.writeObject(ZhangSan);

    }
}
