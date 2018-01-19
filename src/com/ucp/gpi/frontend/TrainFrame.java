package com.ucp.gpi.frontend;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;
import fr.theshark34.swinger.util.WindowMover;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TrainFrame extends JFrame implements SwingerEventListener {

    public static final int FRAME_SIZE_X = 1000;
    public static final int FRAME_SIZE_Y = 400;

    private JPanel panel1;
    private Dashboard dashboard1;
    private JPanel bottomPanel;
    private STexturedButton blueButton;
    private STexturedButton orangeButton;
    private STexturedButton purpleButton;
    private STexturedButton greenButton;

    public TrainFrame() {
        this.setTitle("Train Simulator 2018");
        this.setIconImage(Swinger.getResource("logo.png"));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        dashboard1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.err.println(e.getX() + ";" + e.getY());
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
        dashboard1.repaint();
        bottomPanel.setBackground(new Color(0, 0, 0, 0));

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
    }

    @Override
    public void onEvent(SwingerEvent e) {
        if (e.getSource() == greenButton)
            System.out.println("Green");
        else if (e.getSource() == blueButton)
            this.dashboard1.repaint();
        else if (e.getSource() == purpleButton)
            System.out.println("Purple");
        else if (e.getSource() == orangeButton)
            System.out.println("Orange");
    }
}
