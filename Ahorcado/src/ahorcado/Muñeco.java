/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author FamiliaOrjRod
 */
public class Muñeco extends JPanel{


    private int t;
    private int tiempo=10;
    private ActionListener accion = new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent al){
               t+=1;
               repaint();
           }
        };
    private final Timer timer = new Timer(tiempo,accion);

    public Muñeco(){
 addKeyListener(new THandle());
 setFocusable(true);
 timer.start(); 
    }
    
    @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawArc(20, 500, 200, 100, 0, 180);
            g.drawLine(120, 500, 120, 100);
            g.drawLine(120, 100, 400, 100);
            g.drawLine(400, 100, OscilarX(100,t), OscilarY(100,t));
            g.fillOval((2*OscilarX(50,t)-25)-400, (2*OscilarY(50,t))-150, 50, 50);
            g.drawLine(OscilarX(100,t), OscilarY(100,t), OscilarX(170,t)-35, OscilarY(170,t)+(OscilarX(25,t)-400));
            g.drawLine(OscilarX(100,t), OscilarY(100,t), OscilarX(170,t)+35, OscilarY(170,t)-(OscilarX(25,t)-400));
            g.drawLine(OscilarX(100,t), OscilarY(100,t), OscilarX(200,t), OscilarY(200,t));
            g.drawLine(OscilarX(200,t), OscilarY(200,t), OscilarX(300,t)-35, OscilarY(300,t)+(OscilarX(25,t)-400));
            g.drawLine(OscilarX(200,t), OscilarY(200,t), OscilarX(300,t)+35, OscilarY(300,t)-(OscilarX(25,t)-400));
        }

    
    public int OscilarX(int radio, int t){
        return (int)(400+radio*Math.sin(Math.toRadians(t)));   
    }
    public int OscilarY(int radio, int t){
    return (int)(100+Math.abs(radio*Math.cos(Math.toRadians(t))));   
    }

        private class THandle extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
    
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_S) {
            timer.stop();
        }

        if (key == KeyEvent.VK_R) {
            timer.start();

        }
        
        if (key == KeyEvent.VK_UP) {
            tiempo-=2;
            if(tiempo<0){ tiempo=0; }
            timer.setDelay(tiempo);
        }

        if (key == KeyEvent.VK_DOWN) {
            tiempo+=2;
            if(tiempo<0){ tiempo=0; }
            timer.setDelay(tiempo);
        }
    }
        }
}
