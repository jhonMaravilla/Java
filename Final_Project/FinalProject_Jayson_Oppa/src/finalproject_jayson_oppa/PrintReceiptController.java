package finalproject_jayson_oppa;

import static finalproject_jayson_oppa.FinalProject_Jayson_Oppa.foods;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class PrintReceiptController implements Initializable {

    @FXML
    private TextArea receipTextArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FinalProject_Jayson_Oppa.stage8.setOnShown(e -> {
            String d = "";
        try {
            File file = new File("Receipt.txt");

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            String s;

            while ((s = br.readLine()) != null) {
                d += s + "\n";
            }

            receipTextArea.setText(d);

            br.close();

        } catch (IOException b) {
            System.out.println(b);
        }
        });
    }
//    @FXML
//    public void toReceipt() {
//        String d = "";
//        try {
//            File file = new File("Receipt.txt");
//
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//
//            FileReader fr = new FileReader(file.getAbsoluteFile());
//            BufferedReader br = new BufferedReader(fr);
//
//            String s;
//
//            while ((s = br.readLine()) != null) {
//                d += s + "\n";
//            }
//
//            receipTextArea.setText(d);
//
//            br.close();
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }
}
