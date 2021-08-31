package SeleniumSession;

public class StringManupulation {

	public static void main(String[] args) {

		String a1 = "this is my code";

		System.out.println(a1.toUpperCase()); // uppercase
		System.out.println(a1.toLowerCase()); // lowercase

		System.out.println(a1.contains("code"));

		/// String : literals
				String s1 = "Pallavi";
				String s2 = "Pallavi";

				System.out.println(s1.equals(s2));
				System.out.println(s1 == s2);
		
				String n1 = "pallavi";
				System.out.println(n1.equals(s1));
				System.out.println(n1.equalsIgnoreCase(s1));

		// String object with new keyword
				String s3 = new String("test");
				String s4 = new String("test");
		
				System.out.println(s3.equals(s4));
				System.out.println(s3 == s4);
				
				
		//SubString
				String p1 = "this is my selenium code";
				System.out.println(p1.substring(8));
				System.out.println(p1.substring(2, 10));      //it will not consider the 10th letter
				
		//Split
				String str = "java_python_ruby_javascript";
				String[] ar	= str.split("_");
				System.out.println(ar.length);
				System.out.println(ar[0]);
				
				for(String e : ar)
				{
					System.out.println(e);
				}
						
				
				String hr = "Testing_Selenium;Test_seleniumPytho;Testing_selenium_ruby";
				System.out.println(hr.split(";")[0]);
				System.out.println(hr.split(";")[1]);
				System.out.println(hr.split(";")[2]);
				

	}

}
