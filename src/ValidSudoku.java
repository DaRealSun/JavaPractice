import java.util.HashSet;

public class ValidSudoku {
    static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean isValid = true;
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='.') continue;
                if(!set.add(board[i][j])){
                    isValid = false;
                    break;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if(board[j][i]=='.') continue;
                if(!set.add(board[j][i])){
                    isValid = false;
                    break;
                }
            }
        }

        for (int row = 0; row < 9; row+=3) {
            for (int col = 0; col < 9; col+=3) {
                HashSet<Character> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[k+row][j+col] == '.') continue;
                        if (!set.add(board[k+row][j+col])) {
                            isValid = false;
                            break;
                        }
                    }
                }
            }


        }
        IO.println(isValid);
    }
}
