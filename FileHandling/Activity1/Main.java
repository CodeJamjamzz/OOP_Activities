package FileHandling.Activity1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Jamiel Kyne Pinca\\Desktop\\School Stuff\\CSIT227 (JAVA PROGRAMMING LANGUAGE)\\PREFINAL\\src\\FileHandling\\newfile.txt") );
            writer.write("Write on new file\n");

            System.out.print("Enter size: ");
            int size = scan.nextInt();
            scan.nextLine();
            String[] names = new String[size];

            for(int i = 0; i < size; i++){
                System.out.print("Enter name: ");
                String name = scan.nextLine();
                names[i] = name;
            }

            for(String name: names){
                writer.write(name + "\n");
            }

            writer.close();
        } catch(IOException e){
            System.out.println("IOExceptoin has occured");
        }

        try{
            BufferedReader filereader = new BufferedReader(new FileReader("C:\\Users\\Jamiel Kyne Pinca\\Desktop\\School Stuff\\CSIT227 (JAVA PROGRAMMING LANGUAGE)\\PREFINAL\\src\\FileHandling\\newfile.txt"));
            String line;
            while( (line = filereader.readLine()) != null){
                System.out.println(line);
            }

            filereader.close();
        } catch(IOException e){

        }

    }
}
