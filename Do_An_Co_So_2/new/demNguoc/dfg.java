package demNguoc;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dfg {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing Timer Example");
            frame.setSize(300, 200);

            JLabel label = new JLabel("Seconds: 0");
            label.setForeground(Color.black);
            frame.add(label);

//            Timer timer = new Timer(1000, new ActionListener() {
//                int seconds = 0;
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    seconds++;
//                    label.setText("Seconds: " + seconds);
//                }
//            });

            JButton startButton = new JButton("Start Timer");
//            startButton.addActionListener(e -> timer.start());

            JButton stopButton = new JButton("Stop Timer");
//            stopButton.addActionListener(e -> timer.stop());

            JPanel panel = new JPanel();
//            panel.add(startButton);
//            panel.add(stopButton);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
