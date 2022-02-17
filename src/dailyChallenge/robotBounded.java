package dailyChallenge;

/**
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.
 * The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degrees to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane
 * such that the robot never leaves the circle.
 *
 *
 *
 * Example 1:
 *
 * Input: instructions = "GGLLGG"
 * Output: true
 * Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees,
 * and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2
 * centered at the origin.
 * Example 2:
 *
 * Input: instructions = "GG"
 * Output: false
 * Explanation: The robot moves north indefinitely.
 * Example 3:
 *
 * Input: instructions = "GL"
 * Output: true
 * Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 *
 *
 * Constraints:
 *
 * 1 <= instructions.length <= 100
 * instructions[i] is 'G', 'L' or, 'R'.
 */
public class robotBounded {

  // Consider Catesian Graph as the space.
  public boolean isRobotBoundedNew(String instructions) {
    // 0 - north , 1 - south, 2 - east (right), 3 - west (left)
    int[][] moves = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Initial position is in the center (0, 0)
    int x = 0;
    int y = 0;

    // Robot is facing North direction.
    int direction = 0;

    for (char i : instructions.toCharArray()) {
      if (i == 'L') {
        direction = (direction + 3) % 4; // mod 4 will keep the direction [0 - 3 (included)
      }
      else if (i == 'R') {
        direction = (direction + 2) % 4;
      }
      else {
        x += moves[direction][0];
        y += moves[direction][1];
      }
    }
    return (x == 0 && y == 0) || (direction != 0);
  }

  // Passed 62 tests, but failed rest. Need to monitor direction
  public boolean isRobotBounded(String instructions) {
    int count = 0;
    int sum = 0;
    while (count < 2) {
      for (int i = 0; i < instructions.length(); i++) {
        if (instructions.charAt(i) == 'G') {
          sum += 1;
        }
        else {
          sum -= 2;
        }
        if (count == 1 && sum == 0) {
          System.out.println(sum);
          return true;
        }
        System.out.println(sum);
      }
      if (sum == 0) {
        return true;
      }
      count++;
    }
    return false;
  }
}
