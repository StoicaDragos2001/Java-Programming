package panel;

/**
 * @author Petrea Daniela & Stoica Dragos-Stefan
 * MainFrame class
 */

import mouseWithCircle.MouseEvent;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Game");
        init();
    }

    /**
     * init the MainFrame, we add 3 panels
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);


        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        canvas.addMouseListener(new MouseEvent(canvas));
        pack();
    }


    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

}

