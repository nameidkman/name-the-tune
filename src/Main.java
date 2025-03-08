import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;


public class Main {

    static Scanner in = new Scanner(System.in);
    static String name = "";
    static int timer = 30;
    static final int numberOfRockSongs = 15;
    static final int numberOfPopSongs = 15;
    static final int numberOfJpopSongs = 15;
    static String[][] songDataSet = {
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

        menu();
        System.out.println("What is the genre you would like to play");
        System.out.println("the genres are - ");
        System.out.println("1 - ROCK");
        System.out.println("2 - POP MUSIC");
        System.out.println("4 - JPON/ANIME");
        sgenre = in.nextLine();
        genre = inputCheck(sgenre, 1, 5);

        // creating a switch case for the genre which the user has entered
        switch (genre) {
            case 1 -> rock();
            case 2 -> popMusic();
            case 3 -> country();
            case 4 -> jpon();
            case 5 -> jazz();
            default ->
                    System.out.println("i dont think this is possible as there is a for while loop which is just made for this ");
        }

        in.close();
    }

    // if the user wants to rock
    static void rock() throws IOException, InterruptedException {

        // this is for the name, genre path
        // the reason why i do it this was is because it is a lot more consize  for now
        Songs[] songs = new Songs[numberOfRockSongs];
        int answer = 1, res = 0, uAns = 0;
        int[] songIndexes = shuffle(1, 14, 7);
        String a = "";


        for (int i = 0; i < numberOfRockSongs; i++) {
            if (songDataSet[i][1].equals("Rock"))
                songs[i] = new Songs(songDataSet[i][0], songDataSet[i][1], songDataSet[i][2]);
        }

        for (int i = 0; i < 7; i++) {
            clearConsole();
            System.out.println("So lets see how many can you get right");
            System.out.println("GUESS THE TUNE");
            timer = timer(timer);
            if (timer <= 0) {
                break;
            }
            System.out.println("So I am assuming you know that fine tune");
            System.out.println("So here are your options");
            answer = option(songs, songIndexes, i);
            a = in.nextLine();
            uAns = inputCheck(a, 1, 4);
            if (answer == uAns) {
                res++;
                System.out.println("you got it right nice job");
            } else {
                System.out.println("no you got it wrong dont worry");
                System.out.println("you will get the next one right");
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

    static void jazz() {
    }

    // check the times which the user has used
    static int timer(int remainTime) throws InterruptedException, IOException {
        String check = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (remainTime > 0) {
            if (reader.ready()) {
                check = String.valueOf(reader.read());
                if (check != null) {
                    if (check.charAt(0) == 32) {
                        break;
                    } else {
                        remainTime++;
                        break;
                    }
                }
            }
            System.out.println();
            System.out.println("remaing sec " + remainTime);
            Thread.sleep(1000);
            remainTime--;
        }
        return remainTime;
    }


    // this is the function to clear the console
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


    // function for the menu
    static void menu() {
        String input = "";
        // keeps going until they press something which is valid
        while (true) {
            System.out.println("rules");
            System.out.println("play");
            System.out.println("Press 1 for rules and 2 for play");
            input = in.nextLine();
            if (input.equals("1")) {

                System.out.println("Basically you are given 30 sec");
                System.out.println("To guess 7 songs");
                System.out.println("There is a timer which is going to be counting down the time as we play");
                System.out.println("To break the time what you should do is press the enter");
                System.out.println("And the most important thing is to have fun");
                System.out.println("lets goo");
                clearConsole();

            } else if (input.equals("2")) {
                break;
            } else {
                System.out.println("pls enter something enter a valid option pls");
            }

        }
    }


    public static int inputCheck(String input, int lowerbound, int upperbound) {
        // check if the input which the user has entered is valid or not
        // if not it will keep asking the user again unit they give a valid input
        int value, a = 0;
        while (true) {
            try {
                if (a != 0)
                    input = in.nextLine();
                input = input.trim();
                value = Integer.parseInt(input);

                // checking if the user has entered something which isnt in the domain
                // for the genre and if then it will not break the loop and keep going
                if (!(value >= lowerbound && value <= upperbound)) {
                    System.out.println("Invalid option");
                    System.out.println("Pls enter a number between " + lowerbound + " and " + upperbound);
                    a++;
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid option");
                System.out.println("Pls enter a number between " + lowerbound + " and " + upperbound);
                a++;
            }
        }
        return value;
    }

    public static int[] shuffle(int lowerbound, int upperbound, int size) {

        int[] rangeArray = new int[upperbound - lowerbound + 1];
        for (int i = lowerbound; i < upperbound; i++) {
            rangeArray[i] = i + lowerbound;
        }

        Random random = new Random();
        int currentIndex = rangeArray.length;

        while (currentIndex != 0) {
            int randomIndex = random.nextInt(currentIndex);
            currentIndex--;

            // Swap elements
            int temp = rangeArray[currentIndex];
            rangeArray[currentIndex] = rangeArray[randomIndex];
            rangeArray[randomIndex] = temp;
        }

        // Select the first 'size' elements after shuffling
        int[] result = new int[size];
        System.arraycopy(rangeArray, 0, result, 0, size);

        return result;

    }

    public static int option(Songs[] song, int[] num, int currentIndex) {

        int[] a = shuffle(1, 14, 3);
        int rand = (int) (Math.random() * 4) + 1;

        switch (rand) {
            case 1:
                System.out.println(song[currentIndex].name);
                printSongs(song, a, currentIndex);
                break;
            case 2:
                printSongs(song, a, currentIndex);
                System.out.println(song[currentIndex].name);
                break;
            case 3:
                printSongs(song, a, currentIndex);
                System.out.println(song[currentIndex].name);
                break;
            default:
                printSongs(song, a, currentIndex);
                System.out.println(song[currentIndex].name);
                break;
        }

        System.out.println(rand);
        return rand;
    }


    private static void printSongs(Songs[] song, int[] a, int currentIndex) {
        for (int i : a) {
            if (i == currentIndex) {
                if (currentIndex != 0) {
                    System.out.println(song[currentIndex - 1].name);
                } else {
                    System.out.println(song[currentIndex + 1].name);
                }
            } else {
                System.out.println(song[i].name);
            }

        }
    }
}