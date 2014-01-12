/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.
*/

/*

对一整个board, 检查它的行,列,块是否满足要求,不要对每一个数去检查, 太耗时. 而且这样可以省去动态计算3*3的麻烦

每一次检查,建一个HashSet, 如果contains了, 说明重复了, false; 没有contains, 就加入
可以新建Set<>, 新建一个boolean[9]的数组也是一样的

hashset和hashmap的区别: HashSet就是丢掉HashMap的Value, HashSet只有关键字, HashMap是关系.

HashSet包括了add, remove, contains, size等基本操作.

*/ 

public class Solution {
     
    public boolean isValidSudoku(char[][] board) {
       return checkRow(board) && checkColumn(board) && checkBox(board);
    }
    
    public boolean checkRow(char[][] board){
        for(int i=0; i<board.length; i++){
            HashSet<Character> row=new HashSet<Character>();
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='.') continue;
                else if(row.contains(board[i][j])) return false;
                else row.add(board[i][j]);
            }
        }
        return true;
    }
    
     public boolean checkColumn(char[][] board){
            for(int j=0; j<board.length; j++){
            HashSet<Character> column=new HashSet<Character>();
            for(int i=0; i<board.length; i++){
                if(board[i][j]=='.') continue;
                else if(column.contains(board[i][j])) return false;
                else column.add(board[i][j]);
            }
        }
        return true;
    }
  
    public boolean checkBox(char[][] board){
      for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                Set<Character> box = new HashSet<Character>();
                for(int m=0; m<3; m++){
                    for(int n=0; n<3;n++){
                        if(board[m+i][n+j]=='.') continue;
                        else if(box.contains(board[m+i][n+j])) return false;
                        else box.add(board[m+i][n+j]);
                        }
                    }
                }
            }
        return true;
    }
}
