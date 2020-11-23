package ro.ubb.implementations;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHAEncryption {
     public static String get_SHA1(String password){
        String generatedPass=null;
        try {
            MessageDigest md=MessageDigest.getInstance("SHA-1");
            //md.update(salt);
            byte[] bytes=md.digest(password.getBytes());
            StringBuilder stringBuilder=new StringBuilder();
            for (int i=0;i<bytes.length;i++){
                stringBuilder.append(Integer.toString((bytes[i]&0xff)+0x100,16).substring(1));
            }
            generatedPass=stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPass;
    }
//    private static byte[] getSalt() throws NoSuchAlgorithmException {
//        SecureRandom sr=SecureRandom.getInstance("SHA1PRNG");
//        byte[] salt=new byte[16];
//        sr.nextBytes(salt);
//        return salt;
//    }
}
