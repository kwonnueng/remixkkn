package chapter5;

import java.util.ArrayList;
import java.util.Scanner;

   
public class ArrayEx1 {

	public static void main(String[] args) {
		/*//row수를 입력받는다
		배열은 물리적인주소가 연속적이다
		가변배열
		1부터 100까지 행개수를  입력  받는다
		각행 반복문 돌면서 다시 1~10까지 랜덤수를 받아 열을 채운다
		그리고 총배열에 1~10까지  생성하면서 값을 채운다 그리고 그값이 몇번인지 1~10까지몇번인지 나타내라
		각행마다 길이 입력마다*/

		Scanner sc =new Scanner(System.in);
		int row,height,num=0;
		System.out.println("행갯수를 입력하세요");
		row=sc.nextInt();
		sc.nextLine();
		while(1>=row||row>100) {
			System.out.println("다시 입력");
			row=sc.nextInt();
			sc.nextLine();
		}

		int[][] arr=new int [row][];
		int[] counter =new int [100];
		//counter를 row개수만큼 만드니깐 안됬었다 넉넉하게 만들어야 하는 이유 
		//ex)최초 로우를 3받고 9만되도 벌써 이셉션만난다.
		
		//열 입력
		for(int i=0; i<arr.length; i++){
			height=(int)((Math.random()*10)+1);
			arr[i]=new int[height];
		}
		
		//생성된 행열에 각각 값입력
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				num=(int)((Math.random()*10)+1);
				arr[i][j]=num;
			}
		}
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.println("현재"+i+"번째에 있는행의"+j+" 열의 값은"+arr[i][j]);
			}
		}
		
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				counter[arr[i][j]]++;
			}
		}
		//이곳이 햇갈림 10으로 제한하면되는데 10은 num;
		for(int i=0; i<11; i++){
			
				System.out.println(i+"dddd"+"zkdkdk"+counter[i]+"있습니다");
			}
		}
	}
