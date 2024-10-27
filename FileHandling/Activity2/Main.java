package FileHandling.Activity2;
import java.util.*;
import java.io.*;

public class Main {
    // Essential Wrapper classes
    // Integer.toString(String str);
    // Double.parseDouble(double num);
    // Stirng.split(","); -> splits the string depending on the (",") each element will be in a different index
    public static void newfile(String filename){
        Scanner scan = new Scanner(System.in);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src//FileHandling//Activity2//Recipe//" +filename))){
            while(true){
                System.out.print("Enter Ingredient Name: ");
                String name = scan.nextLine();

                if(name.equals("Done")){
                    return;
                }

                System.out.print("Enter Scale: ");
                String scale = scan.nextLine();

                writer.write(name + "," + scale + "\n");
            }
        } catch (IOException e){
            System.out.println("There is an error");
        }
    }

    public static void recipereader(String filename, double scale){
        try(BufferedReader reader = new BufferedReader(new FileReader("src//FileHandling//Activity2//Recipe//"+filename))){
            String line;
            while((line = reader.readLine()) != null){
                String[] part = line.split(",");
                System.out.print(part[0]);
                double amount = Double.parseDouble(part[1]) * scale;
                System.out.println("," + amount);
            }

            return;
        } catch (IOException e){
            System.out.println("There is an error");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String option = null;
        do {
            System.out.print("Enter option: ");
            option = scan.nextLine();

            switch(option){
                case "Write":
                    System.out.print("Enter New Recipe: ");
                    String newfile = scan.nextLine();
                    newfile(newfile);
                    break;
                case "Read":
                    System.out.print("Enter Recipe: ");
                    String filename = scan.nextLine();
                    System.out.print("Enter Scale: ");
                    double scale = scan.nextDouble();
                    scan.nextLine();
                    recipereader(filename, scale);
                    break;
                default:
                    if(option.equals("Done")){
                        System.out.println("Exiting...");
                        break;
                    }
                    System.out.println("no such option");
                    break;
            }


        } while(!option.equals("Done"));

    }
}
