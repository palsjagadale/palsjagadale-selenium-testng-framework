package SeleniumSession;

public class DataConversion {

	public static void main(String[] args) {
		
		String x ="100";
		System.out.println(x+20);
		
		int i = Integer.parseInt(x);
		System.out.println(i+20);
		
		//reading some String data from prop file
		//timeout = 20;
		//"20" +5 = 205
		//from webpage : data is always coming in the form of text(String)
		
		
		//String to double :
				String 	y = "12.33";
				System.out.println(y+20);
				double d = Double.parseDouble(y);
				System.out.println(d+20);
		
		//String 
				
				 String g = "100A";
				 String k= g.substring(0,3);
				 int b= Integer.parseInt(k);
				 System.out.println(b+20); 	
				 
		//String to Boolen
				 String headless = "true";
				 boolean flag = Boolean.parseBoolean(headless);
				 if(flag)
				 {
					 
				 }
				 
				 
		//Integer to String
				 int t1= 100; 				 
				 System.out.println(t1+10);	
				 String t2 = String.valueOf(t1);  ///"100"
				 System.out.println(t2+20);

	}

}
