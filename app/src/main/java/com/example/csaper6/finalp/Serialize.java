package com.example.csaper6.finalp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/**
 * Created by csaper6 on 6/5/17.
 */

public class Serialize {
    public static byte[] Serialize(PublicKey key)
    {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        try {
            ObjectOutputStream keystream = new ObjectOutputStream(byteArray);
            keystream.writeObject(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray.toByteArray();
    }
    public static PublicKey DeSerialize(byte[] bytes)
    {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                return (PublicKey) objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
