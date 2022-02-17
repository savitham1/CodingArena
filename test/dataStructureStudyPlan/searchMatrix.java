package dataStructureStudyPlan;

public class searchMatrix {
  public boolean searchMatrixSolution(int[][] matrix, int target) {
    // get values of 1st column
    // apply binary search and find index
    // get values of that row and apply binary search

    int colToSearch = 0;
    int rowIndex = binarySearchOnCol(matrix, 0, matrix.length - 1, target, colToSearch);

    if (rowIndex == -1) {
      return false;
    }
    int id = binarySearchOnRow(matrix, 0, matrix[0].length - 1, target, rowIndex);

    return id != -1;

  }

  private int binarySearchOnCol(int[][] arr, int start, int end, int target, int col) {
    if (start > end) {
      return end;
    }

    int mid = (end - start) / 2 + start;
    if (arr[mid][col] == target) {
      return mid;
    }
    else if (arr[mid][col] > target) {
      return binarySearchOnCol(arr, start, mid - 1, target, col);
    }
    else {
      return binarySearchOnCol(arr, mid + 1, end, target, col);
    }
  }

  private int binarySearchOnRow(int[][] arr, int start, int end, int target, int row) {
    if (start > end) {
      return -1;
    }

    int mid = (end - start) / 2 + start;
    if (arr[row][mid] == target) {
      return mid;
    }
    else if (arr[row][mid] > target) {
      return binarySearchOnRow(arr, start, mid - 1, target, row);
    }
    else {
      return binarySearchOnRow(arr, mid + 1, end, target, row);
    }
  }
}
