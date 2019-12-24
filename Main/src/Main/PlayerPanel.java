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
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=.5;
        gbc.weighty=.5;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=lifeAdjusters.length;
        add(lifeDisplay, gbc);
        //lifeAdjusters Setup/Add
        gbc.gridwidth=1;
        for(int i=0;i<lifeAdjusters.length;i++) {
            lifeAdjusters[i]=new JButton(lifeAdjustersStrings[i]);
            lifeAdjusters[i].setForeground(fgColor);
            lifeAdjusters[i].setBackground(bgColor);
            lifeAdjusters[i].addActionListener(this);
            lifeAdjusters[i].setFocusable(false);
            gbc.gridx++;
            gbc.gridy=1;
            add(lifeAdjusters[i], gbc);
        }
    }
    public void actionPerformed(ActionEvent evt) {
        Object e=evt.getSource();
        if(e.equals(lifeAdjusters[0])) {
            life-=5;
        }else if(e.equals(lifeAdjusters[1])) {
            life-=1;
        }else if(e.equals(lifeAdjusters[2])) {
            life+=1;
        }else if(e.equals(lifeAdjusters[3])) {
            life+=5;
        }
        lifeDisplay.setText(String.valueOf(life));
    }
}
