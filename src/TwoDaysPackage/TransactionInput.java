package TwoDayspackage;
import java.io.*;
public class TransactionInput implements Serializable {
    public String transactionOutputId; //Reference to TransactionOutputs -> transactionId

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
}