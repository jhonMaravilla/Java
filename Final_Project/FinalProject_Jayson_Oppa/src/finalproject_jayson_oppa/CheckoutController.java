package finalproject_jayson_oppa;

import static finalproject_jayson_oppa.FinalProject_Jayson_Oppa.foods;
import static finalproject_jayson_oppa.Receipt.addOrderToFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CheckoutController implements Initializable {
public static ObservableList<Food> sales = FXCollections.observableArrayList();
    
    
    @FXML
    public void show1H() {
        sales.clear();
        thanks.setVisible(false);
        FinalProject_Jayson_Oppa.show1H();
    }
    
    @FXML
    private Label thanks;
    
    @FXML
    public void checkout() {
        Receipt.Write(foods);
        foods.clear();
        sales.clear();
        thanks.setVisible(true);
        cashout.setVisible(false);
        receipt.setVisible(true);
    }
    
    @FXML
    private Button receipt;
    
    @FXML
    private Button cashout;
   
    @FXML
    public void writeReceipt(){
        cashout.setVisible(true);
        thanks.setVisible(false);
        receipt.setVisible(false);
        FinalProject_Jayson_Oppa.show8();
    }
    
    @FXML
    private ListView foodListView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        receipt.setVisible(false);     
        FinalProject_Jayson_Oppa.stage5.setOnShown(e ->{
            setList();
            if(sales.size() > 0){
                cashout.setDisable(false);
            }
        });
                
       
    }
    
    @FXML
    public void setList(){      
       for(Food s: foods){
            sales.add(s);
        }
        foodListView.setItems(sales);
    }
    
    @FXML
    public void deleteOrder(){
       if(!foodListView.getSelectionModel().isEmpty()){
           sales.remove(foodListView.getSelectionModel().getSelectedItem());
           foods.clear();
           foods.addAll(sales);
       }
       if(sales.size() == 0){
           cashout.setDisable(true);
       }
       foodListView.getSelectionModel().clearSelection();
    }
  
}
