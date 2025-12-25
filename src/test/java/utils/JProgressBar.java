package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class JProgressBar {
    private javax.swing.JProgressBar progressBarComponent;
    private int progress = 0;

    public JProgressBar() {
        JFrame frame = new JFrame("Test Progress");
        progressBarComponent = new javax.swing.JProgressBar(0, 20); // Assuming 20 test cases
        progressBarComponent.setValue(0);
        progressBarComponent.setStringPainted(true);

        // Set preferred size to increase width and slim height
        progressBarComponent.setPreferredSize(new Dimension(400, 20));

        frame.setLayout(new BorderLayout());
        frame.add(progressBarComponent, BorderLayout.CENTER);
        frame.setSize(450, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void updateProgress() {
        progress++;
        progressBarComponent.setValue(progress);
    }

    public static void main(String[] args) {
        JProgressBar example = new JProgressBar();
        // Simulate running test cases
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(500); // Simulate time taken for each test case
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            example.updateProgress();
        }
    }
}
