package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPanel extends JPanel implements ActionListener {
    //UI Objects
    JLabel lifeDisplay=new JLabel();
    String lifeAdjustersStrings[]={"-5","-1","+1","+5"};
    JButton lifeAdjusters[]=new JButton[lifeAdjustersStrings.length];
    //UI Variables
    private Color bgColor, fgColor;
    //Logic Variables
    private int life=-1;

    public PlayerPanel() {
        fgColor=Color.BLACK;
        bgColor=Color.WHITE;
        setupPanel();
    }
    public PlayerPanel(Color foregroundColor, Color backgroundColor) {
        fgColor=foregroundColor;
        bgColor=backgroundColor;
        setupPanel();
    }
    public PlayerPanel(Color foregroundColor, Color backgroundColor, int lifeTotal) {
        fgColor=foregroundColor;
        bgColor=backgroundColor;
        life=lifeTotal;
        setupPanel();
    }
    private void setupPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        //lifeDisplay Setup/Add
        lifeDisplay.setText(String.valueOf(life));
        lifeDisplay.setForeground(fgColor);
        lifeDisplay.setBackground(bgColor);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=0;
        add(lifeDisplay, gbc);
        //lifeAdjusters Setup/Add
        for(int i=0;i<lifeAdjusters.length;i++) {
            lifeAdjusters[i]=new JButton(lifeAdjustersStrings[i]);
            lifeAdjusters[i].setForeground(fgColor);
            lifeAdjusters[i].setBackground(bgColor);
            gbc.gridx++;
            gbc.gridy=1;
            add(lifeAdjusters[i], gbc);
        }
    }
    public void actionPerformed(ActionEvent evt) {

    }
}
