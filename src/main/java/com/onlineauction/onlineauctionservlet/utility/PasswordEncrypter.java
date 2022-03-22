
package com.onlineauction.onlineauctionservlet.utility;

import java.math.BigInteger;
import java.security.MessageDigest;


public class PasswordEncrypter {

    public static String getSHA(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            System.out.println("Exception thrown" + " for incorrect algorithm: " + e);
            return null;
        }
    }

}
