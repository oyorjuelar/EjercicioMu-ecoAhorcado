/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author FamiliaOrjRod
 */
public class Main extends JFrame{

    private Timer timer;
    private ActionListener al;
    
public Main(){

add(new Muñeco());

}
    public static void main(String[] args) {
        // TODO code application logic here

        Main frame = new Main();
        frame.setTitle("Morraco");
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        

    }
    
}
