/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnetwork.neuralnetworkmaven.Help;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author alintulu
 */
public class WriteFile {
    
    private String path;
    
    public WriteFile(String path) {
        this.path = path;
    }
    
    public void writeToFile(String textLine) throws IOException {
        
        System.out.println("write data");
        
        FileWriter write = new FileWriter(path, true);
        PrintWriter print_line = new PrintWriter(write);
        
        print_line.printf("%s" + "\n", textLine);
        print_line.close();
        
    }
    
    
}
