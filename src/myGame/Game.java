package myGame;

import java.util.Arrays;
import java.util.List;
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

        while (true){
            //        users turn using scanner
            Scanner input = new Scanner(System.in);
            System.out.println("enter your location of placement:");
            int location1=input.nextInt();
            getuserinput(box,location1,"user");

//        computers turn using random
            Random rand=new Random();
            int location2=rand.nextInt(9)+1;
            getuserinput(box,location2,"computer");

            gamelayout(box);
        }
    }

//    methord for printing
    public static  void gamelayout(char[][]box){
//        box.length giving num of rows
//        box[0].length giving num of columns
        for (int i=0;i<box.length;i++){
            for (int j=0;j<box.length;j++){
                System.out.print(box[i][j]);
            }
            System.out.println();
        }
    }
//    added functionality
    public static void getuserinput(char[][]box,int location,String type){
        char symbol=' ';
        if(type.equals("user")){
            symbol='X';
        }
        if(type.equals("computer")){
            symbol='0';
        }
        switch (location){
            case 1:box[0][0]=symbol;break;
            case 2:box[0][2]=symbol;break;
            case 3:box[0][4]=symbol;break;
            case 4:box[2][0]=symbol;break;
            case 5:box[2][2]=symbol;break;
            case 6:box[2][4]=symbol;break;
            case 7:box[4][0]=symbol;break;
            case 8:box[4][2]=symbol;break;
            case 9:box[4][4]=symbol;break;
        }
    }
//    adding conditions and validations
    public static void validation(){
        List r1 = Arrays.asList(1,2,3);
        List r2 = Arrays.asList(4,5,6);
        List r3 = Arrays.asList(7,8,9);
        List c1 = Arrays.asList(1,4,7);
        List c2 = Arrays.asList(2,5,8);
        List c3 = Arrays.asList(3,6,9);
        List d1 = Arrays.asList(1,5,9);
        List d1 = Arrays.asList(3,5,7);
    }
}
