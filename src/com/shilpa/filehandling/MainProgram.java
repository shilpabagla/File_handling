
package com.shilpa.filehandling;


import java.util.Scanner;
import com.shilpa.filehandling.entity.Handler;
import com.shilpa.filehandling.operation.Operations;

public class MainProgram {

    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        Handler f=new Handler(input);
       
        
        f.process();
    }
   
        }
        
    

