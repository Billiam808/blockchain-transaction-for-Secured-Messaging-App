import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.MessageDigest;

public class User {

    private double wallet;
    private PrivateKey priv;
    private PublicKey pub;
    private Signature dsa;
    String ID;

    /*
     * Constructor creates public and private keys  as well as initializing wallet
     */
    User() throws Exception{
        this.wallet = 0.0;
        /*
         * Generate an ECDSA signature
         */
        ECGenParameterSpec ecGenSpec = new ECGenParameterSpec("secp256k1");

        /*
         * Generate a key pair
         */
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

        keyGen.initialize(ecGenSpec, random);

        KeyPair pair = keyGen.generateKeyPair();
        this.priv = pair.getPrivate();
        this.pub = pair.getPublic();

        /*
         * Create a Signature object and initialize it with the private key
         */
        this.dsa = Signature.getInstance("SHA256withECDSA");

        /*
         * Perform an Initial signing with the Public and Private keys
         */
        dsa.initSign(this.priv);
        dsa.initVerify(this.pub);

        /*
         *Hashing the public key to create a users ID
         */

        /*
         *Create an initial message digest
         */
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        /*
         * Update the message digest with the public key
         */
        md.update(this.pub.getEncoded());
        byte[] digest = md.digest();

        /*
         * Covert the message digest into its hexidecimal string
         */
        StringBuffer buffer= new StringBuffer();
        for (byte bytes : digest) {
            buffer.append(String.format("%02x", bytes & 0xff));
        }

        /*
         * Assign the hex string to the ID instance variable
         */
        this.ID = buffer.toString();



    }

    public void transaction(User secondParty){



    }

    public void makePurchase(User seller, double money){

        removeMoney(money);
        seller.addMoney(money);

    }

    public void sellProduct(User purchaser, double money){

        addMoney(money);
        purchaser.removeMoney(money);

    }

    public void addMoney(double money){

        this.wallet += money;

    }

    public void removeMoney(double money){

        this.wallet -= money;

    }

    public void getWallet(){
        System.out.println( this.ID + " has: $" + this.wallet);
    }
}
