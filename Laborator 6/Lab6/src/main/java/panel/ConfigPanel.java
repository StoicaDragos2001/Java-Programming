package panel;

/**
 * @author Petrea Daniela & Stoica Dragos-Stefan
 * ConfigPanel class
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner1;
    JSpinner spinner2;
    JButton create;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * to init the ConfigPanel
     */
    private void init() {
        label = new JLabel("Grid size:");
        spinner1 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner1.setValue(10);
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner2.setValue(10);
        create = new JButton("Create");
        add(label); //JPanel uses FlowLayout by default
        add(spinner1);
        add(spinner2);
        add(create);
        create.addActionListener(this::create);
    }


    public int getRows() {
        return (int) spinner1.getValue();
    }

    public int getCols() {
        return (int) spinner2.getValue();
    }

    private void create(ActionEvent e) {
        this.frame.canvas.init(getRows(), getCols());
        this.frame.canvas.repaint();
        this.frame.canvas.setCircles(new LinkedList<>());
        this.frame.canvas.ok=0;
    }
}
