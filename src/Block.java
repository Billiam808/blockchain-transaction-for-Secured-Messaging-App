/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain_transaction;
import java.util.*;
import java.sql.Timestamp;

/**
 *
 * @author BillJoshua
 */

public final class Block                                                                // Class is final so no one can create a subclass of it and create their own function
{
        private Block prev;
        private Timestamp stamp;
        private double amount;
        private String buyerID;
        private String sellerID;
    
    
        // getters
        public Block getPrev()
        {
            return prev;
        }
        public Timestamp getTimeStamp()
        {
            return stamp;
        }
        public double getAmount()
        {
            return amount;
        }
        public String getBuyerID()
        {
            return buyerID;
        }
        public String getSellerID()
        {
            return sellerID;
        }
        public boolean isEqual(Block b)
        {
            return stamp.equals(b.getTimeStamp());
        }
        public boolean isBefore(Block b)
        {
            return stamp.before(b.getTimeStamp());
        }
        
        // modifiers
        public void setPrev(Block p)
        {
            prev = p;
        }
  
        public void setTimeStamp()
        {
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            stamp = new Timestamp(now.getTime());
        }
 
        public void setBuyerID(String b_id)
        {
            buyerID = b_id;
        }
        
        public void setSellerID(String s_id)
        {
            sellerID = s_id;
        }
        
        public void setAmount(double amnt)
        {
            amount = amnt;
        }
            
                
        // constructor
        public Block()
        {
            prev = null;
            stamp = null;
            buyerID = null;
            sellerID = null;
            amount = 0;
                    
        }

        // constructor with parameters
        public Block(Block p, double amount1, String buy_ID, String sell_ID)
        {
            prev = p;
            amount = amount1;
            buyerID = buy_ID;
            sellerID = sell_ID;
            setTimeStamp();
        }
}
