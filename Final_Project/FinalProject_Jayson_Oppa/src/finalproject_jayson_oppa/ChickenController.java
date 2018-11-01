/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject_jayson_oppa;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jason
 */
public class ChickenController implements Initializable {
@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void show2B() {

        FinalProject_Jayson_Oppa.show2B();
    }

    @FXML
    public void show1H() {

        FinalProject_Jayson_Oppa.show1H();
    }

    @FXML
    public void show4S() {

        FinalProject_Jayson_Oppa.show4S();
    }
    
    private int PullChickenOrder = 0;
    private int ChickenFriedSteakOrder = 0;
    private int ChickenSkewersOrder = 0;
    private int ChickenBisketOrder = 0;
    private int BeffShortRibsOrder = 0;
    private int PotatoFriesOrder = 0;
    Chicken c = new Chicken();
    
    @FXML
    private Label total = new Label();

    @FXML
    private TextField PullChickenNumber = new TextField();
    @FXML
    private TextField ChickenFriedSteakNumber = new TextField();
    @FXML
    private TextField ChickenSkewersNumber = new TextField();
    @FXML
    private TextField ChickenBisketNumber = new TextField();
    @FXML
    private TextField BeffShortRibsNumber = new TextField();
    @FXML
    private TextField PotatoFriesNumber = new TextField();
    @FXML 
    private TextArea Remarks = new TextArea();

    @FXML
    private void plus1() {     
        PullChickenNumber.setText("    " + ++PullChickenOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus2() {
        ChickenFriedSteakNumber.setText("    " + ++ChickenFriedSteakOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus3() {
        ChickenSkewersNumber.setText("    " + ++ChickenSkewersOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus4() {
        ChickenBisketNumber.setText("    " + ++ChickenBisketOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus5() {
        BeffShortRibsNumber.setText("    " + ++BeffShortRibsOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus6() {
        PotatoFriesNumber.setText("    " + ++PotatoFriesOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min1() {
        --PullChickenOrder;
        if (PullChickenOrder <= 0) {
            PullChickenOrder = 0;
        }
        PullChickenNumber.setText("    " + PullChickenOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min2() {
        --ChickenFriedSteakOrder;
        if (ChickenFriedSteakOrder <= 0) {
            ChickenFriedSteakOrder = 0;
        }
        ChickenFriedSteakNumber.setText("    " + ChickenFriedSteakOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min3() {
        --ChickenSkewersOrder;
        if (ChickenSkewersOrder <= 0) {
            ChickenSkewersOrder = 0;
        }
        ChickenSkewersNumber.setText("    " + ChickenSkewersOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min4() {
        --ChickenBisketOrder;
        if (ChickenBisketOrder <= 0) {
            ChickenBisketOrder = 0;
        }
        ChickenBisketNumber.setText("    " + ChickenBisketOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min5() {
        --BeffShortRibsOrder;
        if (BeffShortRibsOrder <= 0) {
            BeffShortRibsOrder = 0;
        }
        BeffShortRibsNumber.setText("    " + BeffShortRibsOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min6() {
        --PotatoFriesOrder;
        if (PotatoFriesOrder <= 0) {
            PotatoFriesOrder = 0;
        }
        PotatoFriesNumber.setText("    " + PotatoFriesOrder);
        total.setText("$ " + Subtotal());
    }
    
    @FXML
    private void sumbit(){
        String textArea=Remarks.getText();
        Sushi s = new Sushi(textArea);
        FinalProject_Jayson_Oppa.foods.add(s);
        Remarks.setText("");
    }

    @FXML
    private void AddButton() {
        add();
        clear();
    }

    private void add() {
        Chicken p = new Chicken(PullChickenOrder, ChickenFriedSteakOrder, ChickenSkewersOrder,
                ChickenBisketOrder, BeffShortRibsOrder, PotatoFriesOrder);
        FinalProject_Jayson_Oppa.foods.add(p);
      
    }

    private void clear() {
  PullChickenOrder = 0;
    ChickenFriedSteakOrder = 0;
 ChickenSkewersOrder = 0;
 ChickenBisketOrder = 0;
    BeffShortRibsOrder = 0;
     PotatoFriesOrder = 0;

        PullChickenNumber.setText("    " + PullChickenOrder);
        ChickenFriedSteakNumber.setText("    " + ChickenFriedSteakOrder);
        ChickenSkewersNumber.setText("    " + ChickenSkewersOrder);
        ChickenBisketNumber.setText("    " + ChickenBisketOrder);
        BeffShortRibsNumber.setText("    " + BeffShortRibsOrder);
        PotatoFriesNumber.setText("    " + PotatoFriesOrder);
        total.setText("$ " + Subtotal());

    }

    public double Subtotal() {

        double total = c.getPullChicken() * PullChickenOrder + c.getChickenFriedSteak() * ChickenFriedSteakOrder
                + c.getChickenSkewers() * ChickenSkewersOrder + c.getChickenBisket() * ChickenBisketOrder
                + c.getBeffShortRibs() * BeffShortRibsOrder + c.getPotatoFries() * PotatoFriesOrder;
        double Cost = Double.parseDouble(new DecimalFormat("0.00").format(total));
        return Cost;
    }

}
