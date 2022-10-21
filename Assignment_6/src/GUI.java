import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {
    public void createGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        // create JFrame instance
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(820, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create Panel
         */
        JPanel panel = new JPanel();
        // Add Panel
        frame.add(panel);
        /*
         * Add components to panel
         */
        placeComponents(panel);

        // set frame visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        //set Layout null
        panel.setLayout(null);

        // create JLabel of totalPoints
        JLabel totalPoints = new JLabel("Total Assignment Points:");
        totalPoints.setFont(new Font(null, Font.PLAIN, 25));
        totalPoints.setBounds(10,20,320, 40);
        panel.add(totalPoints);

        // create TextField of totalPoints
        JTextField totalPointsText = new JTextField(10);
        totalPointsText.setFont(new Font(null, Font.PLAIN, 25));
        totalPointsText.setBounds(330,20,100,40);
        panel.add(totalPointsText);

        // create JLabel of earnedPoints
        JLabel earnedPoints = new JLabel("Earned Points:");
        earnedPoints.setFont(new Font(null, Font.PLAIN, 25));
        earnedPoints.setBounds(10,100,320,40);
        panel.add(earnedPoints);
        // create TextField of earnedPoints
        JTextField earnedPointsText = new JTextField(10);
        earnedPointsText.setFont(new Font(null, Font.PLAIN, 25));
        earnedPointsText.setBounds(330,100,100,40);
        panel.add(earnedPointsText);
        // create JLabel of percentage
        JLabel percentage = new JLabel("Percentage of class:");
        percentage.setFont(new Font(null, Font.PLAIN, 25));
        percentage.setBounds(10,180,320,40);
        panel.add(percentage);
        // create TextField of percentage
        JTextField percentageText = new JTextField(10);
        percentageText.setFont(new Font(null, Font.PLAIN, 25));
        percentageText.setBounds(330,180,100,40);
        panel.add(percentageText);


        // create output JLabel
        JLabel weightedScore = new JLabel("Weighted Score:");
        weightedScore.setFont(new Font(null, Font.PLAIN, 25));
        weightedScore.setBounds(10,260,320,40);
        panel.add(weightedScore);
        // create output TextField

        JLabel weightedScoreText = new JLabel("0.00");
        weightedScoreText.setFont(new Font(null, Font.PLAIN, 25));
        weightedScoreText.setBounds(330,260,100,40);
        panel.add(weightedScoreText);


        // create Calculate button
        JButton calculateButton = new JButton("Click to calculate Score");
        calculateButton.setFont(new Font(null, Font.PLAIN, 25));
        calculateButton.setBounds(460, 100, 310, 40);
        panel.add(calculateButton);

        // create a WeightedGrades instance
        WeightedGrades weightedGrades = new WeightedGrades();
        // set ActionListener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (!weightedScoreText.getText().trim().equals("0.00")) {
                    totalPointsText.setText("");
                    earnedPointsText.setText("");
                    percentageText.setText("");
                    calculateButton.setText("Click to calculate Score");
                    weightedScoreText.setText("0.00");
                }
                else {
                    // pass user input to WeightedGrades
                    double totalScore = Double.parseDouble(totalPointsText.getText());
                    double earnedScore = Double.parseDouble(earnedPointsText.getText());
                    double percentage = Double.parseDouble(percentageText.getText());
                    weightedGrades.setTotalPoints(totalScore);
                    weightedGrades.setEarnedPoints(earnedScore);
                    weightedGrades.setAssignmentPercentage(percentage);
                    // execute calculation
                    weightedGrades.calculate();
                    double result = weightedGrades.getTotal_weighted_grades();
                    // keep two decimal places
                    weightedScoreText.setText(String.format("%.2f",result));
                    calculateButton.setText("Click to empty all input");

                }

            }
        });


    }

}


