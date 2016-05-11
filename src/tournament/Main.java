package tournament;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("누르면 시작");
    sc.nextLine();
    
    String[] nationArr = {"대한민국", "일본", "프랑스", "독일", "영국", "스페인", "폴란드", "미국", "이탈리아", "호주", "스위스", "벨기에", "브라질", "아르헨티나", "파라과이", "멕시코"};
    int[][] vsTable = new int[8][2];
    
    while(nationArr.length > 2) {
A:    for (int i=0; i<vsTable.length; i++) {
B:      for (int j=0; j<vsTable[i].length; j++) {
          int nation = (int) (Math.random() * (vsTable.length * vsTable[j].length));
          
          //뽑아야하는 조를 제외한 이전 조까지 중복체크
          for (int m=0; m<i; m++) {
            for (int n=0; n < 2; n++) {
              if (nation == vsTable[m][n]) {
                if (j==0) {
                  i--;
                  continue A;
                } else {
                  j--;
                  continue B;
                }
              }
            }
          }
          //뽑아야하는 조 중복체크
          if (j == 1) {
            if (nation == vsTable[i][0]) {
              j--;
              continue B;
            }
          }
          vsTable[i][j] = nation;
        }
      }
    
      String[] nextNationArr = new String[nationArr.length/2];
      for (int i=0; i<vsTable.length; i++) {
        nextNationArr[i] = Math.random() < 0.5 ? nationArr[vsTable[i][0]] : nationArr[vsTable[i][1]];
        System.out.println(nationArr[vsTable[i][0]] + "와 " + nationArr[vsTable[i][1]] + " 중 " + nextNationArr[i] + "의 승리!");
      }
      nationArr = nextNationArr;
      vsTable = new int[vsTable.length/2][2];
    }
    
    int gameResult = Math.random() < 0.5 ? 0 : 1;
    System.out.println(nationArr[gameResult] + " 우승! " + nationArr[1-gameResult] + " 준우승!");
    sc.close();
  }
}
