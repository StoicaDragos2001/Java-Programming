package panel;

/**
 * @author Petrea Daniela & Stoica Dragos-Stefan
 * ControlPanel class
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * to init the ControlPanel
     */
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 3));

        // Add all the buttons
        add(saveBtn, BorderLayout.CENTER);
        add(loadBtn, BorderLayout.CENTER);
        add(exitBtn, BorderLayout.CENTER);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);

    }

    private void save(ActionEvent event) {
        frame.pack();
        BufferedImage img = new BufferedImage(frame.canvas.canvasWidth, frame.canvas.canvasHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        frame.canvas.paint(g2d);
        g2d.dispose();
        try {
            ImageIO.write(img, "png", new File("frame.png"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        //   frame.dispose();
    }

    private void load(ActionEvent event) {
        this.frame.canvas.setCols(10);
        this.frame.canvas.setRows(10);
        this.frame.canvas.init(10, 10);
        this.frame.configPanel.spinner1.setValue(10);
        this.frame.configPanel.spinner2.setValue(10);
        this.frame.canvas.repaint();
        this.frame.canvas.setCircles(new LinkedList<>());
        this.frame.canvas.ok = 0;
    }

    private void exit(ActionEvent event) {
        System.out.println("Exit with success!");
        frame.dispose();
    }


}
