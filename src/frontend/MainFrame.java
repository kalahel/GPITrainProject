package frontend;

import javax.swing.*;

public class MainFrame extends JFrame{
    public static final int FRAME_SIZE_X = 1000;
    public static final int FRAME_SIZE_Y = 300;

    private Dashboard dashboard = new Dashboard();


    public MainFrame() {
        super("Train simulation");
        getContentPane().add(dashboard);
        setSize(FRAME_SIZE_X, FRAME_SIZE_Y);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        MainFrame simulationGUI = new MainFrame();
    }
}
