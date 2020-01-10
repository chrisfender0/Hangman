/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author chrisjuste
 */
public class GameManager {
    //intro in = new intro();
    
    public GameManager(){
        //in.setVisible(true);
        //in.addActionListener(new myActionListener()); 
        newGame();
    }
    public void newGame(){
        HangmanModel model = new HangmanModel();
        HangmanView view = new HangmanView();
        HangmanController controller = new HangmanController(model, view);
    }
    class myActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            newGame();
        }
        
    }
}
