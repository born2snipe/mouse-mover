package b2s.mouse.mover;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class App extends JFrame {
    public App() {
        super("Mouse Mover");
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new Task(), 5000L, 5000L);
        setSize(100, 100);
        setLocationByPlatform(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class Task extends TimerTask {
        private java.util.List<Point> moveLocations = Arrays.asList(
                new Point(10, 10),
                new Point(10, 100),
                new Point(100, 100),
                new Point(100, 10)
        );
        private int index = 0;

        @Override
        public void run() {
            try {
                if (index > moveLocations.size() - 1) {
                    index = 0;
                }
                Point point = moveLocations.get(index);

                Robot robot = new Robot();
                robot.mouseMove(point.x, point.y);
                index++;
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
}
