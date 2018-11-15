package ticktacktoe;


public class board {
    
    public marker[][] board;
    
    public board() {
     this.board = new marker[3][3];
     this.Clear();
    }
    public board(marker[][] theboard) {
        this.board = theboard;
    }
    public final void Clear(){
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
            this.board[i][j] = marker.E;}
        }
    }
}
 