/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Help;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alintulu
 */
public class WriteFile {

    private static String path;

    public WriteFile(String path) {
        this.path = path;
    }

    public void writeToFile(String textLine) throws IOException {

        //System.out.println("write data");
        FileWriter write = new FileWriter(path, true);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("%s" + "\n", textLine);
        print_line.close();

    }

    public List<Double> readFromFile() {

        List<Double> values = new ArrayList<>();

        try {
            
            Scanner sc = new Scanner(new File(path));

            while (sc.hasNextLine()) {
                //split your line by spaces into an array of Strings
                String[] splitted = sc.nextLine().split(" ");

                for (int i = 0; i < splitted.length; i++) {
                    values.add(Double.valueOf(splitted[i]));
                }

            }

        } catch (Exception e) {
            System.out.println("Problem with parsing the file " +  path);
        }
        
        return values;
    }
}
