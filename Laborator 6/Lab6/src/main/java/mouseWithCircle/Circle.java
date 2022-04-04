package mouseWithCircle;
/**
 * @author Petrea Daniela & Stoica Dragos-Stefan
 * Circle class that describes the stones from the game ( with x and y coordonate, diameter and color)
 */
import java.awt.*;

public class Circle {
    private int x;
    private int y;
    private int diameter;
    private Color color;

    Circle(int x, int y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x,y,diameter,diameter);
    }
}
