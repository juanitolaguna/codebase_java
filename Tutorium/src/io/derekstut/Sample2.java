package io.derekstut;

import java.io.*;


/**
 * Created on 01.05.17.
 */
public class Sample2 {
    public static void main(String[] args) {
        Customer[] customers = Customer.getCustomers();
        PrintWriter custOutput = createFile("/Users/pawel/Desktop/customerOutput.txt");

        for (Customer person : customers) {
            createCustomers(person, custOutput);
        }
        custOutput.close();

        getFileInfo();
    }

    private static void getFileInfo() {
        System.out.println("Info written to file \n");
        File listOfNames = new File("/Users/pawel/Desktop/customerOutput.txt");

        try {
            BufferedReader getInfo = new BufferedReader(new FileReader(listOfNames));
            String custInfo = getInfo.readLine();
            while (custInfo != null) {
                System.out.println(custInfo);
                custInfo = getInfo.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("couldn't find file");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("IO Err occured");
            System.exit(0);
        }
    }

    private static void createCustomers(Customer customer, PrintWriter customerOutput) {
        String custInfo = customer.firstName + " " + customer.lastName +  " ";
        custInfo += Integer.toString(customer.customerAge);
        customerOutput.println(custInfo);
    }

    private static PrintWriter createFile(String fileName) {
        try {
            File listOfNames = new File(fileName);
            PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(listOfNames)));
        } catch (IOException e) {
            System.out.println("IO Err occured");
            System.exit(0);
        }
        return null;
    }

}
