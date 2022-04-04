package panel;

/**
 * @author Petrea Daniela & Stoica Dragos-Stefan
 * DrawingPanel class
 */
import mouseWithCircle.Circle;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Random;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    public int stoneSize = 20;
    int ok = 0;

    private LinkedList<Circle> circles = new LinkedList<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    /**
     * to init the DrawingPanel
     * @param rows that represents the number of the rows
     * @param cols that represents the number of the columns
     */
    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * it is applied when we make a click in canvas or some buttons
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        try {
            removeCircles(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        if (ok == 0) {
            try {
                paintSticks(g);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ok = 1;
        }
        try {
            paintSticksFromFileText(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            paintStones(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Circle> getCircles() {
        return circles;
    }

    public void setCircles(LinkedList<Circle> circles) {
        this.circles = circles;
    }

    /**
     * paints the grid with given number of rows and columns ( from the spinner)
     * @param g
     */
    public void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines TODO
        for (int line = 0; line < cols; line++) {
            int x1 = padX + line * cellWidth;
            int x2 = x1;
            int y1 = padY;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    /**
     * generate random sticks and store them in a file date.txt
     * @param graphicAgain
     * @throws IOException if file doesn't exist
     */
    private void paintSticks(Graphics2D graphicAgain) throws IOException {
        String content = "";
        String path = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab6\\date.txt";
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
        writer.write("");
        writer.flush();
        graphicAgain.setColor(Color.BLACK);
        Random random = new Random();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                if (random.nextInt(2) == 0) {
                    content += Integer.toString(x);
                    content += " ";
                    content += Integer.toString(y);
                    graphicAgain.setColor(Color.BLACK);
                    graphicAgain.setStroke(new BasicStroke(3));
                    if (random.nextInt(2) == 0) {
                        if (row == 0) {
                            graphicAgain.drawLine(x, y, x, y + cellHeight);
                            content += " ";
                            content += Integer.toString(x);
                            content += " ";
                            content += Integer.toString(y + cellHeight);
                            content += "\n";
                        } else {
                            graphicAgain.drawLine(x, y, x, y - cellHeight);
                            content += " ";
                            content += Integer.toString(x);
                            content += " ";
                            content += Integer.toString(y - cellHeight);
                            content += "\n";
                        }
                    } else {
                        if (col == 0) {
                            graphicAgain.drawLine(x, y, x + cellWidth, y);
                            content += " ";
                            content += Integer.toString(x + cellWidth);
                            content += " ";
                            content += Integer.toString(y);
                            content += "\n";
                        } else {
                            graphicAgain.drawLine(x, y, x - cellWidth, y);
                            content += " ";
                            content += Integer.toString(x - cellWidth);
                            content += " ";
                            content += Integer.toString(y);
                            content += "\n";
                        }
                    }
                }
            }
        }
        Files.write(Paths.get(path), content.getBytes());
    }

    /**
     * we read the coordinate of the sticks from the file and draw each time the constructor from the DrawingPanel is called
     * we generate another sticks when we press create or load
     * @param graphicAgain
     * @throws IOException
     */
    private void paintSticksFromFileText(Graphics2D graphicAgain) throws IOException {
        String path = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab6\\date.txt";
        File file = new File(
                path);
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String stringFromFile;
        graphicAgain.setColor(Color.BLACK);
        graphicAgain.setStroke(new BasicStroke(3));
        while ((stringFromFile = br.readLine()) != null) {
            int index = 0, coordinateX1 = 0, coordinateY1 = 0, coordinateX2 = 0, coordinateY2 = 0;
            for (String val : stringFromFile.split(" ", 4)) {
                if (index == 0)
                    coordinateX1 = Integer.parseInt(val);
                else if (index == 1)
                    coordinateY1 = Integer.parseInt(val);
                else if (index == 2)
                    coordinateX2 = Integer.parseInt(val);
                else
                    coordinateY2 = Integer.parseInt(val);
                index++;
            }
            graphicAgain.drawLine(coordinateX1, coordinateY1, coordinateX2, coordinateY2);
            index = 0;
        }
    }

    private String readFromFile() throws IOException {
        String path = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab6\\date.txt";
        File file = new File(
                path);
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String stringFromFile, stringReturned = "";
        while ((stringFromFile = br.readLine()) != null) {
            stringReturned += stringFromFile;
            stringReturned += "\n";
        }
        return stringReturned;
    }

    /**
     *
     * @return the coordinate of the circles from the file date1.txt
     * @throws IOException
     */
    private String readFromFileWithCircles() throws IOException {
        String path = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab6\\date1.txt";
        File file = new File(
                path);
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String stringFromFile, stringReturned = "";
        while ((stringFromFile = br.readLine()) != null) {
            stringReturned += stringFromFile;
            stringReturned += "\n";
        }
        return stringReturned;
    }

    /**
     * we implement the logic of the game
     * when the player execute a mouse pressed operation, a stone must be drawn at the mouse location:
     * red or blue depending on whose turn it is
     * validate the move, according to the game rules
     * @param graphicAgain
     * @throws IOException
     */
    private void paintStones(Graphics2D graphicAgain) throws IOException {
        String content = "", content2 = "", content3 = "";
        int gameNotEnd=0;
        String path = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab6\\date1.txt";
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
        writer.write("");
        writer.flush();
        int nrPlayer = 0;
        int neighbourX = 0, neighbourY = 0;
        for (Circle circlesIndex : circles) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int x = padX + col * cellWidth;
                    int y = padY + row * cellHeight;
                    if (nrPlayer % 2 == 0)
                        circlesIndex.setColor(Color.BLUE);
                    else
                        circlesIndex.setColor(Color.RED);
                    if ((circlesIndex.getX() >= x - stoneSize && circlesIndex.getX() <= x) && (circlesIndex.getY() >= y - stoneSize && circlesIndex.getY() <= y)) {
                        {
                            circlesIndex.setX(x - stoneSize / 2);
                            circlesIndex.setY(y - stoneSize / 2);
                            String path1 = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab6\\date.txt";
                            File file1 = new File(
                                    path1);
                            BufferedReader br1
                                    = new BufferedReader(new FileReader(file1));
                            String stringFromFile1;
                            while ((stringFromFile1 = br1.readLine()) != null) {
                                int index = 0, coordinateX1 = 0, coordinateY1 = 0, coordinateX2 = 0, coordinateY2 = 0;
                                for (String val : stringFromFile1.split(" ", 4)) {
                                    if (index == 0)
                                        coordinateX1 = Integer.parseInt(val);
                                    else if (index == 1)
                                        coordinateY1 = Integer.parseInt(val);
                                    else if (index == 2)
                                        coordinateX2 = Integer.parseInt(val);
                                    else
                                        coordinateY2 = Integer.parseInt(val);
                                    index++;
                                }
                                if (circlesIndex.getX() + stoneSize / 2 == coordinateX1 && circlesIndex.getY() + stoneSize / 2 == coordinateY1) {
                                    if (nrPlayer == 0 || (neighbourX == coordinateX2 && neighbourY == coordinateY2)) {
                                        content += Integer.toString(circlesIndex.getX());
                                        content += " ";
                                        content += Integer.toString(circlesIndex.getY());
                                        content += '\n';
                                        neighbourX = circlesIndex.getX() + stoneSize / 2;
                                        neighbourY = circlesIndex.getY() + stoneSize / 2;
                                        circlesIndex.draw(graphicAgain);
                                        content2="";
                                        content2 += (neighbourX);
                                        content2 += " ";
                                        content2 += (neighbourY);
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += (neighbourX) - cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2-cellWidth)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += (neighbourX) - cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2-cellWidth)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY+cellWidth;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2+cellWidth))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY+cellWidth;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2+cellWidth))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += neighbourX+cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2+cellWidth)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += neighbourX+cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2+cellWidth)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY-cellWidth;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2-cellWidth))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY-cellWidth;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2-cellWidth))))
                                                gameNotEnd=1;
                                        if(gameNotEnd==0)
                                            System.out.println("Player "+nrPlayer+" win the game");
                                        nrPlayer++;
                                        content2 = "";
                                    }
                                } else if (circlesIndex.getX() + stoneSize / 2 == coordinateX2 && circlesIndex.getY() + stoneSize / 2 == coordinateY2) {
                                    if (nrPlayer == 0 || (neighbourX == coordinateX1 && neighbourY == coordinateY1)) {
                                        content += Integer.toString(circlesIndex.getX());
                                        content += " ";
                                        content += Integer.toString(circlesIndex.getY());
                                        content += '\n';
                                        circlesIndex.draw(graphicAgain);
                                        neighbourX = circlesIndex.getX() + stoneSize / 2;
                                        neighbourY = circlesIndex.getY() + stoneSize / 2;
                                        content2="";
                                        content2 += (neighbourX);
                                        content2 += " ";
                                        content2 += (neighbourY);
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += (neighbourX) - cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2-cellWidth)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += (neighbourX) - cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2-cellWidth)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY+cellWidth;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2+cellWidth))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY+cellWidth;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2+cellWidth))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += neighbourX+cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2+cellWidth)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += neighbourX+cellWidth;
                                        content3 += " ";
                                        content3 += neighbourY;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX+cellWidth-stoneSize/2)+" "+(neighbourY-stoneSize/2))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY-cellWidth;
                                        content3 += " ";
                                        content3 += content2;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2-cellWidth))))
                                                gameNotEnd=1;
                                        content3 = "";
                                        content3 += content2;
                                        content3 += " ";
                                        content3 += neighbourX;
                                        content3 += " ";
                                        content3 += neighbourY-cellWidth;
                                        if (readFromFile().contains(content3))
                                            if(!(readFromFileWithCircles().contains((neighbourX-stoneSize/2)+" "+(neighbourY-stoneSize/2-cellWidth))))
                                                gameNotEnd=1;
                                        if(gameNotEnd==0)
                                            System.out.println("Player "+nrPlayer+" win the game");
                                        nrPlayer++;
                                        gameNotEnd=0;
                                    }
                                }

                                //  System.out.println(content2);
                            }

                        }
                    }
                }
            }
        }
        Files.write(Paths.get(path), content.getBytes());
    }

    /**
     * add circles in the linkedList
     * @param circle
     */
    public void addCircles(Circle circle) {
        circles.add(circle);
        this.repaint();
    }

    /**
     * delete the circles when we press create or load
     * @param graphicAgain
     * @throws IOException
     */
    public void removeCircles(Graphics2D graphicAgain) throws IOException {
        String path = "C:\\Users\\Daniela-211021\\IdeaProjects\\Lab6\\date1.txt";
        File file = new File(
                path);
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String stringFromFile;
        while ((stringFromFile = br.readLine()) != null) {
            int index = 0, coordinateX1 = 0, coordinateY1 = 0;
            for (String val : stringFromFile.split(" ", 2)) {
                if (index == 0)
                    coordinateX1 = Integer.parseInt(val);
                else if (index == 1)
                    coordinateY1 = Integer.parseInt(val);
                index++;
            }
            graphicAgain.fillOval(coordinateX1, coordinateY1, stoneSize, stoneSize);
            index = 0;
        }
        /*
        System.out.println("-----------------");
        for (Circle circlesIndex : circles) {
            System.out.println(circlesIndex.getX() + " " + circlesIndex.getY());
            circlesIndex.setColor(Color.WHITE);
            circlesIndex.draw(graphicAgain);
        }
        */
    }
}
