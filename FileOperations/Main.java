package FileOperations;
import java.io.*;
import java.util.*;

// reading - extracting data from the file
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader("newfile.txt"));) { // resource. automatically closes it when outside the try
            // must be in a try catch since it throws an exception
            // by default find the folder based on the folder
            // one folder outside the folder ../../
            // FileException is under IOException

            // reader = new BufferedReader(new FileReader("newfile.txt"));
            // System.out.println(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null){ // without the parenthesis it will do null and readline first
                System.out.println(line);
            }
            return;
            // reader.close(); // mandatory to close as we will risk the data from the file
        }catch (IOException e) {
            System.out.println("File is not found. Please check again.");
            System.err.println(e.getMessage()); // Shortcut: serr
        } finally { // finally first before the return
//            try{
//                if(reader != null){
//                    reader.close();
//                    System.out.println("Closing successful");
//                }
//            } catch (IOException e){
//                System.out.println("File is not found. Please check again.");
//                System.err.println(e.getMessage());
//            }
        }

        // if the file does not exist it will create the file and not create a new folder
        // append boolean in FileWriter constructor
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("newfile2.txt", true));
             FileWriter writer2 = new FileWriter("secondone.txt")) {
            // writer.write("HELLO \n"); // long time to process if file is far away
                                          // thus will stay in the buffer first
            // many characters if bigger characters

            String str;
            while(!Objects.equals(str = scan.nextLine(), "STOP")){
                    writer.write(str);
                    writer.newLine();
                    writer.flush();
            }

        } catch (IOException e) {

        }


    }
}
