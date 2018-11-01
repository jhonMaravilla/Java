package finalproject_jayson_oppa;

import static finalproject_jayson_oppa.FinalProject_Jayson_Oppa.foods;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import javafx.collections.ObservableList;

/**
 *
 * @author jason
 */
public class Receipt {

public static double total = 0;

    public static void Write(ArrayList<Food> foods) {
        
        try {
            //Identify the file
            File file = new File("Receipt.txt");

            //Check if the file exists
            if (!file.exists()) {
                //If the file doesn't exist, create it.
                file.createNewFile();
            }

            //Open the file to write
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //Write to the file
            bw.write("                      Jay-Son Oppa               ");
            bw.newLine();
            bw.write("                    38 Chopin Cres");
            bw.newLine();
            bw.write("                      Brampton ON");
            bw.newLine();
            bw.write("                          L6Y 2S1");
            bw.newLine();
            bw.write("   *****************************************");
            bw.newLine();

            for (Food s : foods) {
                String a = s.toString();
                total += s.getSubtotal();
                String[] split = a.split("#");
                for (int i = 0; i < split.length; i++) {
                    bw.write(split[i]);
                    bw.newLine();
                }
                bw.newLine();
            }

            bw.newLine();
            bw.newLine();
            DecimalFormat df = new DecimalFormat("0.00");

            if (Sushi.getText() != null) {
                bw.write("'" + "*" + Sushi.getText() + "'");
                bw.newLine();
            }
            bw.write("   *****************************************");
            bw.newLine();
            bw.write("Subtotal\t\t\t\t\t$" + df.format(total));
            bw.newLine();
            bw.write("Taxes(13%)\t\t\t\t$" + (df.format(total * 0.13)));
            bw.newLine();
            bw.write("Total\t\t\t\t\t$" + (df.format(total * 1.13)));
            bw.newLine();
            bw.newLine();
            bw.write("        THANKS FOR YOUR ORDER!");

            //Close
            bw.close();

            addOrderToFile();
        } catch (IOException e) {
            System.out.println(e);
        }
        total = 0;
    }

    public static void makeOrderToFile(makeOrder order) {
        try {
            File file = new File("orders.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(order.toFileString());
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void addOrderToFile() {
        int orderNumber = Integer.parseInt(readFile()) + 1;

        String orderNumber2 = String.valueOf(orderNumber);

        LocalDate today = LocalDate.now();
        String date = today.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")).toString();

        LocalTime timeToday = LocalTime.now();
        String time = timeToday.format(DateTimeFormatter.ofPattern("HH:mm")).toString();
        
        DecimalFormat df = new DecimalFormat("0.00");
        String subTotal2 = df.format(total);
        String tax2 = df.format(total * .13);
        String allTotal2 = df.format(total * 1.13);
        
        
        String subTotal = subTotal2;
        String tax = tax2;
        String allTotal = allTotal2;

        makeOrder orders = new makeOrder(orderNumber2, date, time, subTotal, tax, allTotal);
        makeOrderToFile(orders);
    }

    public static String readFile() {
        ArrayList<String> orders = new ArrayList<>();
        try {
            File file = new File("orders.txt");

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            String s;
            while ((s = br.readLine()) != null) {
                String[] split = s.split(",");
                String orderNumber = split[0];
                orders.add(orderNumber);
            }
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return orders.get(orders.size() - 1);
    }

}
