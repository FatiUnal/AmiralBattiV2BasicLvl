import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginScreen extends JFrame {
    private JPanel wrapper;
    private JButton oyunaBaşlaButton;

    public loginScreen(){
        add(wrapper);
        setTitle("Amiral Battı");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        oyunaBaşlaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userBoard u = new userBoard();
                dispose();
            }
        });
        setVisible(true);


    }
}
