/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject_jayson_oppa;

import static finalproject_jayson_oppa.FinalProject_Jayson_Oppa.foods;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        B.setVisible(false);
        C.setVisible(false);
        D.setVisible(false);
           
        
    }

    @FXML
    public void show2B() {
        FinalProject_Jayson_Oppa.show2B();
    }
    
    @FXML
    private Button checkoutButton;
    
    @FXML
    private Label totalLabel;

    @FXML
    public void totalString(){
        double totalOrder=0;
        for(Food s: foods){
            totalOrder += s.getSubtotal();
        }
        DecimalFormat dc = new DecimalFormat("$0.00");
        String total = dc.format(totalOrder);
        totalLabel.setText(total);
    }
    
    @FXML
    public void show3C() {
        FinalProject_Jayson_Oppa.show3C();
    }

    @FXML
    public void show4S() {
        FinalProject_Jayson_Oppa.show4S();
    }
    @FXML
    private Text B = new Text();
    
    @FXML
    private Text C = new Text();
    @FXML
    private Text D = new Text();

    @FXML
    private ImageView home = new ImageView();
    @FXML
    private ImageView bbq = new ImageView();
    @FXML
    private ImageView chicken = new ImageView();
    @FXML
    private ImageView sushi = new ImageView();
    @FXML
    private Text bbq_Text = new Text();
    @FXML
    private Text chicken_Text = new Text();
    @FXML
    private Text sushi_Text = new Text();
    @FXML
    private Text home_Text = new Text();
    
    @FXML
    private Label total = new Label();
    
    @FXML
    public void adminPageView(){
        FinalProject_Jayson_Oppa.show6();
    }
    
    @FXML
    public void bbq() {
        C.setVisible(false);
        D.setVisible(false);
        B.setVisible(true);
        home.setVisible(false);
        bbq.setVisible(true);
        sushi.setVisible(false);
        chicken.setVisible(false);
        bbq_Text.setStyle("-fx-fill:white;-fx-underline:true;");
        chicken_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        sushi_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        home_Text.setStyle("-fx-fill:black;-fx-underline:false;");
    }

    @FXML
    public void chicken() {
        C.setVisible(true);
        D.setVisible(false);
        B.setVisible(false);
        bbq.setVisible(false);
        chicken.setVisible(true);
        home.setVisible(false);
        sushi.setVisible(false);
        bbq_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        chicken_Text.setStyle("-fx-fill:white;-fx-underline:true;");
        sushi_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        home_Text.setStyle("-fx-fill:black;-fx-underline:false;");

    }

    @FXML
    public void sushi() {
        C.setVisible(false);
        D.setVisible(true);
        B.setVisible(false);
        chicken.setVisible(false);
        home.setVisible(false);
        bbq.setVisible(false);
        sushi.setVisible(true);
        bbq_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        chicken_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        sushi_Text.setStyle("-fx-fill:white;-fx-underline:true;");
        home_Text.setStyle("-fx-fill:black;-fx-underline:false;");

    }

    public void aboutus() {
        C.setVisible(false);
        D.setVisible(false);
        B.setVisible(false);
        chicken.setVisible(false);
        home.setVisible(true);
        bbq.setVisible(false);
        sushi.setVisible(false);
        bbq_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        chicken_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        sushi_Text.setStyle("-fx-fill:black;-fx-underline:false;");
        home_Text.setStyle("-fx-fill:white;-fx-underline:true;");

    }
    
  

//    @FXML
//    public void show5O() {
//        FinalProject_Jayson_Oppa.show5O();
//    }
    @FXML
    public void checkout() { 
        if(foods.size() <= 0){
            
        }
        else {
            FinalProject_Jayson_Oppa.show5O();
        }
        
    }

}
