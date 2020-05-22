package races;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Race extends JFrame implements WindowListener {

    private final int WIDTH =1200;
    private final int HEIGHT = 600;
    private RacePanel racePanel;

    private int totalDistance;
    private ArrayList<Racer> racers;
    private Boolean isRunning = false;
    private Timer timer = new Timer();

    public Race(int totalDistance, ArrayList<Racer> racers){
        this.totalDistance = totalDistance;
        this.racers = racers;

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Race");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.racePanel = new RacePanel(1000, 200, racers, totalDistance);
        this.add(racePanel);
        this.setVisible(true);

        // Don't forget to stop the race, otherwise it will continue to calculate racers positions
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                isRunning = false;
            }
        });


    }

    public void start(){
        isRunning = true;

        // Set up the repeated task that will update the subject states (seconds)
        TimerTask repeatedTask = new TimerTask() {
            public void run() {

                while(isRunning){
                    System.out.println(racers.get(1).getCurrentDistanceMeter());
                    // Check if there is a winner
                    for(Racer racer : racers){
                        if(racer.getCurrentDistanceMeter() >= totalDistance){
                            isRunning = false;
                            displayWinner();
                            break;
                        }
                    }

                    // there is no winner -> run one tick
                    for(Racer racer : racers){
                        racer.runOneTick(2);
                    }

                    racePanel.repaint();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
           }
        };

        long delay  = 0;
        long period = 10;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);






    }

    public void stop() {

    }

    private void displayRace() {

    }

    private void displayWinner() {

    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.out.println("Windows closing");
        isRunning = false;
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        System.out.println("windows closed");
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
