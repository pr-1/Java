import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by prince on 3/1/17.
 */
public class Demo implements ActionListener {
    static JLabel label,label1;
    static JButton button,button1;
     static JTextField name,password;

    public static void main(String[] args) {
        form();

    }
    public static void form()
    {

        JFrame frame=new JFrame("Form");
        JPanel panel=new JPanel();
        panel.setPreferredSize(new Dimension(500,500));
        frame.setContentPane(panel);
        frame.pack();
        label=new JLabel("username");
        name=new JTextField("hvh");
        password=new JTextField("hgvhg");
        label1=new JLabel("password");
        button =new JButton("Log in");
        button1 = new JButton("Sign up");
        panel.add(label);
        panel.add(name);
        panel.add(label1);
        panel.add(password);
        panel.add(button);
        panel.add(button1);
        button.addActionListener(new Demo());
        button1.addActionListener(new Demo());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==button)
      {
          System.out.println(name.getText());
          System.out.println(password.getText());

      }
      else if(e.getSource()==button1)
      {
          form();
      }
    }
}
