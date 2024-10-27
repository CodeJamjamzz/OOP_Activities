package FileHandling.Activity3;
import java.util.*;
import java.io.*;

// Filenamevariable.delete() delete after close
// Filenamevariable.renameTo() rename file after close
// Stringline.startsWith("String");
// Filenamevariable.exists();

class Book{
    private String name;
    private String borrower;

    public String getname(){
        return name;
    }

    public String getborrower(){
        return borrower;
    }

    public Book(String name, String borrower){
        this.name = name;
        this.borrower = borrower;
    }

    public String toString(){
        return "Book Title: " + name + ", Borrower: " + borrower;
    }

}

public class Main{

    public static void addBook(Book book){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src//FileHandling//Activity3//Books//book_lending.txt" , true))){
            writer.write(book.toString());
            writer.newLine();
            return;
        } catch (IOException e){
            System.out.print("There is an error");
        }
    }

    private static void returnBook(String title) {
        File currentFile = new File("src//FileHandling//Activity3//Books//book_lending.txt");
        File tempFile = new File("src//FileHandling//Activity3//Books//temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(currentFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Book Title: " + title + ",")) {
                    found = true;
                    continue;
                }

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Book returned successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        currentFile.delete();
        tempFile.renameTo(currentFile);

    }

    public static void displayBook(){

        File file = new File("src//FileHandling//Activity3//Books//book_lending.txt");
        if(!file.exists()){
            System.out.println("No records to display");
            return;
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("src//FileHandling//Activity3//Books//book_lending.txt"))){

            String line;
            System.out.println("Book Lending Records:");
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }

            System.out.println();
            return;
        } catch (IOException e){
            System.out.print("There is an error");
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        char option;

        do{
            System.out.println("\nBook Lending System");
            System.out.println("1. Add Book\n" + "2. Return Book\n" + "3. Display Books\n" + "4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            option = scan.nextLine().charAt(0);

            switch(option){
                case '1':
                    System.out.print("Enter the title of the book: ");
                    String Bookname = scan.nextLine();
                    System.out.print("Enter the name of the borrower: ");
                    String Borrowername = scan.nextLine();

                    Book book = new Book(Bookname, Borrowername);
                    addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case '2':
                    System.out.print("Enter the title of the book to return: ");
                    String bookname = scan.nextLine();

                    returnBook(bookname);
                    break;
                case '3':
                    displayBook();
                    break;
                case '4':
                    System.out.println("Exiting the system.");
                    break;
            }

        } while(!(Objects.equals(option, '4')));

    }
}


// private static void returnBook(String title) {
//     File inputFile = new File("book_lending.txt");
//     File tempFile = new File("temp.txt");

//     try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//          BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

//         String line;
//         boolean found = false;
//         while ((line = reader.readLine()) != null) {
//             if (line.startsWith("Book Title: " + title + ",")) {
//                 found = true;
//                 continue;
//             }
//             writer.write(line);
//             writer.newLine();
//         }

//         if (found) {
//             System.out.println("Book returned successfully!");
//         } else {
//             System.out.println("Book not found in the system.");
//         }

//     } catch (IOException e) {
//         e.printStackTrace();
//     }

//     inputFile.delete();
//     tempFile.renameTo(inputFile);
// }

// private static void displayBooks() {
//     File file = new File("book_lending.txt");

//     if (!file.exists()) {
//         System.out.println("No records to display");
//         return;
//     }

//     try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//         String line;
//         boolean hasRecords = false;
//         while ((line = br.readLine()) != null) {
//             System.out.println(line);
//             hasRecords = true;
//         }

//         if (!hasRecords) {
//             System.out.println("No records to display");
//         }
//     } catch (IOException e) {
//         e.printStackTrace();
//     }
// }