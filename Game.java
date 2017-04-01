import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Created by prince on 3/6/17.
 */
public class Game {
    static JFrame frame;
    Graphics graphics;
    Random random;
    static int x = 10, y = 10, xvel = 0, yvel = 0, a , b ,score=0;

    public static void main(String[] args) throws InterruptedException {
        frame = new JFrame("Game");
        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        Random random = new Random();
        a=random.nextInt(480 + 10);
        b=random.nextInt(480+10);
        panel.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);
        panel.setFocusable(true);
        Graphics graphics = panel.getGraphics();
        Thread.sleep(500);
        graphics.fillRect(x, y, 20, 20);
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    xvel = 10;
                    yvel = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    xvel = -10;
                    yvel = 0;

                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yvel = 10;
                    xvel = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    yvel = -10;
                    xvel = 0;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        while (true) {
            Thread.sleep(1000);
            graphics.setColor(Color.red);
            graphics.fillRect(0, 0, 10, 500);
            graphics.fillRect(0, 0, 500, 10);
            graphics.fillRect(490, 0, 10, 500);
            graphics.fillRect(0, 490, 500, 10);
            graphics.setColor(Color.blue);
            x = x + xvel;
            y = y + yvel;
            graphics.clearRect(10, 10, 480, 480);
            graphics.fillRect(a, b, 10, 10);
            graphics.fillRect(x, y, 20, 20);
            if (checkIntersection() == true) {
                break;
            }
            if (checkContact() == true) {
                score= score +10;
                a =   random.nextInt(480) +11;
                b =   random.nextInt(480) +11;
                continue;
            }
        }
    }

    public static boolean checkIntersection() {
        if ((x < 10) || (x > 470) || (y < 10) || (y > 470)) {
            JOptionPane.showMessageDialog(frame, "Game Over Your Score is="+score);
            frame.setVisible(false);

            return true;
        } else
            return false;
    }

    public static boolean checkContact() {
        if(((x <= a) && (a <= (x + 20)) && (y <= b) && (b <= (y + 20))))
            return true;
        else if (x <= (a + 10) && (a + 10) <= (x + 20) && y <= b && b <= (y + 20))
            return true;
        else if( x <= (a) && (a) <= (x + 20) && y <= (b + 10) && (b + 10) <= (y + 20))
            return true;
        else if (x <= (a + 10) && (a + 10) <= (x + 20) && y <= (b + 10) && (b + 10) <= (y + 20))
            return true;

        else
            return false;
    }


}
