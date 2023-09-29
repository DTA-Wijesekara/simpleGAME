package myGame;

import java.util.*;

public class Game {
    static ArrayList<Integer> userlocations=new ArrayList<Integer>();
    static ArrayList<Integer> computerlocations=new ArrayList<Integer>();

//    main methord
    public static void main(String args[]){
        char[][]box={
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        gamelayout(box);
        String result;
        do{
            //        users turn using scanner
            Scanner input = new Scanner(System.in);
            System.out.print("enter your location of placement:X:");
            int location1=input.nextInt();
//            checking that space alredy filled or not
            while (userlocations.contains(location1)||computerlocations.contains(location1)){
                System.out.println("enter another location:X:");
                location1=input.nextInt();
            }
            getuserinput(box,location1,"user");
            gamelayout(box);
            result=validation();
            if (result=="you won" || result=="game drawn"){
                System.out.println(result);
                return;
            }
            System.out.println();

//        computers turn using random
            Random rand=new Random();
            int location2=rand.nextInt(9)+1;
//            checking that space alredy filled or not
            while (userlocations.contains(location2)||computerlocations.contains(location2)){
                location2=rand.nextInt(9)+1;
            }
            getuserinput(box,location2,"computer");
            System.out.println("computers turn:*:");
            gamelayout(box);
            result=validation();
            System.out.println(result);
        }while ((result!="you won")&&(result!="you lose")&&(result!="game drawn"));
        return;
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
            userlocations.add(location);
        }
        if(type.equals("computer")){
            symbol='*';
            computerlocations.add(location);
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
    public static String validation(){
        List r1 = Arrays.asList(1,2,3);
        List r2 = Arrays.asList(4,5,6);
        List r3 = Arrays.asList(7,8,9);
        List c1 = Arrays.asList(1,4,7);
        List c2 = Arrays.asList(2,5,8);
        List c3 = Arrays.asList(3,6,9);
        List d1 = Arrays.asList(1,5,9);
        List d2 = Arrays.asList(3,5,7);

        List<List>win = new ArrayList<List>();
        win.add(r1);
        win.add(r2);
        win.add(r3);
        win.add(c1);
        win.add(c2);
        win.add(c3);
        win.add(d1);
        win.add(d2);

        for (List list : win) {
            if(userlocations.containsAll(list)){
                return "you won";
            }
            else if(computerlocations.containsAll(list)){
                return "you lose";
            }
            else if(userlocations.size()+computerlocations.size()==9){
                return "game drawn";
            }
        }
        return "";
    }
}
