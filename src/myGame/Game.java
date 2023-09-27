package myGame;

public class Game {
    public static void main(String args[]){
        char[][]box={
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        gamelayout(box);
    }
    public static  void gamelayout(char[][]box){
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                System.out.print(box[i][j]);
            }
            System.out.println();
        }
    }
}
