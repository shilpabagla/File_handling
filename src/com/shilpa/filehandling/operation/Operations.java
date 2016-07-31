
package com.shilpa.filehandling.operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Operations {
    Scanner input = new Scanner(System.in);

    public void fileWrite() {
        try {
            FileWriter writer = new FileWriter("c:/users/Shilpa/desktop/site.txt");
            writer.write("Writing in a file");
            writer.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public void fileRead() {
        try {
            String fileName;
            fileName = "c:/users/Shilpa/desktop/Assign_6/site.txt";
            FileReader reader = new FileReader(fileName);
            int i = 0;
            while ((i = reader.read()) != -1) {
                System.out.print((char) i);
            }
            reader.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void bufferedReader() {
        try {
            String fileName = "c:/users/Shilpa/desktop/Assign_6/site.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = " ";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void readUrlContent() {
        try {
            URL url = new URL("https://lilbitofanything.wordpress.com/");
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = " ";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void readUrlFile() {

        try {
            String fileName = " ";
            while (true) {
                System.out.println("Enter filename:");
                fileName = input.next();
                if (new File(fileName).exists()) {
                    break;
                }
            }

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String link = "";
            int i = 1;
            while ((link = reader.readLine()) != null) {

                URL url = new URL(link);
                URLConnection conn = url.openConnection();
                System.out.println("URL Reading:" + link);
                System.out.println("=================================================");
                BufferedReader urlReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                StringBuilder content = new StringBuilder();
                while ((line = urlReader.readLine()) != null) {
                    content.append(line);
                }
                urlReader.close();

                FileWriter writer = new FileWriter("c://users/Shilpa/desktop/Assign_6/site" + i + ".html");

                writer.write(content.toString());
                writer.close();

                i++;
            }
            reader.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }

    public void Image() {
        try {
            String link = "http://photobucket.com/images/harry%20potter";
            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            InputStream is = conn.getInputStream();
            String[] tokens = link.split("/");
            String path = "C:\\Users\\Shilpa\\Desktop\\Assign_6";
            FileOutputStream os = new FileOutputStream(path + tokens[tokens.length - 1]);

            byte[] data = new byte[1024];
            int i = 0;
            while ((i = is.read(data)) != -1) {
                os.write(data, 0, i);
            }
            os.close();
            is.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
