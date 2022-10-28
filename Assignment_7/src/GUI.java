import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    private FileIO fileIO;
    public void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        // create JFrame instance
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setSize(880, 1024);
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

    private void placeComponents(JPanel panel) {

        //set Layout null
        panel.setLayout(null);

        // reading part
        JLabel readingFileName = new JLabel("Reading File Name: ");
        readingFileName.setFont(new Font(null, Font.PLAIN, 25));
        readingFileName.setBounds(60, 50, 320, 40);
        panel.add(readingFileName);

        JTextField readingFilePath = new JTextField(10);
        readingFilePath.setFont(new Font(null, Font.PLAIN, 15));
        readingFilePath.setBounds(20, 120, 350, 40);
        panel.add(readingFilePath);

        // reading Button
        JButton readButton = new JButton("Click to read from file: ");
        readButton.setFont(new Font(null, Font.PLAIN, 25));
        readButton.setBounds(40, 200, 300, 40);
        panel.add(readButton);

        // hint text
        JLabel instruction1 = new JLabel("First five lines of file: ");
        instruction1.setFont(new Font(null, Font.PLAIN, 25));
        instruction1.setBounds(40, 280, 300, 40);
        panel.add(instruction1);

        // display five lines of line
        JLabel readText1 = new JLabel("");
        readText1.setFont(new Font(null, Font.PLAIN, 15));
        readText1.setBounds(10, 330, 430, 40);
        panel.add(readText1);
        JLabel readText2 = new JLabel("");
        readText2.setFont(new Font(null, Font.PLAIN, 15));
        readText2.setBounds(10, 360, 430, 40);
        panel.add(readText2);
        JLabel readText3 = new JLabel("");
        readText3.setFont(new Font(null, Font.PLAIN, 15));
        readText3.setBounds(10, 390, 430, 40);
        panel.add(readText3);
        JLabel readText4 = new JLabel("");
        readText4.setFont(new Font(null, Font.PLAIN, 15));
        readText4.setBounds(10, 420, 430, 40);
        panel.add(readText4);
        JLabel readText5 = new JLabel("");
        readText5.setFont(new Font(null, Font.PLAIN, 15));
        readText5.setBounds(10, 450, 430, 40);
        panel.add(readText5);

        // set ActionListener
        readButton.addActionListener(e -> {
            // clear
            readText1.setText("");
            readText2.setText("");
            readText3.setText("");
            readText4.setText("");
            readText5.setText("");
            // reading process
            fileIO = new FileIO();
            String path = readingFilePath.getText();
            ArrayList<String> list = fileIO.readFile(path);
            readText1.setText(list.get(0));
            readText2.setText(list.get(1));
            readText3.setText(list.get(2));
            readText4.setText(list.get(3));
            readText5.setText(list.get(4));
        });

        // writing part
        JLabel writingFileName = new JLabel("File name to write: ");
        writingFileName.setFont(new Font(null, Font.PLAIN, 25));
        writingFileName.setBounds(520, 50, 320, 40);
        panel.add(writingFileName);

        JTextField writingFilePath = new JTextField(10);
        writingFilePath.setFont(new Font(null, Font.PLAIN, 15));
        writingFilePath.setBounds(470, 120, 350, 40);
        panel.add(writingFilePath);

        // button to write
        JButton writeButton = new JButton("Click to write to file: ");
        writeButton.setFont(new Font(null, Font.PLAIN, 25));
        writeButton.setBounds(500, 200, 300, 40);
        panel.add(writeButton);

        // hint text
        JLabel instruction2 = new JLabel("First five lines of new file: ");
        instruction2.setFont(new Font(null, Font.PLAIN, 25));
        instruction2.setBounds(480, 280, 380, 40);
        panel.add(instruction2);

        // display 5 lines of writing file
        JLabel writeText1 = new JLabel("");
        writeText1.setFont(new Font(null, Font.PLAIN, 15));
        writeText1.setBounds(450, 330, 430, 40);
        panel.add(writeText1);
        JLabel writeText2 = new JLabel("");
        writeText2.setFont(new Font(null, Font.PLAIN, 15));
        writeText2.setBounds(450, 360, 430, 40);
        panel.add(writeText2);
        JLabel writeText3 = new JLabel("");
        writeText3.setFont(new Font(null, Font.PLAIN, 15));
        writeText3.setBounds(450, 390, 430, 40);
        panel.add(writeText3);
        JLabel writeText4 = new JLabel("");
        writeText4.setFont(new Font(null, Font.PLAIN, 15));
        writeText4.setBounds(450, 420, 430, 40);
        panel.add(writeText4);
        JLabel writeText5 = new JLabel("");
        writeText5.setFont(new Font(null, Font.PLAIN, 15));
        writeText5.setBounds(450, 450, 430, 40);
        panel.add(writeText5);


        // set ActionListener
        writeButton.addActionListener(e -> {
            // clear text area
            writeText1.setText("");
            writeText2.setText("");
            writeText3.setText("");
            writeText4.setText("");
            writeText5.setText("");

            // writing process
            fileIO = new FileIO();
            String rpath = readingFilePath.getText();
            String wpath = writingFilePath.getText();
            ArrayList<String> list = fileIO.writeFile(rpath, wpath);
            writeText1.setText(list.get(0));
            writeText2.setText(list.get(1));
            writeText3.setText(list.get(2));
            writeText4.setText(list.get(3));
            writeText5.setText(list.get(4));
        });
    }
}
