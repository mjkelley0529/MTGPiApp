package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame implements ActionListener {
    //Final Variables
    private final static String TITLE="MTGPiApp", VERID="0.1";
    private final int MAXPLAYERCOUNT=8, MINPLAYERCOUNT=2;
    private final int COMMANDER=0, CONSTRUCTED=1, TWOHEADED=2;
    //UI Variables
    private JPanel pane=new JPanel();
    private MenuBar menuBar=new MenuBar();
    private String[] menuTitles={"Options","Help"};
    private Menu[] menus=new Menu[menuTitles.length];
    private Color[] bgColors={Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.PINK, Color.MAGENTA, Color.ORANGE, Color.CYAN},
            fgColors=new Color[bgColors.length];
    //Logic Variables
    private static int pC=5;
    private int format=COMMANDER;

    MainPanel(int playerCount) {
        setTitle(TITLE+" "+VERID);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        for(int i=0;i<fgColors.length;i++) {
            fgColors[i]=Color.BLACK;
        }
        pC=playerCount;
        setupPlayers();
        for(int i=0;i<menus.length;i++) {
            menus[i]=new Menu(menuTitles[i]);
            menuBar.add(menus[i]);
        }
        setMenuBar(menuBar);
        add(pane);
    }
    public void actionPerformed(ActionEvent evt) {

    }
    private void setupPlayers() {
        PlayerPanel players[]=new PlayerPanel[pC];
        pane.setLayout(new GridLayout((int)Math.round(pC/2.),2,5,5));
        for(int i=0;i<pC;i++) {
            players[i]=new PlayerPanel(fgColors[i], bgColors[i], getStartingLifeTotal());
            pane.add(players[i]);
        }
    }
    private void setFormat(int format) {
        if(!(format<0||format>2)) {
            this.format=format;
        }
        setPlayerCount(getDefaultPlayerCount());
        setupPlayers();
    }
    private void setPlayerCount(int playerCount) {
        if(!(playerCount<MINPLAYERCOUNT||playerCount>MAXPLAYERCOUNT)) {
            pC=playerCount;
        }
    }
    private int getStartingLifeTotal() {
        switch (format) {
            case COMMANDER:
                return 40;
            case CONSTRUCTED:
                return 20;
            case TWOHEADED:
                return 30;
            default:
                return -1;
        }
    }
    private int getDefaultPlayerCount() {
        switch (format) {
            case COMMANDER:
                return 4;
            case CONSTRUCTED:
            case TWOHEADED:
                return 2;
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        MainPanel mainPanel=new MainPanel(pC);
        mainPanel.setVisible(true);
    }
}
