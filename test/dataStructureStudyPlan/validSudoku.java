package dataStructureStudyPlan;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
 * according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 *
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
 * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * [[".",".",".",".",".",".","5",".","."]
 * ,[".",".",".",".",".",".",".",".","."]
 * ,[".",".",".",".",".",".",".",".","."]
 * ,["9","3",".",".","2",".","4",".","."]
 * ,[".",".","7",".",".",".","3",".","."]
 * ,[".",".",".",".",".",".",".",".","."]
 * ,[".",".",".","3","4",".",".",".","."]
 * ,[".",".",".",".",".","3",".",".","."]
 * ,[".",".",".",".",".","5","2",".","."]]
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class validSudoku {

  public boolean isValidSudoku(char[][] board) {
    // Since it is just 9 numbers use array of size 10 -> 9 digits + '.' (dot).
    // if an index exists then return false.

    int validNumberOfDigits = 9;


    for (int i = 0; i < board.length; i++) {
      int[] digitsRow = new int[validNumberOfDigits];
      int[] digitsCol = new int[validNumberOfDigits];
      for (int j = 0; j < board[0].length; j++) {
        int row;
        int col;

        // Row check
        if (board[i][j] != '.') {
          row = Character.getNumericValue(board[i][j]) - 1;
          if (digitsRow[row] != 0) {
            return false;
          } else {
            digitsRow[row] = 1;
          }
        }

        // Col Check
        if (board[j][i] != '.') {
          col = Character.getNumericValue(board[j][i]) - 1;

          if (digitsCol[col] != 0) {
            return false;
          } else {
            digitsCol[col] = 1;
          }
        }
      }
    }

    // Each 3 x 3 box.
    int colCount = 0;
    while (colCount < 9) {
      int rowCount = 0;
      while (rowCount < 9) {
        int[] digitsRow = new int[validNumberOfDigits];
//        int[] digitsCol = new int[validNumberOfDigits];
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            if (board[i + colCount][j + rowCount] != '.') {
              int num = Character.getNumericValue(board[i + colCount][j + rowCount]) - 1;
              System.out.print(num);
              if (digitsRow[num] != 0) {
                return false;
              } else {
                digitsRow[num] = 1;
              }
            }

//          if (board[j + rowCount][i] != '.') {
//            int num = Character.getNumericValue(board[j + rowCount][i]) - 1;
//            if (digitsCol[num] != 0) {
//              return false;
//            } else {
//              digitsCol[num] = 1;
//            }
//          }
          }
        }
        rowCount += 3;
      }
      colCount += 3;
    }
    return true;
  }
}
