package TwoDayspackage;


public class DesAlgorithm
{
static int[] PC1 = new int[]{
			   57, 49, 41, 33, 25, 17,  9,
			    1, 58, 50, 42, 34, 26, 18,
			   10,  2, 59, 51, 43, 35, 27,
			   19, 11,  3, 60, 52, 44, 36,
			   63, 55, 47, 39, 31, 23, 15,
			    7, 62, 54, 46, 38, 30, 22,
			   14,  6, 61, 53, 45, 37, 29,
			   21, 13,  5, 28, 20, 12,  4
			  };
	static int[] IP1 = new int[]{ 
				40, 8, 48, 16, 56, 24, 64, 32,
			  39, 7, 47, 15, 55, 23, 63, 31,
			  38, 6, 46, 14, 54, 22, 62, 30,
			  37, 5, 45, 13, 53, 21, 61, 29,
			  36, 4, 44, 12, 52, 20, 60, 28,
			  35, 3, 43, 11, 51, 19, 59, 27,
			  34, 2, 42, 10, 50, 18, 58, 26,
			  33, 1, 41, 9, 49, 17, 57, 25 
			  };
			 
	static int[] PC2 = new int[]{
			    14, 17, 11, 24,  1,  5,
			    3, 28, 15,  6, 21, 10,
			    23, 19, 12,  4, 26,  8,
			    16,  7, 27, 20, 13,  2,
			    41, 52, 31, 37, 47, 55,
			    30, 40, 51, 45, 33, 48,
			    44, 49, 39, 56, 34, 53,
			    46, 42, 50, 36, 29, 32
			  };
			 
	static int[] IP = new int[]{
			    58, 50, 42, 34, 26, 18, 10,  2,
			    60, 52, 44, 36, 28, 20, 12,  4,
			    62, 54, 46, 38, 30, 22, 14,  6,
			    64, 56, 48, 40, 32, 24, 16,  8,
			    57, 49, 41, 33, 25, 17,  9,  1,
			    59, 51, 43, 35, 27, 19, 11,  3,
			    61, 53, 45, 37, 29, 21, 13,  5,
			    63, 55, 47, 39, 31, 23, 15,  7
			    };
			 
	static int[] Expansion = new int[]{
			    32,  1,  2,  3,  4,  5,  4,  5,
			     6,  7,  8,  9,  8,  9, 10, 11,
			    12, 13, 12, 13, 14, 15, 16, 17,
			    16, 17, 18, 19, 20, 21, 20, 21,
			    22, 23, 24, 25, 24, 25, 26, 27,
			    28, 29, 28, 29, 30, 31, 32,  1};
			 
	static int[][][] SBox = new int[][][]{
			     {
			     {14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7},
			     { 0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8},
			     { 4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0},
			     {15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13},
			     },
			 
			     {
			     {15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10},
			     { 3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5},
			     { 0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15},
			     {13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9},
			     },
			 
			     {
			     {10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8},
			     {13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1},
			     {13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7},
			     { 1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12},
			     },
			 
			     {
			     { 7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15},
			     {13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9},
			     {10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4},
			     { 3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14},
			     },
			 
			     {
			     { 2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9},
			     {14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6},
			     { 4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14},
			     {11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3},
			     },
			 
			     {
			     {12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11},
			     {10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8},
			     { 9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6},
			     { 4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13},
			     },
			 
			     {
			     { 4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1},
			     {13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6},
			     { 1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2},
			     { 6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12},
			     },
			 
			     {
			     {13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7},
			     { 1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2},
			     { 7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8},
			     { 2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11},
			     },};
			 
	static int[] PBox = new int[]{
				     16,  7, 20, 21, 29, 12, 28, 17,
				     1, 15, 23, 26,  5, 18, 31, 10,
				     2,  8, 24, 14, 32, 27,  3,  9,
				     19, 13, 30,  6, 22, 11,  4, 25
				 };
	static int[] LeftShifts = new int[]{
		  	1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1
		  };
	
	public static String Caller (String pTxt)
	{
		//Scanner s = new Scanner(System.in);

		//String pTxt = s.next();
		//String key = s.next();
		//s.close();
		String key = "133457799BBCDFF1";
		String bKey = hexToBin(key);
		
		StringBuilder bKPlus = new StringBuilder();

		for(int i=0;i<56;i++){
			bKPlus.append(bKey.charAt(PC1[i]-1));
		}

		String bKeyPlus = bKPlus.toString();
		
		String c0 = bKeyPlus.substring(0, 28);
		String d0 = bKeyPlus.substring(28, 56);
		
		String k1 ="";
		String dummy = "";
		StringBuilder key48 = new StringBuilder();
		for(int k=0;k<16;k++) {
			
			c0 = leftRotate(c0,LeftShifts[k]);
			d0 = leftRotate(d0,LeftShifts[k]);
			dummy = c0+d0;
			
			for(int j=0;j<48;j++) {
				key48.append(dummy.charAt(PC2[j]-1));	
			}
	
			k1 = key48.toString();
			
//			long dec = Long.parseUnsignedLong(key48.toString(), 2);
//			String hex = Long.toHexString(dec).toUpperCase();
//			System.out.println(binToHex(key48.toString()));
			
			key48.delete(0, 48);
		
			pTxt = hexToBin(pTxt);
			StringBuilder ipPtxt = new StringBuilder();
			String l0,r0;			
			if(k == 0){
				for(int i=0;i<64;i++) {
					ipPtxt.append(pTxt.charAt(IP[i]-1));
				}
				
				l0 = ipPtxt.toString().substring(0, 32);
				r0 = ipPtxt.toString().substring(32, 64);
//				System.out.println("r0 val in k"+k+" "+binToHex(r0));
			}else{
				l0 = pTxt.toString().substring(0, 32);
				r0 = pTxt.toString().substring(32, 64);
//				System.out.println("r0 val in k"+k+" "+binToHex(r0));
			}
			StringBuilder er0 = (k == 0) ? ipPtxt : new StringBuilder(l0+r0);
			er0.delete(0, 64);
			for(int i=0;i<48;i++) {
				er0.append(r0.charAt(Expansion[i]-1));
			}
			
			String re0 = er0.toString();
			er0.delete(0, 48);
			for(int i=0 ;i<48; i++) {
				er0.append(xor(k1.charAt(i),re0.charAt(i)));
			}
			
			String k1xorEr0 = er0.toString();
			StringBuilder temp = new StringBuilder();
			er0.delete(0, 48);
			int count = 0;
			
			for(int i=0;i<48;i=i+6  ) {
				temp.append(k1xorEr0.charAt(i));
				temp.append(k1xorEr0.charAt(i+5));
				er0.append(String.format("%4s",Integer.toBinaryString(SBox[count][Integer.parseInt(temp.toString(), 2)][Integer.parseInt(k1xorEr0.substring(i+1, i+5),2 )])).replace(' ','0'));
				temp.delete(0,2);
				count++;
			}
			
			String sbox = er0.toString();
			er0.delete(0, 48);
			
			for(int i=0;i<32;i++) {
				er0.append(sbox.charAt(PBox[i]-1));
			}
			
			String f = er0.toString();
			er0.delete(0, 32);
			
			for(int i=0;i<32;i++) {
				er0.append(xor(l0.charAt(i),f.charAt(i)));
			}
			
			String r1 = er0.toString();
			String l1 = r0;
			
			String round1 = l1+r1;
			//long fin = Long.parseUnsignedLong(round1, 2);
			//pTxt = Long.toHexString(fin).toUpperCase();
			//System.out.println(Long.toHexString(fin).toUpperCase());
			pTxt = binToHex(round1);
//			System.out.println("Iteration: " +k+" "+ binToHex(round1));
		}
		pTxt =  pTxt.substring(8, 16) + pTxt.substring(0, 8);
//		System.out.println(pTxt);
		String finl = permutation(IP1,pTxt);
//		System.out.println(finl);
                
                return finl;
	}
	
	static String leftRotate(String str, int d) 
    { 
            String ans = str.substring(d) + str.substring(0, d); 
            return ans; 
    }
	static char xor(char a, char b) {
		if(a==b)
			return('0');
		else
			return('1');
		
	}
	public static String hexToBin(String hex){
		StringBuilder bin = new StringBuilder();

		for(int i=0; i<hex.length();i++){

			switch (hex.charAt(i)){ 
	            case '0': 
	                bin.append("0000"); 
	                break; 
	            case '1': 
	                bin.append("0001"); 
	                break; 
	            case '2': 
	                bin.append("0010"); 
	                break; 
	            case '3': 
	                bin.append("0011"); 
	                break; 
	            case '4': 
	                bin.append("0100"); 
	                break; 
	            case '5': 
	                bin.append("0101"); 
	                break; 
	            case '6': 
	                bin.append("0110"); 
	                break; 
	            case '7': 
	                bin.append("0111"); 
	                break; 
	            case '8': 
	                bin.append("1000"); 
	                break; 
	            case '9': 
	                bin.append("1001"); 
	                break; 
	            case 'A': 
	            case 'a': 
	                bin.append("1010"); 
	                break; 
	            case 'B': 
	            case 'b': 
	                bin.append("1011"); 
	                break; 
	            case 'C': 
	            case 'c': 
	                bin.append("1100"); 
	                break; 
	            case 'D': 
	            case 'd': 
	                bin.append("1101"); 
	                break; 
	            case 'E': 
	            case 'e': 
	                bin.append("1110"); 
	                break; 
	            case 'F': 
	            case 'f': 
	                bin.append("1111"); 
	                break; 
            }
		}
		return(bin.toString());
	}
	
	public static String binToHex(String binary) {
		
		StringBuilder s = new StringBuilder();
		int digitNumber = 1;
	    int sum = 0;
	    for(int i = 0; i < binary.length(); i++){
	        if(digitNumber == 1)
	            sum+=Integer.parseInt(binary.charAt(i) + "")*8;
	        else if(digitNumber == 2)
	            sum+=Integer.parseInt(binary.charAt(i) + "")*4;
	        else if(digitNumber == 3)
	            sum+=Integer.parseInt(binary.charAt(i) + "")*2;
	        else if(digitNumber == 4 || i < binary.length()+1){
	            sum+=Integer.parseInt(binary.charAt(i) + "")*1;
	            digitNumber = 0;
	            if(sum < 10)
	                s.append((char)(sum+48));
	            else if(sum == 10)
	            	s.append("A");
	            else if(sum == 11)
	            	s.append("B");
	            else if(sum == 12)
	            	s.append("C");
	            else if(sum == 13)
	            	s.append("D");
	            else if(sum == 14)
	            	s.append("E");
	            else if(sum == 15)
	            	s.append("F");
	            sum=0;
	        }
	        digitNumber++;  
	    }
	    return (s.toString());
	}
	
	public static String permutation(int[] sequence, String input){
            String output = "";
            input = hexToBin(input);
            for (int i = 0; i < sequence.length; i++)
                output += input.charAt(sequence[i] - 1);
            output = binToHex(output);
            return output;
        }        
}
