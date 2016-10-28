package blockchain_transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author bjgad
 */
public class BC_Transaction {

    Block head;                                                                              // holds the head of the blockchain
    int blockCount;                                                                          // holds the number of blocks in the blockchain
    
    
                                                                                             
    BC_Transaction()                                                                         // Constructors
    {
        head = new Block();
        head.setTimeStamp();
        ++blockCount;
    }
    BC_Transaction(Block h, int bc)
    {
        head = h;
        blockCount = bc;
    }
    
    // Function that creates a new block. This function also checks if the
    // new block being created is a valid transaction and checks if it's a 
    // duplicate
    void addBlock(double buyerWallet, double amount, String buyer_ID, String seller_ID)
    {
        Block newBlock = new Block();
        if(amount > buyerWallet)                                                            // Check if buyer have enough money
        {
            return;
        }
        if(true != head.isEqual(newBlock) || head.isBefore(newBlock) == true)               // checks if the newBlock is created exactly the same as the head
        {                                                                                   // if it is, then its a dulicate. Precision is to nano seconds
            return;                                                                         // checks if the new block is old
        }
        newBlock.setAmount(amount);
        newBlock.setBuyerID(buyer_ID);
        newBlock.setSellerID(seller_ID);
        newBlock.setPrev(head);
        head = newBlock;
    }    
}

