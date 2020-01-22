package icp;


import java.io.*;
import java.util.Scanner;

/**
 * @author Kofi Asafo-Boakye
 */
public class Input {

    public Input(){

    }

    /**
     * Main method that uses the scanner class for input
     * Stores the input in variables
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of different items to add: ");
        int number = input.nextInt();

        for (int i = 0; i< number; i++) {

            System.out.print("Enter item name: ");
            String item = input.next();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            System.out.print("Enter price: ");
            double price = input.nextDouble();

/**
 * Writing Text/String to File using PrintWriter and FileOutputStream
 * Checks for "FileNotFoundException" in the connection to the file
 */
            PrintWriter printWriter = null;

            try {
                //Note that we are able to append to the file because of the "true" parameter
                printWriter = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));
            }catch(FileNotFoundException fnfe) {
                fnfe.getMessage();
            }




            printWriter.printf(item + " "+quantity +" " + "GHC" + price);
            printWriter.println();

            //Close Writer
            printWriter.close();


            System.out.print(item + " "+quantity +" " +price + "\n");
        }

        System.out.print("\nDONE\n");


        input.close();


        PrintWriter printWriter2 = null;


        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("essentials_stock.txt"))){
            String line = bufferedReader.readLine();
            while(line != null){
                try {
                    //Note that we are able to append to the file because of the "true" parameter
                    printWriter2 = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));
                }catch(FileNotFoundException fnfe) {
                    fnfe.getMessage();
                }
                System.out.println(line);
                printWriter2.printf(line);
                printWriter2.printf("\n");
                line = bufferedReader.readLine();
                printWriter2.close();
            }
        } catch (IOException e){

        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("essentials_stock.txt"))){
            String line = bufferedReader.readLine();
            while(line != null){

                System.out.println(line);


                line = bufferedReader.readLine();
                printWriter2.close();
            }
        } catch (IOException e){

        }

    }




}
