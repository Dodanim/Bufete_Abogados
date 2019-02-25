/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;
import java.security.MessageDigest;
/**
 *
 * @author KiDo
 */
public class SecurityUtils {
    public static String encriptarSHA(String val) throws Exception {

        MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
        byte[] valores = SHA256.digest(val.getBytes());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < valores.length; i++) {
            sb.append(Integer.toString((valores[i] & 0xff) + 0x100,
                    16).substring(1));
        }
        return sb.toString();
    }
}
