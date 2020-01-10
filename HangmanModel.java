/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author chrisjuste
 */
public class HangmanModel {
    
    HangmanWordHandler hangmanWordHandler = new HangmanWordHandler();
    Hanging hanging = new Hanging();
    
    ArrayList<String> lettersChosen = new ArrayList<String>();
    ArrayList<String> splitChosenWord = new ArrayList<String>();
    ArrayList<String> visibleWordArray = new ArrayList<String>();
    
    String chosenWord = "";
    String visibleWord = "";
    
    int triesRemaining = 8;
    int lettersFound;
    
    public HangmanModel(){
        
    }
    public void introduction(){
        this.chosenWord = hangmanWordHandler.generateRandomWord();
        String[] splitWord = chosenWord.split("");
        Collections.addAll(splitChosenWord, splitWord);
        this.visibleWordArray = hangmanWordHandler.visibleWord(lettersChosen, splitChosenWord, visibleWordArray);
    }
    public void loopMe(String letter){
        if(lettersChosen.contains(letter)){
            JOptionPane.showMessageDialog(null, "You've already selected that letter");
        } else {
            this.lettersChosen.add(letter);
            this.visibleWordArray = hangmanWordHandler.visibleWord(lettersChosen, splitChosenWord, visibleWordArray);
            hangmanWordHandler.gameWon(visibleWordArray);
            lettersFound = hangmanWordHandler.lettersFound(visibleWordArray);
            if(hangmanWordHandler.letterFound(letter, splitChosenWord)==false){
                triesRemaining--;
            }
        }
    }
    
}
