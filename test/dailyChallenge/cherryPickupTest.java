package dailyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class cherryPickupTest {

  @Test
  void cherryPickupSolution() {
    cherryPickup test = new cherryPickup();
    int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
    int res = test.cherryPickupSolution(grid);
    System.out.println(res);
  }
}