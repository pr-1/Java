import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by prince on 3/6/17.
 */
public class Game {

     Graphics graphics;
    static int x=0,y=0;
    public static void main(String[] args) throws InterruptedException {
        JFrame frame=new JFrame("Game");
        JPanel panel=new JPanel();
        frame.setContentPane(panel);
        panel.setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);
        panel.setFocusable(true);
        Graphics graphics  =panel.getGraphics();
        Thread.sleep(200);
        graphics.setColor(Color.blue);
        graphics.fillRect(x,y,20,20);
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()== KeyEvent.VK_RIGHT)
                {
                    graphics.clearRect(0,0,500,500);
                    x=x+10;
                    graphics.fillRect(x,y,20,20);
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    graphics.clearRect(0,0,500,500);
                    x=x-10;
                    graphics.fillRect(x,y,20,20);

                }
                if(e.getKeyCode()== KeyEvent.VK_DOWN)
                {
                    graphics.clearRect(0,0,500,500);
                    y=y+10;
                    graphics.fillRect(x,y,20,20);
                }
                if(e.getKeyCode()== KeyEvent.VK_UP)
                {
                    graphics.clearRect(0,0,500,500);
                    y=y-10;
                    graphics.fillRect(x,y,20,20);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

}
