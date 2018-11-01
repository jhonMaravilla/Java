package finalproject_jayson_oppa;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

public class AdminPageController implements Initializable {

    @FXML
    private TableView<SalesReport> tableView;

    @FXML
    private TableColumn<SalesReport, String> orderNumberColumn;

    @FXML
    private TableColumn<SalesReport, String> dateColumn;

    @FXML
    private TableColumn<SalesReport, String> timeColumn;

    @FXML
    private TableColumn<SalesReport, String> subTotalColumn;

    @FXML
    private Label logout;

    @FXML
    private TextField subTotalTextField;

    @FXML
    private TextField taxTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private TextField orderNumberField;

    @FXML
    public void logout() {
        FinalProject_Jayson_Oppa.show1H();
    }

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label dateValue;

    @FXML
    public void printReport() {
        try {
            for (SalesReport s : tableView.getItems()) {
                String d = s.toString();
                String[] split1 = d.split(",");
                String[] split2 = split1[0].split(":");
                String[] split7 = split1[1].split(":");
                String[] split6 = split1[2].split(":");
                String[] split3 = split1[3].split(":");
                String[] split4 = split1[4].split(":");
                String[] split5 = split1[5].split(":");
                String fileName = split2[1];
                File file = new File("OrderFile/" + fileName + ".txt");

                //Check if the file exists
                if (!file.exists()) {

                    //If the file does not exist, create it.
                    file.createNewFile();
                }
                //Open the file to write
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("                      Jay-Son Oppa               ");
                bw.newLine();
                bw.write("                    38 Chopin Cres");
                bw.newLine();
                bw.write("                      Brampton ON");
                bw.newLine();
                bw.write("                        L6Y 2S1");
                bw.newLine();
                bw.write("__________________________________________________________");
                bw.newLine();
                bw.newLine();
                bw.write("Order Number: " + split2[1]);
                bw.newLine();
                bw.write("Date: " + split7[1]);
                bw.newLine();
                bw.write("Time: " + split6[1] + ":" + split6[2]);
                bw.newLine();
                bw.write("Subtotal: " + split3[1]);
                bw.newLine();
                bw.write("Tax: $" + split4[1]);
                bw.newLine();
                bw.write("Total: $" + split5[1]);
                bw.newLine();
                bw.newLine();
                bw.close();
                
                Desktop.getDesktop().open(file);
            }
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("Order written to file");
//            alert.show();
//            refreshTable();


            //Close
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void getDate() {
        dateValue.setText(datePicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
        tableView.setItems(getSales2());
        orderNumberField.clear();
    }

    @FXML
    public void refreshTable() {
        tableView.setItems(getSales());
        orderNumberField.clear();
        datePicker.setValue(null);
    }

    @FXML
    public void getOrderNumber() {
        tableView.setItems(getSalesByOrderNum());
        datePicker.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderNumberColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("orderNumber"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("time"));
        subTotalColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("subTotal"));

        tableView.setItems(getSales());

    }

    public ObservableList<SalesReport> getSales() {
        ObservableList<SalesReport> sales = FXCollections.observableArrayList();
        ArrayList<Double> subTotalList = new ArrayList<Double>();
        ArrayList<Double> taxList = new ArrayList<Double>();
        ArrayList<Double> totalList = new ArrayList<Double>();

        try {
            //Identifying the file
            File file = new File("orders.txt");

            //Check if the file exists
            if (!file.exists()) {

                //If the file does not exist, then stop.
                throw new FileNotFoundException();
            }

            //Open the file to read
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            //Read from the file
            String s;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(",");
                String orderNumber = parts[0];
                String date = parts[1];
                String time = parts[2];
                String subTotal = "$" + parts[3];
                String tax = "$" + parts[4];
                String total = "$" + parts[5];

                SalesReport orderReport = new SalesReport(orderNumber, date, time, subTotal, tax, total);
                sales.add(orderReport);
                subTotalList.add(Double.parseDouble(parts[3]));
                taxList.add(Double.parseDouble(parts[4]));
                totalList.add(Double.parseDouble(parts[5]));
            }
            //Close
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        Double subTotalDouble = 0.0;
        for (Double s : subTotalList) {
            subTotalDouble += s;
        }

        Double taxDouble = 0.0;
        for (Double s : taxList) {
            taxDouble += s;
        }

        Double totalDouble = 0.0;
        for (Double s : totalList) {
            totalDouble += s;
        }

        DecimalFormat dc = new DecimalFormat("$#.00");
        String subTotalString = dc.format(subTotalDouble);
        String taxString = dc.format(taxDouble);
        String totalString = dc.format(totalDouble);

        subTotalTextField.setText(subTotalString);
        taxTextField.setText(taxString);
        totalTextField.setText(totalString);
        return sales;
    }

    public ObservableList<SalesReport> getSales2() {
        ObservableList<SalesReport> sales = FXCollections.observableArrayList();
        ArrayList<Double> subTotalList = new ArrayList<Double>();
        ArrayList<Double> taxList = new ArrayList<Double>();
        ArrayList<Double> totalList = new ArrayList<Double>();
        try {
            //Identifying the file
            File file = new File("orders.txt");

            //Check if the file exists
            if (!file.exists()) {

                //If the file does not exist, then stop.
                throw new FileNotFoundException();
            }

            //Open the file to read
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            //Read from the file
            String s;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(",");
                String orderNumber = parts[0];
                String date = parts[1];
                String time = parts[2];
                String subTotal = "$" + parts[3];
                String tax = parts[4];
                String total = parts[5];

                if (date.equals(dateValue.getText())) {
                    SalesReport orderReport = new SalesReport(orderNumber, date, time, subTotal, tax, total);
                    sales.add(orderReport);
                    subTotalList.add(Double.parseDouble(parts[3]));
                    taxList.add(Double.parseDouble(parts[4]));
                    totalList.add(Double.parseDouble(parts[5]));
                }

            }

            if (sales.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("No match found! Please try again");
                alert.show();
                sales = getSales();
                subTotalList = getSubTotal();
                taxList = getTax();
                totalList = getTotal();
            }

            //Close
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        Double subTotalDouble = 0.0;
        for (Double s : subTotalList) {
            subTotalDouble += s;
        }

        Double taxDouble = 0.0;
        for (Double s : taxList) {
            taxDouble += s;
        }

        Double totalDouble = 0.0;
        for (Double s : totalList) {
            totalDouble += s;
        }

        DecimalFormat dc = new DecimalFormat("$#.00");
        String subTotalString = dc.format(subTotalDouble);
        String taxString = dc.format(taxDouble);
        String totalString = dc.format(totalDouble);

        subTotalTextField.setText(subTotalString);
        taxTextField.setText(taxString);
        totalTextField.setText(totalString);
        return sales;
    }

    public ObservableList<SalesReport> getSalesByOrderNum() {
        ObservableList<SalesReport> sales = FXCollections.observableArrayList();
        ArrayList<Double> subTotalList = new ArrayList<Double>();
        ArrayList<Double> taxList = new ArrayList<Double>();
        ArrayList<Double> totalList = new ArrayList<Double>();
        try {
            //Identifying the file
            File file = new File("orders.txt");

            //Check if the file exists
            if (!file.exists()) {

                //If the file does not exist, then stop.
                throw new FileNotFoundException();
            }

            //Open the file to read
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            //Read from the file
            String s;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(",");
                String orderNumber = parts[0];
                String date = parts[1];
                String time = parts[2];
                String subTotal = "$" + parts[3];
                String tax = parts[4];
                String total = parts[5];

                if (orderNumber.equals(orderNumberField.getText())) {
                    SalesReport orderReport = new SalesReport(orderNumber, date, time, subTotal, tax, total);
                    sales.add(orderReport);
                    subTotalList.add(Double.parseDouble(parts[3]));
                    taxList.add(Double.parseDouble(parts[4]));
                    totalList.add(Double.parseDouble(parts[5]));
                }

            }

            if (sales.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("No match found! Please try again");
                alert.show();
                sales = getSales();
                subTotalList = getSubTotal();
                taxList = getTax();
                totalList = getTotal();
            }

            //Close
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        Double subTotalDouble = 0.0;
        for (Double s : subTotalList) {
            subTotalDouble += s;
        }

        Double taxDouble = 0.0;
        for (Double s : taxList) {
            taxDouble += s;
        }

        Double totalDouble = 0.0;
        for (Double s : totalList) {
            totalDouble += s;
        }

        DecimalFormat dc = new DecimalFormat("$#.00");
        String subTotalString = dc.format(subTotalDouble);
        String taxString = dc.format(taxDouble);
        String totalString = dc.format(totalDouble);

        subTotalTextField.setText(subTotalString);
        taxTextField.setText(taxString);
        totalTextField.setText(totalString);
        return sales;
    }

    public ArrayList<Double> getSubTotal() {
        ArrayList<Double> subTotalList = new ArrayList<Double>();
        try {
            //Identifying the file
            File file = new File("orders.txt");

            //Check if the file exists
            if (!file.exists()) {

                //If the file does not exist, then stop.
                throw new FileNotFoundException();
            }

            //Open the file to read
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            //Read from the file
            String s;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(",");
                String subTotal = "$" + parts[3];

                subTotalList.add(Double.parseDouble(parts[3]));
            }
            //Close
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return subTotalList;
    }

    public ArrayList<Double> getTax() {
        ArrayList<Double> taxList = new ArrayList<Double>();
        try {
            //Identifying the file
            File file = new File("orders.txt");

            //Check if the file exists
            if (!file.exists()) {

                //If the file does not exist, then stop.
                throw new FileNotFoundException();
            }

            //Open the file to read
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            //Read from the file
            String s;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(",");
                String tax = parts[4];

                taxList.add(Double.parseDouble(parts[4]));
            }
            //Close
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return taxList;
    }

    public ArrayList<Double> getTotal() {
        ArrayList<Double> totalList = new ArrayList<Double>();
        try {
            //Identifying the file
            File file = new File("orders.txt");

            //Check if the file exists
            if (!file.exists()) {

                //If the file does not exist, then stop.
                throw new FileNotFoundException();
            }

            //Open the file to read
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            //Read from the file
            String s;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(",");
                String total = parts[5];

                totalList.add(Double.parseDouble(parts[5]));
            }
            //Close
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        return totalList;
    }

}
