package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class pascalTriangleTest {

  @Test
  void generate() {
    pascalTriangle test = new pascalTriangle();
    List<List<Integer>> pascalTriangle = test.generate(6);
    for (List<Integer> row : pascalTriangle) {
      for (Integer num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

  @Test
  void generateZero() {
    pascalTriangle test = new pascalTriangle();
    List<List<Integer>> pascalTriangle = test.generate(2);
    for (List<Integer> row : pascalTriangle) {
      for (Integer num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}