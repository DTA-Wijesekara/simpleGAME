package myGame;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String args[]){
        char[][]box={
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};

//        users turn using scanner
        Scanner input = new Scanner(System.in);
        System.out.println("enter your location of placement:");
        int locaton1=input.nextInt();
        getuserinput();

//        computers turn using random
        Random rand=new Random();
        int location2=rand.nextInt(9)+1;

        getuserinput();
        gamelayout(box);
    }

//    methord for printing
    public static  void gamelayout(char[][]box){
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                System.out.print(box[i][j]);
            }
            System.out.println();
        }
    }
    public static void getuserinput(){}
}
