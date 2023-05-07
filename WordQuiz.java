import java.util.*;
import java.util.Scanner;

class Word{
	String kor;
	String eng;
	
	public Word(String kor,String eng) {
		this.kor=kor;
		this.eng=eng;
	}
	public String getEng() {
		return eng;
	}
	public String getKor() {
		return kor;
	}

}

class Ex{
	int ex[]= {-1,-1,-1,-1};
	
	public Ex(int answer, int size) {
		int answerIndex = (int)(Math.random()*4);
		ex[answerIndex]=answer;
		for(int i=0;i<4;i++) {
			int n = (int)(Math.random()*size);
			if(ex[i]==-1) {
				ex[i]=n;
			}
			else
				continue;
			
			for(int j=0;j<4;j++) {
				if(i!=j&&ex[i]==ex[j]) {
					ex[i]=-1;
					i--;
				}
				else
					continue;
			}
		}
	}
}

public class WordQuiz {
	Scanner scanner = new Scanner(System.in);
	Vector<Word> v = new Vector<Word>();
	String name;
	public WordQuiz() {
		v.add(new Word("one","하나"));
		v.add(new Word("two","둘"));
		v.add(new Word("three","셋"));
		v.add(new Word("four","넷"));
		v.add(new Word("five","다섯"));
		v.add(new Word("six","여섯"));
		v.add(new Word("seven","일곱"));
		v.add(new Word("eight","여덟"));
		v.add(new Word("nine","아홉"));
		v.add(new Word("ten","열"));
	}
	public void choice() {
		System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3>>");
		int n = scanner.nextInt();
		
		switch(n){
			case 1: {
				run();
				break;
			}
			case 2:{
				add();
				break;
			}
			case 3:{
				finish();
			}
		}
	}
	
	public void run() {
		System.out.println("현재 "+v.size()+"개의 단어가 들어 있습니다");
		while(true) {
			int answer = (int)(Math.random()*v.size());
			String question = v.get(answer).getEng();
			System.out.println(question+"?");
			
			Ex example = new Ex(answer,v.size());
			for(int i=0;i<4;i++) {
				System.out.print("("+(i+1)+")"+v.get(example.ex[i]).getKor());
			}
			System.out.print(":>");
			int n = scanner.nextInt();
			if(n==-1) {
				System.out.println(" ");
				choice();
			}
			else if (example.ex[n-1]==answer)
				System.out.println("Excellent!!");
			else
				System.out.println("No. !!");
		}
	}
	
	public void add() {
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		while(true) {
			System.out.print("영어 한글 입력 >> ");
			String eng = scanner.next();
			if(eng.equals("그만")) {
				System.out.println(" ");
				choice();
			}
			String kor = scanner.next();
			v.add(new Word(eng,kor));
		}
	}
	
	public void finish() {
		System.out.println("명품영어를 종료합니다");
	}
	
	public static void main(String[] args) {
		
		WordQuiz quiz = new WordQuiz();
		System.out.println("**** 영어 단어 테스트 프로그램 명품영어 입니다 ****");
		quiz.choice();
		
	}
}
