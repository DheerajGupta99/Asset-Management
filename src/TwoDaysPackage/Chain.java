package TwoDayspackage;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.util.*;
import javax.swing.JOptionPane;

public class Chain {
    static List<String> usernames;
    static List<String> passwords;
    static List<Integer> zkpids;
    static ArrayList<Wallet> wallets;
    static Scanner scan;
    static int k;
    public static Transaction genT;
    static Wallet bank;
    static Block genesis;
    static Block prevBlock;
    public static int p;
    public static int g;
    //    public static HashMap<String,TransactionOutput> UTXOs = new HashMap<>();
    public static ArrayList<Block> blockchain;
    public static void Main() {
        try{
        System.out.println("STARTING CHAIN!!!");
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); //Setup Bouncey castle as a Security Provider
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
        zkpids = new ArrayList<>();
        wallets = new ArrayList<>();
        scan = new Scanner(System.in);
        k = 0;
        bank = new Wallet();
        p=11;
        g=2;
        genesis = new Block("0","bankUser");
        //    public static HashMap<String,TransactionOutput> UTXOs = new HashMap<>();
        blockchain = new ArrayList<>();
        prevBlock = genesis;
        usernames.add("bankUser");
        passwords.add("bank123");
        Wallet wallet = new Wallet();
        wallets.add(wallet);
        wallet.addMoney(10000);
        wallet.assetList.add("Asset1");
        wallet.assetList.add("Asset2");
        wallet.assetList.add("Asset3");
        wallet.assetList.add("Asset4");
        wallet.costlist.add(30);
        wallet.costlist.add(40);
        wallet.costlist.add(20);
        wallet.costlist.add(70);
        blockchain.add(genesis);
        System.out.println(blockchain.get(0).user);
        }catch(Exception e){}
    }

    public static void register(String username, String password, int zkpid){
            usernames.add(username);
            passwords.add(password);
            Wallet wallet = new Wallet();
            wallets.add(wallet);
            System.out.println(usernames);
            boolean flag1 = false;
            for (int no:zkpids) {
                if (no == zkpid) {
                    flag1 = true;
                    break;
                }
            }
            if(flag1){
                JOptionPane.showMessageDialog(null,"zkp needs to be unique. please choose another number");         
            }
             zkpids.add(zkpid);
    }

    public static boolean login(String username){
        int curr=0;boolean flag = false;
        for (int i = 0; i < usernames.size(); i++) {
            if(usernames.get(i).equals(username)){
//                if(passwords.get(i).equals(password)){
                    curr = i;
                    flag = true;
                    break;
//                }
            }
        }
        curr--;
        int y = expo(g,zkpids.get(curr),p);
        boolean check = zkpdiscretelog(y);
        if(!check){
           System.out.println("zkp failed. Please try again.");
           homePage();
           check = login(username);

        }
        
        return check;
    }
   
    public static boolean buyAssets(String username, int n){
        if(n == -1) return false;
        System.out.println("Asset bought " + n+1);
        int store = 0;
        for (int i = 0; i < usernames.size(); i++) {
            if(usernames.get(i).equals(username)){
                store = i;
            }
        }
        int i = 0;
//        i = wallets.get(0).assetList.stream().map((_item) -> 1).reduce(i, Integer::sum);
        boolean flag = false;
        for (Block blo: blockchain) {
            if(blo.user.equals(username)) {
                flag = true;
                break;
            }
            i++;
        }
        if(!flag) {
            JOptionPane.showMessageDialog(null,"PLEASE ADD MONEY TO WALLET","INSUFFICIENT BALANCE",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Block block = blockchain.get(i);
        boolean check = block.addTransaction(wallets.get(store).sendFunds(wallets.get(0).publicKey, wallets.get(0).costlist.get(n), wallets.get(0).assetList.get(n)));
        if(check){
            wallets.get(store).assetList.add(wallets.get(0).assetList.get(n));
            wallets.get(store).costlist.add(wallets.get(0).costlist.get(n));
            wallets.get(store).addMoney(-1*wallets.get(0).costlist.get(n));
            wallets.get(0).assetList.remove(n);
            wallets.get(0).costlist.remove(n);
//            System.out.println("AssetList from chain.java: " + wallets.get(0).assetList);
            System.out.print("BUY asset successfull!!");
        }
        return check;
    }
    public static void showMyTransactions(String username){
        String res = "";
        int i = 0;
        boolean flag = false;
        for (Block blo: blockchain) {
            if(blo.user.equals(username)) {
                flag = true;
                break;
            }
            i++;
        }
        if(!flag){
            res += "You have not made a transaction yet";
            JOptionPane.showMessageDialog(null, "You have not made a transaction yet");
            return;
        }
        for (Transaction transaction: blockchain.get(i).transactions){
            res += "Transaction id " + transaction.transactionId
                    + "Sender " + transaction.sender
                    + "Recipient " + transaction.reciepient
                    + "Asset transferred to sender " + transaction.asset
                    + "Value of Transaction " + transaction.value
                    + "Signature" + Arrays.toString(transaction.signature) + "\n";
//                    System.out.println("Your transcations are:\n" + res);
        }
        System.out.println("From chain.java your trans are:\n" + res);
        JOptionPane.showMessageDialog(null,"Your Transactions are: \n" + res);
//        return res;
        return;
    }
    public static void isChainValid() {
        Block currentBlock;
        Block previousBlock;
        int difficulty = 5;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
        if(blockchain.size() == 1){
            JOptionPane.showMessageDialog(null, "BLOCK CHAIN IS VALID");
            return;
        }
        
        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("#Current Hashes not equal");
                JOptionPane.showMessageDialog(null, "#Current Hashes not equal");
                return;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("#Previous Hashes not equal");
                JOptionPane.showMessageDialog(null, "#Previous Hashes not equal");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "BLOCK CHAIN IS VALID");
        return;
    }
    public static void addMoney(String username, int amount) {
        int store = 0;
        for (int i = 0; i < usernames.size(); i++) {
            if(usernames.get(i).equals(username)){
                store = i;
            }
        }
        addMoney(wallets.get(store), amount, username);
    }
    public static boolean sellAssets(String username, int n){
        int i = 0;
        boolean flag = false;
        for (Block blo: blockchain) {
            if(blo.user.equals(username)) {
            flag = true;
            break;
        }
        i++;
        }
        if(wallets.get(i).assetList.isEmpty()){
            JOptionPane.showMessageDialog(null, "YOU DO NOT OWN ANY ASSETS");
            return false;
        }
        Block block = blockchain.get(i);
        boolean check = block.addTransaction(wallets.get(0).sendFunds(wallets.get(i).publicKey, wallets.get(i).costlist.get(n), wallets.get(i).assetList.get(n)));
        if(check){
            JOptionPane.showMessageDialog(null, "Transaction Completed, Thank you for selling" + wallets.get(i).assetList.get(n));
            int j = 0;
            for (Block blo: blockchain) {
                if(blo.user.equals(username))
                    break;
                j++;
            }
            wallets.get(i).addMoney(wallets.get(i).costlist.get(n));
            wallets.get(0).assetList.add(wallets.get(i).assetList.get(n));
            wallets.get(0).costlist.add(wallets.get(i).costlist.get(n));
            wallets.get(i).assetList.remove(n);
            wallets.get(i).costlist.remove(n);
//            System.out.println("AssetList from chain.java after selling: " + wallets.get(0).assetList);
//            System.out.println("Costlist from chain.java after selling: " + wallets.get(0).costlist);

        }
        else{
            JOptionPane.showMessageDialog(null,"Please Try Again");
        }
        return check;
    }
    public static int viewBalance(String username){
        int balance;
        int store = 0;
        for (int i = 0; i < usernames.size(); i++) {
            if(usernames.get(i).equals(username)){
                store = i;
            }
        }
        balance = wallets.get(store).getBalance();
        return balance;
    }
    public static void showMyAssets(String username){
        String res = "";
        if(username.equals("")) return ;
        int j = 0;
        for (Block blo: blockchain) {
            if(blo.user.equals(username))
                break;
            j++;
        }
        if(wallets.get(j).assetList.isEmpty())
            res += "You Dont Own any assets!!!\n";
        
        for (String ass : wallets.get(j).assetList)
            res += ass + "\n";
        
        JOptionPane.showMessageDialog(null,"Your Assets are: \n" + res);
//        return res;
        return;
    }
    
    public static void addBlock(Block newBlock) {
        int difficulty = 3;
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    public static void addMoney(Wallet wallet, int amount, String username) {
        Transaction genT;
        genT = new Transaction(bank.publicKey, wallet.publicKey, amount, null, null, 0);
        genT.generateSignature(bank.privateKey);	 //manually sign the genesis transaction
        genT.transactionId = Integer.toString(k++); //manually set the transaction id
        genT.outputs.add(new TransactionOutput(genT.reciepient, genT.value, genT.transactionId)); //manually add the Transactions Output
        int i = 0;
        boolean flag = false;
        for (Block blo: blockchain) {
            if(blo.user.equals(username)) {
                flag = true;
                break;
            }
            i++;
        }
        Block blo;
        if(!flag) {
            blo = new Block(prevBlock.hash, username);
            addBlock(blo);
            prevBlock = blo;
        }
        else
            blo = blockchain.get(i);
        blo.addTransaction(genT);
        i = 0;
        for (Block bla: blockchain) {
            if(bla.user.equals(username)) {
                break;
            }
            i++;
        }
        wallets.get(i).addMoney(amount);
    }
    
    public static int expo(int a,int b,int c){
    	int ans=1;
    	for(int i=0;i<b;i++)
    	{
    		ans=((ans%c)*(a%c))%c;
    	}
    	return ans;
    	
    }
    
    public static Boolean ZKP(int x){
    	Random rand = new Random();
    	
    	int y=expo(g,x,p);
    	int r=rand.nextInt(p-1);
    	int h=expo(g,r,p);
    	int b=rand.nextInt(2);
    	int s=(r+b*x)%(p-1);
    	int val1=expo(g,s,p),val2=(h*expo(y,b,p))%p;
    	if(val1==val2)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    public static Boolean zkpdiscretelog(int y){

        Random rand = new Random();
         Scanner sc=new Scanner(System.in);
         System.out.println("\nKindly verify yourself as a user");
         System.out.println("Zero Knowledge Proof");
        System.out.println("Choose a random number between 0 and 9");
        System.out.println("Please compute h=(2^r)(mod 11) and Enter h");
        int h=sc.nextInt();
        System.out.println("h is "+ h );
        int b=rand.nextInt(2);
        System.out.println("Random bit b is "+b);
        System.out.println("Please compute s=(r+b*x)mod(10).Here x is the number you are proving you know");
        int s=sc.nextInt();

        int val1=expo(2,s,11);
        int val2=(h*expo(y,b,11))%11;
//        int val3=(h*expo(y2,b,11))%11;

        if(val1==val2)
        {
             System.out.println("Zero Knowledge Proof Successful.You are verified as User 1");
             return true;
        }
//        else if(val1==val3)
//        {
//            System.out.println("Zero Knowledge Proof Successful.You are verified as User 1");
//            return true;
//        }
        else
        {
            System.out.println("Zero Knowledge Proof Failed.Please try again");
            return false;
        }
    }
    
        public static void main(String[] args){

    }

    public static void homePage() { return;
    }
}