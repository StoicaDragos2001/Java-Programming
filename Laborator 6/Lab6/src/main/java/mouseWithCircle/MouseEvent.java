package mouseWithCircle;
/**
 * @author Petrea Daniela & Stoica Dragos-Stefan
 * MouseEvent class because we overwrite mouseClicked
 */
import panel.DrawingPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class MouseEvent extends MouseAdapter{
    private DrawingPanel panel;

    public MouseEvent(DrawingPanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        panel.addCircles(new Circle(e.getX()- panel.stoneSize/2,e.getY()- panel.stoneSize/2, panel.stoneSize, Color.BLUE));
    }
}