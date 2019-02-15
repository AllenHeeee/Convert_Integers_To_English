

public class IntegerToEnglish {
	static final String[] lessthan20= {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eightenn","Nineteen"};
	static final String[] over20= {"","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	public static String wordsinhundred(int x) {
		String str="";
		if(x>=100) {
			if(x%100<20) {
				str=lessthan20[x%100]; 
				x/=100;
				str=lessthan20[x%10]+" Hundred "+str;
			}
			else {
				str=lessthan20[x%10];
				x/=10;
				str=over20[x%10]+" "+str;
				x/=10;
				str=lessthan20[x%10]+" Hundred "+str;
			}
		}else {
			if(x<20) {
				str=lessthan20[x];
			}else {
				str=lessthan20[x%10];
				x/=10;
				str=over20[x%10]+" "+str;
			}
			
		}
		return str;
	}
	public static String numberToWords(int num) {
		if(num==0)return "Zero";
		String str="";
		int pointer=0;
        while(num>0) {
        	if(num%1000>0)
        	str=wordsinhundred(num%1000)+" "+THOUSANDS[pointer]+" "+str;
        	num/=1000;
        	pointer++;
        }
        str=str.trim();
        for(int i=0;i<str.length();i++) {
        	if(str.charAt(i)==' '&&str.charAt(i+1)==' ') {
        		str=str.substring(0, i)+str.substring(i+1);
        	}
        }
        return str;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberToWords(1000000));
	}

}
