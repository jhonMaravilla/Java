package finalproject_jayson_oppa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.plugin2.os.windows.Windows;

public class IndexController implements Initializable {

    @FXML
    private Label loginStatus;

    @FXML
    private TextField username;

    @FXML
    PasswordField password;

    public void login() {
        try {
           
            //Identifying the file
            File file = new File("login.txt");

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
                String username2 = parts[0];
                String password2 = parts[1];

                if (username.getText().equals(username2)) {
                    if (password.getText().equals(password2)) {
                        FinalProject_Jayson_Oppa.show7();
                    } else {
                        loginStatus.setText("Account not found!");
                    }
                } else {
                    loginStatus.setText("Account not found!");
                }
            }
            //Close
            br.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FinalProject_Jayson_Oppa.stage6.setOnCloseRequest(e -> {
            FinalProject_Jayson_Oppa.stage1.show();
        });
        
        FinalProject_Jayson_Oppa.stage6.setOnShown(e ->{
            loginStatus.setText("");
            username.clear();
            password.clear();
            username.focusedProperty();
        });
    }

}
