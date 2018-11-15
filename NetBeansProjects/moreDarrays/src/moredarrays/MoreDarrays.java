
package moredarrays;

/**
 *tick tack toe board
 */
public class MoreDarrays {


    public static void main(String[] args) {
char[][] board = new char[3][3];
board[0][0] = 'x';
board[1][1] = 'x';
board[2][0]='x';
board[1][2]='o';
board[2][2]='o';

for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
        System.out.printf("[%d][%d]=%s ", j,i,board[i][j]);
        
    }
    System.out.println();
}

    
}
}