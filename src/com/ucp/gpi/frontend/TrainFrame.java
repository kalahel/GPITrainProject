package com.ucp.gpi.frontend;

import com.ucp.gpi.frontend.panels.Dashboard;
import com.ucp.gpi.frontend.panels.Displayable;
import com.ucp.gpi.frontend.panels.GraphicalPanel;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;
import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TrainFrame extends JFrame implements SwingerEventListener, Displayable {

    private JPanel panel1;
    private Dashboard dashboard;
    private JPanel leftBottomPanel;
    private STexturedButton blueButton;
    private STexturedButton orangeButton;
    private STexturedButton purpleButton;
    private STexturedButton greenButton;
    private JPanel rightBottomPanel;
    private JTextArea statsArea;
    private GraphicalPanel gPanel;

    public TrainFrame() {
        this.setTitle("Train Simulator 2018");
        this.setIconImage(Swinger.getResource("logo.png"));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setResizable(false);

        dashboard.setPreferredSize(new Dimension(Dashboard.DB_SIZE_X, Dashboard.DB_SIZE_Y));

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        dashboard.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dashboard.getStationFromClick(e);
                refreshAll();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        dashboard.repaint();
        leftBottomPanel.setBackground(new Color(0, 0, 0, 0));
        rightBottomPanel.setBackground(new Color(0, 0, 0, 0));

        blueButton.addEventListener(this);
        orangeButton.addEventListener(this);
        purpleButton.addEventListener(this);
        greenButton.addEventListener(this);
    }

    void createUIComponents() {
        blueButton = new STexturedButton(Swinger.getResource("blueButton.png"));
        blueButton.setPreferredSize(new Dimension(100, 100));

        orangeButton = new STexturedButton(Swinger.getResource("orangeButton.png"));
        orangeButton.setPreferredSize(new Dimension(100, 100));

        purpleButton = new STexturedButton(Swinger.getResource("purpleButton.png"));
        purpleButton.setPreferredSize(new Dimension(100, 100));

        greenButton = new STexturedButton(Swinger.getResource("greenButton.png"));
        greenButton.setPreferredSize(new Dimension(100, 100));

        gPanel = new GraphicalPanel();
    }

    @Override
    public void onEvent(SwingerEvent e) {
        if (e.getSource() == greenButton)
            System.out.println("Green");
        else if (e.getSource() == blueButton)
            this.refreshPanel();
        else if (e.getSource() == purpleButton)
            System.out.println("Purple");
        else if (e.getSource() == orangeButton)
            System.out.println("Orange");
    }

    public void refreshAll() {
        refreshPanel();
        refreshStats();
        pack();
    }

    @Override
    public void refreshPanel() {
        dashboard.repaint();
    }

    public void refreshStats() {
        String text = "";
        text += "Station sélectionnée : " + (dashboard.getSelectedStationIndex() + 1);
        text += "\nSatisfaction moyenne : X";
        text += "\nOccupation moyenne des trains et des gares : X";
        text += "\nNombre de passagers actuel : X";
        text += "\nNombre de passagers total : X";

        statsArea.setText(text);
    }
}
