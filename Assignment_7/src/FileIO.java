import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class FileIO {

    // return an ArrayList which stores the first five lines of the file
    public ArrayList<String> readFile(String path) {
        ArrayList<String> list = new ArrayList<>(5);
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            int count = 0;
            // only reading the first five lines
            while (myReader.hasNextLine() && count < 5) {
                String data = myReader.nextLine();
                list.add(data);
                System.out.println(data+"\n");
                count++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

    // return an ArrayList which stores the first five lines of the file
    public ArrayList<String> writeFile(String readingPath, String writingPath) {
        ArrayList<String> list = new ArrayList<>(5);
        try {
            File myObj = new File(readingPath);
            Scanner myReader = new Scanner(myObj);
            FileWriter fw = new FileWriter(writingPath);
            BufferedWriter myWriter = new BufferedWriter(fw);
            // receive contents from split
            String[] dataArray;
            int count = 0;
            while (myReader.hasNextLine()) {
                // reading
                String data = myReader.nextLine();
                // only need the first three fields
                dataArray = data.split(",");
                StringBuilder line = new StringBuilder();
                for(int i = 0; i < 2; i++) {
                    line.append(dataArray[i]);
                    line.append(",");
                }
                line.append(dataArray[2]);

                myWriter.write(line.toString());
                myWriter.newLine();
                // only display first 5 lines
                if(count < 5){
                    list.add(line.toString());
                    System.out.println(line);
                    count++;
                }
            }
            myReader.close();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;

    }
}
