// It does all the main work.


public class Main {

    public static void main(String [] args) throws Exception {
        // Here the Coding begins

        // All the Fields

        Game guessGame = new Game();
// Here Intro begins.
        System.out.println("Hey Welcome to Guess The Movie Game.");
        System.out.println("You will get 7 CHANCES to guess a random movie.");
        System.out.println("");
        System.out.println("");
        System.out.println("So let \" THE GAME BEGIN \"");
// Here Intro ends.

        System.out.println("Movie Name is :YHI TO BATANA HAI :)      From Total Movies :" + guessGame.getterTotalMovies());
        System.out.println("Total characters are :" + guessGame.getterRealMovieName().length() );
        System.out.println("Chalo Batao :  " + guessGame.getterRealMovieName().replaceAll("[a-zA-Z]","_") );
        guessGame.gameRun();
    }
}
