import java.util.Scanner;

class Phone{
	String name;
	String tel;
	
	public Phone(String name,String tel) {
		this.name=name;
		this.tel=tel;
	}
}
public class PhoneBook {
	Scanner scanner=new Scanner(System.in);
	Phone []phone;
	int num;
	
	public PhoneBook(int person) {
		num=person;
		phone=new Phone[num];
		
		for(int i=0;i<phone.length;i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			String name=scanner.next();
			String tel=scanner.next();
			phone[i]=new Phone(name,tel);
		}
		System.out.println("저장되었습니다...");
	}
	
	public void isRight() {
		while(true) {
			boolean TF=false;
			System.out.print("검색할 이름>>");
			String TFname=scanner.next();
			if (TFname.equals("그만"))
				break;
			for(int i=0;i<num;i++) {
				if((phone[i].name).equals(TFname)) {
					System.out.println(TFname+"의 번호는 "+phone[i].tel+"입니다");
					TF=true;
				}
			}
			if(TF==false)
				System.out.println(TFname+"이 없습니다");
		}
		System.out.println("프로그램이 종료되었습니다");
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("인원수>>");
		int num=scanner.nextInt();
		PhoneBook phonebook=new PhoneBook(num);
		phonebook.isRight();
	}
}
