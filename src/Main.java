import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;


public class Main {

    static Scanner in = new Scanner(System.in);
    static String name = "";
    static int timer = 30;
    static String [][] songDataSet = {
            {"Bohemian Rhapsody", "Rock", "Path 1"},
            {"Stairway to Heaven", "Rock", "Path 2"},
            {"Hotel California", "Rock", "Path 3"},
            {"Imagine", "Rock", "Path 4"},
            {"Smells Like Teen Spirit", "Rock", "Path 5"},
            {"Hey Jude", "Rock", "Path 6"},
            {"Sweet Child O' Mine", "Rock", "Path 7"},
            {"Comfortably Numb", "Rock", "Path 8"},
            {"Another Brick in the Wall", "Rock", "Path 9"},
            {"Dream On", "Rock", "Path 10"},
            {"Let It Be", "Rock", "Path 11"},
            {"Purple Haze", "Rock", "Path 12"},
            {"Don't Stop Believin'", "Rock", "Path 13"},
            {"Wish You Were Here", "Rock", "Path 14"},
            {"Back In Black", "Rock", "Path 15"},
            {"Back In Black", "Roack", "Path 15"},
    };

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
        System.out.println("And that playing this will make your day better and more fun");
        System.out.println("what shall i call you");
        name = in.nextLine();
        clearConsole();

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
               sgenre = sgenre.trim();
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

        // this is for the name, genre path
        // the reason why i do it this was is because it is a lot more consize  for now
        Songs [] songs = new Songs[15];
        int answer = 1, res = 0, num = 0;

        for (int i = 0; i < songDataSet.length; i++) {
            if (songDataSet[i][1].equals("Rock"))
                songs[i] = new Songs(songDataSet[i][0], songDataSet[i][1], songDataSet[i][2]);
        }
        for(Songs song : songs){
            System.out.println(song.name +" " + song.genre + " " + song.path);
        }

        for (int i = 0; i < 7; i++) {
            clearConsole();
            System.out.println("So lets see how many can you get right");
            System.out.println("GUESS THE TUNE");
            timer = timer(timer);
            if (timer <= 0){
                break;
            }
            System.out.println("So I am assuming you know that fine tune");
            System.out.println("So here are your options");
            System.out.println("1 - somehting");
            answer = in.nextInt();
            if(answer == 1) {
                res ++;
                System.out.println("you got it right nice job");
            }
        }
        clearConsole();
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

    public static void clearConsole() {
        try {
            // checks what is the specific opreating system which the person is using
            String os = System.getProperty("os.name").toLowerCase();


            if (os.contains("win")) {
                // the processbuilder is to create process for the opreating system.
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // same thing but if the person is using something other than window
                // meaning that clear will always work as for mac its clear
                // as well for all of the destros for linux its clear as well
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // if for some reason there is an error inside the terminal
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }


}