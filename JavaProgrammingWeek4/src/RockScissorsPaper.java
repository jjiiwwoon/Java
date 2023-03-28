import java.util.Scanner;

public class RockScissorsPaper {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	String User,Com;
	String str[]={"가위","바위","보"};
		
	System.out.println("컴퓨터와 가위 바위 보 게임을 합니다");	
	
	while(true) {
		int n = (int)(Math.random()*3);
		System.out.print("가위 바위 보!>>");
		User = scanner.next();
		Com = str[n];
		if(User.equals("그만")) {
			System.out.println("게임을 종료합니다...");
			break;
		}
		
		if(User.equals("가위")){
			if(Com.equals("가위"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 비겼습니다");
			if(Com.equals("바위"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 사용자가 졌습니다");
			if(Com.equals("보"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 사용자가 이겼습니다");
		}
		if(User.equals("바위")){
			if(Com.equals("가위"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 사용자가 이겼습니다");
			if(Com.equals("바위"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 비겼습니다");
			if(Com.equals("보"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 사용자가 졌습니다");
		}
		if(User.equals("보")){
			if(Com.equals("가위"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 사용자가 졌습니다");
			if(Com.equals("바위"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 사용자가 이겼습니다");
			if(Com.equals("보"))
				System.out.println("사용자 = "+User+" , 컴퓨터 = "+Com+" , 비겼습니다");
		}
		
	}
		
	scanner.close();	
	}
}
