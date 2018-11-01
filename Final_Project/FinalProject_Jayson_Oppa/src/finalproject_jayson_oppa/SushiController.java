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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author jason
 */
public class SushiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private int LasVegasOrder = 0;
    private int RedDragonOrder = 0;
    private int CaliforniaRollOrder = 0;
    private int AvocadoYamOrder = 0;
    private int TempuraShrimpOrder = 0;
    private int BBQEelOrder = 0;

    Sushi s = new Sushi();

    @FXML
    public void show2B() {

        FinalProject_Jayson_Oppa.show2B();
    }

    @FXML
    public void show3C() {
        FinalProject_Jayson_Oppa.show3C();
    }

    @FXML
    public void show1H() {
        FinalProject_Jayson_Oppa.show1H();
    }

    @FXML
    private Label total = new Label();

    @FXML
    private TextField LasVegasNumber = new TextField();
    @FXML
    private TextField RedDragonNumber = new TextField();
    @FXML
    private TextField CaliforniaRollNumber = new TextField();
    @FXML
    private TextField AvocadoYamNumber = new TextField();
    @FXML
    private TextField TempuraShrimpNumber = new TextField();
    @FXML
    private TextField BBQEelNumber = new TextField();
    @FXML 
    private TextArea Remarks = new TextArea();
    
    
    @FXML
    private void plus1() {     
        LasVegasNumber.setText("    " + ++LasVegasOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus2() {
        RedDragonNumber.setText("    " + ++RedDragonOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus3() {
        CaliforniaRollNumber.setText("    " + ++CaliforniaRollOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus4() {
        AvocadoYamNumber.setText("    " + ++AvocadoYamOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus5() {
        TempuraShrimpNumber.setText("    " + ++TempuraShrimpOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void plus6() {
        BBQEelNumber.setText("    " + ++BBQEelOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min1() {
        --LasVegasOrder;
        if (LasVegasOrder <= 0) {
            LasVegasOrder = 0;
        }
        LasVegasNumber.setText("    " + LasVegasOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min2() {
        --RedDragonOrder;
        if (RedDragonOrder <= 0) {
            RedDragonOrder = 0;
        }
        RedDragonNumber.setText("    " + RedDragonOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min3() {
        --CaliforniaRollOrder;
        if (CaliforniaRollOrder <= 0) {
            CaliforniaRollOrder = 0;
        }
        CaliforniaRollNumber.setText("    " + CaliforniaRollOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min4() {
        --AvocadoYamOrder;
        if (AvocadoYamOrder <= 0) {
            AvocadoYamOrder = 0;
        }
        AvocadoYamNumber.setText("    " + AvocadoYamOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min5() {
        --TempuraShrimpOrder;
        if (TempuraShrimpOrder <= 0) {
            TempuraShrimpOrder = 0;
        }
        TempuraShrimpNumber.setText("    " + TempuraShrimpOrder);
        total.setText("$ " + Subtotal());
    }

    @FXML
    private void Min6() {
        --BBQEelOrder;
        if (BBQEelOrder <= 0) {
            BBQEelOrder = 0;
        }
        BBQEelNumber.setText("    " + BBQEelOrder);
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
        Sushi p = new Sushi(LasVegasOrder, RedDragonOrder, CaliforniaRollOrder,
                AvocadoYamOrder, TempuraShrimpOrder, BBQEelOrder);
        FinalProject_Jayson_Oppa.foods.add(p);
    }

    private void clear() {
        LasVegasOrder = 0;
        RedDragonOrder = 0;
        CaliforniaRollOrder = 0;
        AvocadoYamOrder = 0;
        TempuraShrimpOrder = 0;
        BBQEelOrder = 0;

        LasVegasNumber.setText("    " + LasVegasOrder);
        RedDragonNumber.setText("    " + RedDragonOrder);
        CaliforniaRollNumber.setText("    " + CaliforniaRollOrder);
        AvocadoYamNumber.setText("    " + AvocadoYamOrder);
        TempuraShrimpNumber.setText("    " + TempuraShrimpOrder);
        BBQEelNumber.setText("    " + BBQEelOrder);
        total.setText("$ " + Subtotal());

    }

    public double Subtotal() {

        double total = s.getAvocadoYam() * AvocadoYamOrder + s.getBBQEel() * BBQEelOrder
                + s.getCaliforniaRoll() * CaliforniaRollOrder + s.getLasVegas() * LasVegasOrder
                + s.getRedDragon() * RedDragonOrder + s.getTempuraShrimp() * TempuraShrimpOrder;
        double Cost = Double.parseDouble(new DecimalFormat("0.00").format(total));
        return Cost;
    }

}
