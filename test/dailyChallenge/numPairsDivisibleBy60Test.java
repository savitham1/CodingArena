package dailyChallenge;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class numPairsDivisibleBy60Test {

  private int[] timeTest;
  private numPairsDivisibleBy60 testNum;
  private int count;

  @org.junit.jupiter.api.Test
  void solution() {
    testNum = new numPairsDivisibleBy60();
//    timeTest = new int[] {2, 4, 6, 10, 58};
//    count = testNum.solution(timeTest);
//    System.out.println(count);

    timeTest = new int[] {0, 0, 0, 10, 60};
    count = testNum.solution(timeTest);
    System.out.println(count);
  }

  @org.junit.jupiter.api.Test
  void solutionHashTable() {
    testNum = new numPairsDivisibleBy60();
//    timeTest = new int[] {2, 4, 6, 10, 58};
//    count = testNum.solution(timeTest);
//    System.out.println(count);

//    timeTest = new int[] {30,20,150,100,40};
//    timeTest = new int[] {60, 60, 60};
    timeTest = new int[] {30,20,150,100,40, 489, 489, 60};
//    count = testNum.solutionWithHashTable(timeTest);
    System.out.println(count);
  }
}