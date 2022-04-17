package game;

/**
 * class Timekeeper
 * authors: Petrea Daniela & Stoica Dragos
 * Daemon class used for time keeping of a game
 */
public class Timekeeper extends Thread {

    int timeToExist;
    long startGameTime;
    long endGameTime;

    public Timekeeper(int timeInSeconds) {
        this.timeToExist = timeInSeconds;
    }

    @Override
    public void run() {
        while (timeToExist > 0) {
            try {
                Thread.sleep(1000);
                timeToExist--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("timekeeper over");
    }

    public int getTimeToExist() {
        return timeToExist;
    }

    public long getEndGameTime() {
        return endGameTime;
    }

    public long getStartGameTime() {
        return startGameTime;
    }

    public void setEndGameTime(long endGameTime) {
        this.endGameTime = endGameTime;
    }

    public void setStartGameTime(long startGameTime) {
        this.startGameTime = startGameTime;
    }

    public boolean isOver() {
        return timeToExist <= 0;
    }
}
