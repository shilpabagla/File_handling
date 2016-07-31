
package com.shilpa.filehandling.entity;

import com.shilpa.filehandling.operation.Operations;
import java.util.Scanner;


public class Handler {
    private Scanner input;
    Operations o = new Operations();
   

    public Handler(Scanner input) {
        this.input = input;
    }

    

    private void menu() {
        
        System.out.println("Enter your choice[1-7]:");
        System.out.println("1.Write file:");
        System.out.println("2.Read file:");
        System.out.println("3.Buffered Reader:");
        System.out.println("4.Read content from URL:");
        System.out.println("5.Read URL from file, convert into html to access it::");
        System.out.println("6.Extract image:");
        System.out.println("7.Exit:");
        
    }

    public void process() {
        while (true) {
            menu();
            switch (input.nextInt()) {
                case 1:
                    o.fileWrite();
                    break;
                    
                case 2:
                    o.fileRead();
                    break;

                case 3:
                    o.bufferedReader();
                    break;

                case 4:
                    o.readUrlContent();
                    break;

                case 5:
                    o.readUrlFile();
                    break;
                    
                case 6:
                    o.Image();
                    break;

                case 7:
                    System.out.println("Do you really wanna exit?[y/n]");
                    if (input.next().equalsIgnoreCase("y")) {
                        System.exit(0);
                    }
                    break;

            }
            
        }

    }
}
