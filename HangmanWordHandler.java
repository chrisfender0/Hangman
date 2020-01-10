/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author chrisjuste
 */
public class HangmanWordHandler {
    
    public String generateRandomWord(){
        //This method contains an array with 126 words and returns a random word 
        
        //array of top words from http://www.manythings.org/vocabulary/lists/a/words.php?f=noll15
        String[] easyWords = {"acres", "adult", "advice", "arrangement", 
            "attempt", "August", "Autumn", "border", "breeze", "brick", "calm", 
            "canal", "Casey", "cast", "chose", "claws", "coach", "constantly", 
            "contrast", "cookies", "customs", "damage", "Danny", "deeply", "depth", 
            "discussion", "doll", "donkey", "Egypt", "Ellen", "essential", "exchange", 
            "exist", "explanation", "facing", "film", "finest", "fireplace", "floating", 
            "folks", "fort", "garage", "grabbed", "grandmother", "habit", "happily", 
            "Harry", "heading", "hunter", "Illinois", "image", "independent", "instant", "January", 
            "kids", "label", "Lee", "lungs", "manufacturing", "Martin", "mathematics", "melted", 
            "memory", "mill", "mission", "monkey", "Mount", "mysterious", "neighborhood", "Norway", 
            "nuts", "occasionally", "official", "ourselves", "palace", "Pennsylvania", 
            "Philadelphia", "plates", "poetry", "policeman", "positive", "possibly", 
            "practical", "pride", "promised", "recall", "relationship", "remarkable", "require", "rhyme",
            "rocky", "rubbed", "rush", "sale", "satellites", "satisfied", "scared", "selection", 
            "shake", "shaking", "shallow", "shout", "silly", "simplest", "slight", "slip", 
            "slope", "soap", "solar", "species", "spin", "stiff", "swung", "tales", "thumb", 
            "tobacco", "toy", "trap", "treated", "tune", "University", "vapor", 
            "vessels", "wealth", "wolf", "zoo"};
        //return a random word out of the easyWords array
        return easyWords[(int)(Math.random() * easyWords.length - 1) + 1].toLowerCase();
    }
    
    /*
    This method takes 2 arguments: the current hangman game word and the letters the user has currently chosen
    
    We iterate through each letter of the current hangman game word and while on that letter 
    we iterate through the user letter arraylist 
    if a match is found, the updatedOutput gets updated with the letter, otherwise it updates with "_"
    */
    public ArrayList<String> visibleWord(ArrayList<String> lettersChosen, ArrayList<String> splitChosenWord, ArrayList<String> visibleWordArray){
        
        if(lettersChosen.isEmpty()==true){
            for(int i=0; i<splitChosenWord.size(); i++){
                visibleWordArray.add("_");
            }
        } else {
            for(int i=0; i<lettersChosen.size(); i++){
                for(int j=0; j<splitChosenWord.size(); j++){
                    if(lettersChosen.get(i).equals(splitChosenWord.get(j))){
                        visibleWordArray.remove(j);
                        visibleWordArray.add(j, lettersChosen.get(i));
                    }
                }
            }
        }
        
        return visibleWordArray;
    }
    public boolean gameWon(ArrayList<String> visibleWordArray){
        boolean noUnderscoresLeft = true;
        
        for (int i=0; i<visibleWordArray.size(); i++){
            if(visibleWordArray.get(i).equals("_")){
                noUnderscoresLeft = false;
            }
        }
        
        return noUnderscoresLeft;
    }
    public int lettersFound(ArrayList<String> visibleWordArray){
        int lettersFound = visibleWordArray.size();
        
        for (int i=0; i<visibleWordArray.size(); i++){
            if(visibleWordArray.get(i).equals("_")){
                lettersFound--;
            }
        }
        
        return lettersFound;
    }
    public boolean letterFound(String letter, ArrayList<String>splitChosenWord){
        boolean foundIt = false;
        for(int i=0; i<splitChosenWord.size(); i++){
            System.out.println("Comparing letter " + letter + " and splitChosenWord " + splitChosenWord.get(i));
            if(letter.equals(splitChosenWord.get(i))){
                foundIt = true;
                System.out.println("Found it during loop? = " + foundIt);
            } 
        }
        System.out.println("Found it ? = " + foundIt);
        return foundIt;
        
    }
}
