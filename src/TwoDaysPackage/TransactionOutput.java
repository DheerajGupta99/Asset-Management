package TwoDayspackage;
import java.security.PublicKey;
import java.io.*;

public class TransactionOutput implements Serializable{
    public String id;
    public PublicKey recipient;
    public float value;
    public String parentTransactionId;

    //Constructor
    public TransactionOutput(PublicKey recipient, float value, String parentTransactionId) {
        this.recipient = recipient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil.applySha256(StringUtil.getStringFromKey(recipient)+Float.toString(value)+parentTransactionId);
    }

    //Check if asset belongs to you
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == recipient);
    }

}