/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author chrisjuste
 */
public class Hanging {
    
    //This method receives the amount of wrong guesses and outputs the hangman status  
    public String hangEm(int wrongGuesses){
        String hangman = "";
        switch(wrongGuesses){
            case 0: 
                hangman = "";
                break;
            case 1: 
                hangman = "\n" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 2:
                hangman = "\n_________" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 3:
                hangman =  "\n_________" + "\n|       |" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 4:
                hangman =  "\n_________" + "\n|       |" + "\n|       O" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 5:
                hangman =  "\n_________" + "\n|       |" + "\n|       O" + "\n|       |" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 6:
                hangman =  "\n_________" + "\n|       |" + "\n|       O" + "\n|   --|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 7:
                hangman =  "\n_________" + "\n|       |" + "\n|       O" + "\n|   --|--" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 8:
                hangman =  "\n_________" + "\n|       |" + "\n|       O" + "\n|   --|--" + "\n|      /" + "\n|" + "\n|_______________________\n";
                break;
            case 9:
                hangman =  "\n_________" + "\n|       |" + "\n|       O" + "\n|   --|--" + "\n|      /\\" + "\n|" + "\n|_______________________" + "\n";
        }
        return hangman;
    }
    
}
