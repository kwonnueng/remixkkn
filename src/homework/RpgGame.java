package homework;

import java.util.Scanner;

public class RpgGame {

	public static void main(String[] args) {
		
		/*String[] knightSkill={"베기","십자베기","돌격&베기"};
		String[] elfSkill={"활쏘기","여러번활쏘기","강력하게 활쏘기"};
		String[] wizardSkill={"파이어볼","어스퀘이크","아이스랜스"};*/
		
		//캐릭터 배열
		String[] character={"기사","요정","마법사"};
		//스킬배열[][]
		String[][] skill={{"베기","십자베기","돌격&베기"},{"활쏘기","여러번활쏘기","강력하게 활쏘기"},{"파이어볼","어스퀘이크","아이스랜스"}};
		//아이템배열
		String[] item={"","","물약","","사각방패","장검","나무석궁","","","오래된지팡이","","강철지팡이"};
		//몬스터배열
		String[] monster={"오크","오우거","거대쥐","용","고블린","도플갱어"};
		
		int[] myInventory=new int[50];


		Scanner sc=new Scanner(System.in);
		System.out.println("캐릭터 골라주세요 1.기사, 2.요정, 3.마법사");
		int num =sc.nextInt();
		sc.nextLine();

		while(num<0 || 3<num){
			System.out.println("캐릭터는 1.2.3번중에서 골라야 해요");
			num=sc.nextInt();
			sc.nextLine();
			System.out.println();
		}
		int myCharacterNum=num;
		System.out.println(character[num-1]+" 을(를) 선택하셨습니다");

		boolean myCharacterDeath=false;
		int myLevel=1;
		int monsterLevel=0;

		int itemNum=0;
		int skillNum=0;

		String nowSkill="";
		String gamePlay="";



		A:	while(myLevel<100|| myCharacterDeath==false){

			System.out.println("던전을 모험중입니다");
			System.out.println("엔터입력하면 몬스터가 나옵니다");
			sc.nextLine();

			num=(int)(Math.random()*monster.length);
			monsterLevel=(int)(Math.random()*(myLevel+2));
			System.out.println(monsterLevel+" level "+monster[num]+"이 나타났습니다");

			skillNum=(int)(Math.random()*3);
			nowSkill=skill[myCharacterNum-1][skillNum];

			if(myLevel<monsterLevel){

				System.out.println(nowSkill+"로 공격합니다");		
				myCharacterDeath=true;
				System.out.println("나의레벨보다 캐릭터레벨이 높아 죽었습니다");

				/*gamePlay=sc.nextLine();
				while(gamePlay!="y"||gamePlay!="n"){
					if(gamePlay.equals("y")){
						System.out.println("계속합니다");
						continue A;
					}else if(gamePlay.equals("n")){
						System.out.println("게임을 종료합니다");
						break A;
					}
				}*/

				do {

					System.out.println("다시하시겠습니까 y, n");

					gamePlay=sc.nextLine();

					if(gamePlay.equals("y")){
						System.out.println("계속합니다");
						System.out.println();
						continue A;
					}else if(gamePlay.equals("n")){
						System.out.println("게임을 종료합니다");
						break A;
					}
				} while (gamePlay!="y"||gamePlay!="n");


			}else if(myLevel>=monsterLevel){
				System.out.println(nowSkill+"로 공격합니다 "+monster[num]+"를 죽였습니다");		
				myLevel++;
				itemNum=(int)(Math.random()*item.length);

				if(item[itemNum].equals("")){
					System.out.println("아이템은 안나왔습니다");
					System.out.println();
				}
				else{
					//item[itemNum]은 String 
					//
					System.out.println(item[itemNum]+"을 획득 하였습니다");
					myInventory[itemNum]++;
					System.out.println();

				}

			}

		}
		if(myLevel==100){
			System.out.println("만랩까지 키우셨습니다");
		}
		System.out.println("나의 레벨은"+myLevel+"입니다");
		for(int i=0; i<myInventory.length; i++){
			if(myInventory[i]!=0){

				System.out.println("내가 획득한 아이템은 "+item[i]+" 이며 "+myInventory[i]+"개를 얻었습니다");
			}
		}
	}
}
