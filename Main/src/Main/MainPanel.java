package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame implements ActionListener {
    //Final Variables
    private final static String TITLE="MTGPiApp", VERID="0.1";
    private final int COMMANDER=0, CONSTRUCTED=1, TWOHEADED=2;
    //UI Variables
    private MenuBar menuBar=new MenuBar();
    private String[] menuTitles={"Options","Help"};
    private Menu[] menus=new Menu[menuTitles.length];
    private Color[] bgColors={Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.MAGENTA},
            fgColors=new Color[bgColors.length];
    //Logic Variables
    private static int pC=3;
    private int format=COMMANDER;

    MainPanel(int playerCount) {
        setTitle(TITLE+" "+VERID);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel pane=new JPanel();
        pC=playerCount;
        PlayerPanel players[]=new PlayerPanel[pC];
        pane.setLayout(new GridLayout((int)Math.round(pC/2.),pC/2,5,5));
        for(int i=0;i<fgColors.length;i++) {
            fgColors[i]=Color.BLACK;
        }
        for(int i=0;i<pC;i++) {
            players[i]=new PlayerPanel(fgColors[i], bgColors[i], getStartingLifeTotal());
            pane.add(players[i]);
        }
        for(int i=0;i<menus.length;i++) {
            menus[i]=new Menu(menuTitles[i]);
            menuBar.add(menus[i]);
        }
        setMenuBar(menuBar);
        add(pane);
    }
    public void actionPerformed(ActionEvent evt) {

    }
    private int getStartingLifeTotal() {
        if(format==COMMANDER)
            return 40;
        else if(format==CONSTRUCTED)
            return 20;
        else if(format==TWOHEADED)
            return 30;
        else
            return -1;
    }
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        MainPanel mainPanel=new MainPanel(pC);
        mainPanel.setVisible(true);
    }
}
