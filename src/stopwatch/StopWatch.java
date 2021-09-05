package stopwatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopWatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_str = String.format("%02d", seconds);
    String minutes_str = String.format("%02d", minutes);
    String hours_str = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime+=1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60 ;
            seconds = (elapsedTime/1000) % 60;

            String seconds_str = String.format("%02d", seconds);
            String minutes_str = String.format("%02d", minutes);
            String hours_str = String.format("%02d", hours);

            timeLabel.setText(hours_str+":"+minutes_str+":"+seconds_str);
        }
    });

    StopWatch() {

        timeLabel.setText(hours_str+":"+minutes_str+":"+seconds_str);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100,200,100,50);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,200,100,50);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(timeLabel);
        frame.add(startButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton) {
            if (!started) {
                started = true;
                startButton.setText("STOP");
                start();
            }
            else {
                started = true;
                startButton.setText("START");
                stop();
            }
        }
        if(e.getSource()==resetButton){
            started = false;
            startButton.setText("START");
            reset();
        }
    }
    void start() {
        timer.start();
    }
    void stop() {
        timer.stop();
    }
    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        String seconds_str = String.format("%02d", seconds);
        String minutes_str = String.format("%02d", minutes);
        String hours_str = String.format("%02d", hours);

        timeLabel.setText(hours_str+":"+minutes_str+":"+seconds_str);
    }

}
