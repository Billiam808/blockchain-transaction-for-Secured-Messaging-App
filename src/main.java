/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author billiam
 */
public class main {
    public static void main(String[] args) throws Exception
    {
            DH_EC_KE encry = new DH_EC_KE();
            encry.establishKeys("secp256r1");
            String mesg = "hello world";
            System.out.println(mesg);
            System.out.println(mesg.getBytes());
            byte[] ciph = encry.encrypt(mesg.getBytes());
            System.out.println(ciph.toString());
            byte[] plainText = encry.decrypt(ciph);
            String s = new String(plainText);
            System.out.println(s);
    }
}
