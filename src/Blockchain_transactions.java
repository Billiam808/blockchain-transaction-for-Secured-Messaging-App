/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BillJoshua
 */
public class Blockchain_transactions {
    private Block head;
    private int blockCount;
    
    // Constructors
    Blockchain_transactions()
    {
        head = new Block();
        ++blockCount;
    }
    Blockchain_transactions(Block h, int bc)
    {
        head = h;
        blockCount = bc;
    }
    
    // Function that creates a new block. This function also checks if the
    // new block being created is a valid transaction and checks if it's a 
    // duplicate
    void addBlock()
    {
        
    }
    
    // validate the transaction. Use a special "fingerprint" to validate.
    // concatnate UID, timestamp, and price
    void validate()
    {
        
    }
    
}
