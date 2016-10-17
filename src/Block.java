/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BillJoshua
 */
public class Block {
    Block prev;
    String timeStamp;
    double price;
    String buyer;
    String seller;
    
    // constructor
    Block()
    {
        prev = null;
        timeStamp = null;
        price = 0.0;
        buyer = null;
        seller = null;
    }
    
    Block(Block p, String ts, double pr, String b, String s)
    {
        prev = p;
        timeStamp = ts;
        price = pr;
        buyer = b;
        seller = s;
    }
}
