import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;



public class Main {

    static Scanner in = new Scanner(System.in);
    static String name = "";
    static int timer = 30;


    public static void main(String[] args) throws InterruptedException, IOException {
        /*

            the main things which i need to do before this
            - check which is the genre the user wants to do
            - make a timer for the user for 30 second
            - stop it every single time the user enter somehting
            - calculate their score at the end
            - this will give them 4 option to chose from and they will need to
                and if they get the right answer then that is a good thing
            - make a menu for hte user

        */

        String sgenre = "";
        int genre;

        System.out.println("Hey there");
        System.out.println("hope you are having a wonderful day");
        System.out.println("And that playing this will make your day better and fun");
        System.out.println("what shall i call you");
        name = in.nextLine();

        System.out.println("What is the genre you would like to play");
        System.out.println("the genres are - ");
        System.out.println("1 - ROCK");
        System.out.println("2 - POP MUSIC");
        System.out.println("3 - Country");
        System.out.println("4 - JPON/ANIME");
        System.out.println("5 - Jazz");

        // check if the input which the user has entered is valid or not
        // if not it will keep asking the user again unit they give a valid input
        while(true) {
           try{
               sgenre = in.nextLine();
               genre = Integer.parseInt(sgenre);

               // checking if the user has entered something which isnt in the domain
               // for the genre and if then it will not break the loop and keep going
               if(!(genre >= 1 && genre <= 5)){
                   System.out.println("Invalid genre");
                   System.out.println("Pls enter a number between 1 and 5");
               } else {
                   break;
               }
           }catch (Exception e){
               System.out.println("Invalid genre");
               System.out.println("Pls enter a number between 1 and 5");
           }
        }




        // creating a switch case for the genre which the user has entered
        switch (genre) {
            case 1 -> rock();
            case 2 -> popMusic();
            case 3 -> country();
            case 4 -> jpon();
            case 5 -> jazz();
            default -> System.out.println("i dont think this is possible as there is a for while loop which is just made for this ");
        }

        in.close();
    }
    // if the user wants to rock
    static void rock() throws IOException, InterruptedException {
        int answer = 1, res = 0;
        for (int i = 0; i < 7; i++) {

            System.out.println("so " + name + " i see that you are a big fan of rock");
            System.out.println("So lets see how many cna you get right");
            System.out.println("GUESS THE TUNE");
            timer = timer(timer);
            System.out.println("So I am assuming you know that fine tune");
            System.out.println("So here are your options");
            System.out.println("1 - somehting");
            answer = in.nextInt();
            if(answer == 1) {
                res ++;
                System.out.println("you got it right nice job");
            }
        }

        System.out.println("you in the end got " + res + " right");
        System.out.println("lets goooooo");
    }

    static void popMusic() {

    }

    static void country() {

    }

    static void jpon() {

    }
    static void jazz() {}

    // check the times which the user has used
    static int timer(int remainTime) throws InterruptedException, IOException {
        String check = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (remainTime > 0) {

            if(reader.ready()){
                check = in.nextLine();
                if(check.equals(Character.toString((32)))){
                    return remainTime;
                }
                break;
            }
            System.out.println("remaing sec " + remainTime);
            Thread.sleep(1000);
            remainTime--;
        }

        return remainTime;
    }
}