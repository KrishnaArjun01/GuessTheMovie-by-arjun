/* This class consists of all the logic of guessing game like
 *
 *    1) Getting random movie and its position,total movie.
 *    2)
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    // Fields

    private  File moviesList = new File("Movies.txt");
    Scanner movieScanner = new Scanner(moviesList);
    private int totalMovies = findOuttotalMovie();
    private int chances = 7;
    private String gamePlayMovieName = processRandomMovieName().toUpperCase().replaceAll("[a-zA-Z]","_");
    private String withoutBlankMovie = processRandomMovieName().toUpperCase();
    private String correctGuessings = "";
    private String wrongGuessings = "";
    private boolean gameEnds = false;
    private boolean gameWon;



    public Game() throws Exception {
    }


    // All Methods


    /**
     * This method gives the total no. of movies in file.
     * @return  total no. of movies in file {@link File} as an int.
     * @throws Exception
     */
    private int findOuttotalMovie() throws Exception {

        String lineReader = null;
        int totalMovies;
        Scanner movieScanner1 = new Scanner(moviesList);

        // Finding total movies.
        for (totalMovies = 0; movieScanner1.hasNextLine(); totalMovies++){
            lineReader = movieScanner1.nextLine();
        }
        return totalMovies;
    }


    private String processRandomMovieName() throws Exception {

        // Giving random movie.

        int randomMovieNumber;
        String selectedMovie = null;
        Scanner movieScanner1 = new Scanner(moviesList);

        // Making a random integer btw 1-totalMovies.
        randomMovieNumber = (int)(Math.random()*totalMovies); 
        randomMovieNumber++;

        for (int i = 0;i<randomMovieNumber;i++) {
            selectedMovie = movieScanner1.nextLine();
        }

        // Testing It !!

        return selectedMovie ;

    }

    public void gamePlay() {


        // Taking and checking input.
        Scanner inputScanner = new Scanner(System.in);
        String inputLetterGuessed = inputScanner.next().toUpperCase();
        if(inputLetterGuessed.matches("[a-zA-Z]")){

            // Showing the correct guessed letter blanks.
            // if guessing is right.
            if (getterRealMovieName().contains(inputLetterGuessed)){

                if (!correctGuessings.contains(inputLetterGuessed)){
                    correctGuessings += inputLetterGuessed;
                    System.out.println("Bdia Bdia tarakki kr rhe ho");
                }

                else {
                    System.out.println("Bhaia " + inputLetterGuessed + " ho chuka zyada shana mat bano :");
                }
                // To convert into string to be guessed.
                gamePlayMovieName = getterRealMovieName().replaceAll("[^" + correctGuessings.trim() + " &&[^0-9]]", "_");
                System.out.println("Batao Bhai :" + gamePlayMovieName + "  Chances bachi hai :" + chances);
                System.out.println("Ye sb ho chuka :" + correctGuessings);
            }

            // If the guessed letter is wrong.
            else {

                if(!wrongGuessings.contains(inputLetterGuessed)){
                    chances --;  // Chances kam krna.
                    wrongGuessings += "" + inputLetterGuessed + " ";
                    System.out.println("Tumse NA HO PAEGA!!!" );
                }

                else {
                    System.out.println("Bhai kyu baar baar " + inputLetterGuessed);
                }

                System.out.println("-> " + wrongGuessings + " <-  Yeh sab Galat Hai" );
                System.out.println("Chances bachi hai :" + chances);
            }
        }

        // At invalid input
        else {
            System.out.println("KRIPYA PIKAR MAT LIKHE");
        }
    }

    // checks whether game has ended or not
    public void gameEndChecker() {

        if (chances>0 && gamePlayMovieName.contains("_") ){
            gameEnds = false;
        }
        else {
            gameEnds = true;
        }
    }

    // checks whether won or not
    public void gameWonChecker() {
        if (chances==0 && gamePlayMovieName.contains("_")){
            gameWon = false;
        }
        else {
            gameWon = true;
        }
    }

    public void gameRun () {

        while (!gameEnds) {
            gamePlay();
            gameEndChecker();
            gameWonChecker();
        }

        if(gameWon){
            System.out.println("LADKE JEET GAYA");
        }
        else {
            System.out.println("KAHA THA NA TUMSE NA HO PAEGA");
        }
    }

    // Getters

    // Gives real movie name.
    public String getterRealMovieName (){
        return withoutBlankMovie;
    }

    // Gives total no. of movies.
    public int getterTotalMovies () {
        return totalMovies;
    }

}
