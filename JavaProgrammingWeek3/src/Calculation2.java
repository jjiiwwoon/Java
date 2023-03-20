import java.util.Scanner;

public class Calculation2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num1,num2,result=0;
		String op;
		
		System.out.println("연산>>");
		num1=scanner.nextInt();
		op = scanner.next();
		num2=scanner.nextInt();
		
        switch(op) {
        case "+":
        	result = num1 + num2;
        	System.out.println(num1+op+num2+" 의 결과는 "+ result +"입니다");
        	break;
        case "-":
        	result = num1 - num2;
        	System.out.println(num1+op+num2+" 의 결과는 "+ result +"입니다");
        	break;
        case "*":
        	result = num1 * num2;
        	System.out.println(num1+op+num2+" 의 결과는 "+ result +"입니다");
        	break;
        case "/":
        	if (num2==0)
        		System.out.println("0으로 나눌 수 없습니다");
        	else {
        	    result = num1 / num2;
        	    System.out.println(num1+op+num2+" 의 결과는 "+ result +"입니다");
        	}
        	break;
        }
	    	
		scanner.close();
	}

}
