package randomNumber;

import java.util.Scanner;

public class RandomNumber {
	public static void main(String[]args){

		Scanner sc =new Scanner (System.in);
		System.out.println("전화번호 생성하려는 갯수 입력하세요");
		//총 생성하려는 갯수를 담을 변수 선언
		int num=sc.nextInt();
		sc.nextLine();
		//Math.random()으로 생성될 무작위 숫자를 담을 변수 선언
		int randomNum=0;
		//각각 랜덤으로 생성될 휴대전화번호를 담을 변수 선언
		String phoneNum="";
		//생성된 휴대전화 번호를 담을 배열 선언
		String[] phoneNumArr =new String[num];
		
		A:for(int i=0; i<phoneNumArr.length; i++){
			phoneNum="010";
			for(int k=0;k<8; k++){
				if(k==0||k==4){
					phoneNum=phoneNum+"-";
				}
				randomNum=	(int)(Math.random()*10);
				phoneNum=phoneNum+Integer.toString(randomNum);
			
			}
			phoneNumArr[i]=phoneNum;
			for(int q=0; q<-1; q++){
				if(phoneNumArr[q].equals(phoneNum)){	
					System.out.println("다시 입력받기");
					System.out.println("다시입력받기전 현재 phoneNum = "+phoneNum);
					i--;
					continue A;
				}
			}
		}
		for(int i=0;i<phoneNumArr.length;i++){
			System.out.println((i+1)+"번째 생성된 휴대전화번호 출력="+phoneNumArr[i]);	
		}
		System.out.println("--------휴대전화 생성 완료--------");
		System.out.println();
		//지역번호를 담은 문자열 배열
		String[] areaStringArr ={"02","031","032","042","062","064"};
		//"서울02","경기031","인천032","042대전","광주062","제주064"
		
		//지역번호배열 인덱스에서 꺼내서 저장할 변수
		String areaNum="";
		System.out.println("지역번호 1~6까지 선택하여 입력해주세요");
		System.out.println("1번=서울 , 2번=경기, 3번=인천, 4번=대전, 5번=광주, 6번=제주");
		
		//1~6숫자를 입력받아 저장할 변수
		int selectNum=sc.nextInt();	
		sc.nextLine();	
		while(0>selectNum|| selectNum>6){
			System.out.println("다시입력하세요");
			selectNum=sc.nextInt();
			sc.nextLine();
			//true면 다시입력 false면 while문 빠져나오기
		}
		//areaNum=areaStringArr[selectNum-1];
		
		System.out.println("선택하신 번호="+selectNum+"지역번호는 "+areaNum+"입니다");
		System.out.println("아까 입력한"+num+"갯수만큼 일반전화번호 생성합니다");
		System.out.println();
		//생성된 지역번호  담을 배열 선언
		String[] areaPhoneNumArr=new String[num];
		
	B:	for(int i=0; i<areaPhoneNumArr.length; i++){
		//지역번호 초기화
		areaNum=areaStringArr[selectNum-1];	
			
			for(int j=0; j<7; j++){
				if(j==0||j==3){
					areaNum=areaNum+"-";
				}
				randomNum=(int)(Math.random()*10);
				areaNum=areaNum+Integer.toString(randomNum);
		}
			areaPhoneNumArr[i]=areaNum;
			for(int k=0; k<i-1; k++){
				
				if(areaPhoneNumArr[k].equals(areaNum)){	
					System.out.println("같은번호가 생성됬습니다 다시 생성 하겠습니다");
					i--;
					continue B;
				}
			}
		}
		for(int i=0;i<areaPhoneNumArr.length;i++){
			System.out.println((i+1)+"번째 생성된 지역전화번호 출력="+areaPhoneNumArr[i]);	
		}	
		System.out.println("--------지역 전화번호 생성 완료--------");
		System.out.println();
		
	}
	}
