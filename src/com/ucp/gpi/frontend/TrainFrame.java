package com.ucp.gpi.frontend;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.ucp.gpi.backend.model.RailwayNetwork;
import com.ucp.gpi.backend.run.Run;
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

    public static final boolean DEBUG_MODE = false;
    private JPanel panel1;
    private Dashboard dashboard;
    private STexturedButton blueButton;
    private STexturedButton orangeButton;
    private STexturedButton purpleButton;
    private STexturedButton greenButton;
    private JPanel rightBottomPanel;
    private JTextArea statsArea;
    private GraphicalPanel gPanel;
    private RailwayNetwork railwayNetwork;


    public TrainFrame() {
        $$$setupUI$$$();
        this.setTitle("Train Simulator 2018");
        this.setIconImage(Swinger.getResource("logo.png"));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setResizable(false);

        Run run = new Run(this);
        Thread thread = new Thread(run);
        thread.start();

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

        statsArea.setFocusable(false);

        dashboard.repaint();
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
        else if (e.getSource() == blueButton) {
            if (dashboard.getSelectedStation() != null)
                dashboard.getSelectedStation().getStation().break_station();
        } else if (e.getSource() == purpleButton)
            System.out.println("Purple");
        else if (e.getSource() == orangeButton) {
            if (dashboard.getSelectedStation() != null)
                dashboard.getSelectedStation().getStation().repair_station();
        }
    }

    @Override
    public void refreshAll(RailwayNetwork railwayNetwork) {
        if (DEBUG_MODE)
            System.out.println("////////// REFRESH ALL //////////");
        refreshPanel(railwayNetwork);
        refreshStats();
        GraphicalPanel.lock.lock();
        gPanel.setData(dashboard.getRailwayNetwork());
        GraphicalPanel.lock.unlock();
        pack();

    }

    @Override
    public void setNetwork(RailwayNetwork railwayNetwork) {
        this.railwayNetwork = railwayNetwork;
    }

    public void refreshPanel(RailwayNetwork railwayNetwork) {
        dashboard.setRailwayNetwork(railwayNetwork);
        dashboard.repaint();
    }

    public void refreshStats() {
        if (dashboard.getSelectedStation() == null)
            return;
        String text = "";
        if (dashboard.isSet() && dashboard.isSelectedOnce())
            text += "Selected station : " + (dashboard.getSelectedStation().getStation().getStationName());
        else
            text += "Selected station : " + (dashboard.getSelectedStationIndex() + 1);
        text += "\nStation ID : " + dashboard.getSelectedStation().getStation().getID();
        text += "\nNumber of trains : " + dashboard.getRailwayNetwork().getLines().get(0).getTrains().size();
        text += "\nCurrent passengers : " + dashboard.getSelectedStation().getStation().getUserList().size();
        text += "\nTotal passengers capacity : " + dashboard.getSelectedStation().getStation().getCapacity();

        statsArea.setText(text);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(5, 5, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-13157828));
        panel1.setForeground(new Color(-13157828));
        dashboard = new Dashboard();
        dashboard.setBackground(new Color(-12828863));
        panel1.add(dashboard, new GridConstraints(1, 1, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel1.add(spacer3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 10), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-12828863));
        panel1.add(panel2, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(500, -1), null, 0, false));
        statsArea = new JTextArea();
        statsArea.setBackground(new Color(-12828863));
        statsArea.setEditable(false);
        Font statsAreaFont = this.$$$getFont$$$("SansSerif", -1, 18, statsArea.getFont());
        if (statsAreaFont != null) statsArea.setFont(statsAreaFont);
        statsArea.setForeground(new Color(-1));
        statsArea.setText("Select a station\n\n\n\n");
        panel2.add(statsArea, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setText("Statistiques");
        panel2.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        panel1.add(spacer4, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        rightBottomPanel = new JPanel();
        rightBottomPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        rightBottomPanel.setBackground(new Color(-13157828));
        panel1.add(rightBottomPanel, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, new Dimension(-1, 40), 0, false));
        blueButton.setBackground(new Color(-10788147));
        rightBottomPanel.add(blueButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        orangeButton.setBackground(new Color(-4360678));
        rightBottomPanel.add(orangeButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        gPanel.setBackground(new Color(-12828863));
        panel1.add(gPanel, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        panel1.add(spacer5, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 10), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
