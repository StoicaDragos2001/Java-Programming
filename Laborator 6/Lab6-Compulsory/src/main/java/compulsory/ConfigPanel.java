package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner1;
    JSpinner spinner2;
    JButton undo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        spinner1 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner1.setValue(10);
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner2.setValue(10);
        add(label); //JPanel uses FlowLayout by default
        add(spinner1);
        add(spinner2);
    }


    public int getRows() {
        System.out.println((int)spinner1.getValue());
        return (int) spinner1.getValue();
    }

    public int getCols() {
        return (int) spinner2.getValue();
    }
}
