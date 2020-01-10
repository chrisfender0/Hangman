/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author chrisjuste
 */
public class HangmanController {
    
    private HangmanModel model;
    private HangmanView view;
    public Hanging hung = new Hanging();
    
    public HangmanController(HangmanModel model, HangmanView view){
        this.model = model;
        this.model.introduction();
        this.view = view;
        this.view.addActionListener(new myActionListener());
        this.view.setVisible(true);
        view.updateLettersChosen(model.lettersChosen.toString());
        view.updateTriesRemaining(String.valueOf(model.triesRemaining));
        view.updateVisibleWord(model.visibleWordArray.toString());
        view.updateHanging(hung.hangEm(9 - model.triesRemaining));
    }
    
    class myActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(model.hangmanWordHandler.gameWon(model.visibleWordArray)==false && model.triesRemaining>0){
                model.loopMe(e.getActionCommand());
                view.updateLettersChosen(model.lettersChosen.toString());
                view.updateTriesRemaining(String.valueOf(model.triesRemaining));
                view.updateVisibleWord(model.visibleWordArray.toString());
                view.updateHanging(hung.hangEm(9 - model.triesRemaining));
                if(model.hangmanWordHandler.gameWon(model.visibleWordArray)==true){
                    JOptionPane.showMessageDialog(view, "You win !");
                    System.exit(0);
                }
                if(model.triesRemaining==0){
                    JOptionPane.showMessageDialog(view, "You lose ! The word was " + model.chosenWord);
                    System.exit(0);
                }
            } else if(model.hangmanWordHandler.gameWon(model.visibleWordArray)==true){
                JOptionPane.showMessageDialog(view, "You win !");
            } else {
                JOptionPane.showMessageDialog(view, "You lose ! The word was " + model.chosenWord);
            }
        }
        
    }
    
}
