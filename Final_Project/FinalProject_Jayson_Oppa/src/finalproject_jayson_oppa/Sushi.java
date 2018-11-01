/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject_jayson_oppa;

import java.text.DecimalFormat;

/**
 *
 * @author jason
 */
public class Sushi implements Food {

    static String getSubTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int LasVegasOrder;
    private int RedDragonorder;
    private int CaliforniaRollOrdder;
    private int AvocadoYamOrder;
    private int TempuraShrimpOrder;
    private int BBQEelOrder;

    private double LasVegas = 5.99;
    private double RedDragon = 6.99;
    private double CaliforniaRoll = 4.99;
    private double AvocadoYam = 5.29;
    private double TempuraShrimp = 5.99;
    private double BBQEel = 5.99;
    private static String Text;

    public Sushi() {
        
    }

    public Sushi(String s) {
        this.Text=s;
    }
    
    public static String getText(){
        return Text;
    }

    public Sushi(int LasVegasOrder, int RedDragonorder, int CaliforniaRollOrdder, int AvocadoYamOrder,
            int TempuraShrimpOrder, int BBQEelOrder) {
        this.LasVegasOrder = LasVegasOrder;
        this.RedDragonorder = RedDragonorder;
        this.CaliforniaRollOrdder = CaliforniaRollOrdder;
        this.AvocadoYamOrder = AvocadoYamOrder;
        this.TempuraShrimpOrder = TempuraShrimpOrder;
        this.BBQEelOrder = BBQEelOrder;
    }

    public double getLasVegas() {
        return LasVegas;
    }

    public double getRedDragon() {
        return RedDragon;
    }

    public double getCaliforniaRoll() {
        return CaliforniaRoll;
    }

    public double getAvocadoYam() {
        return AvocadoYam;
    }

    public double getTempuraShrimp() {
        return TempuraShrimp;
    }

    public double getBBQEel() {
        return BBQEel;
    }
    
   
    
    
    @Override
    public double getSubtotal() {
        double total = LasVegas * LasVegasOrder + RedDragon * RedDragonorder
                + CaliforniaRoll * CaliforniaRollOrdder + AvocadoYam * AvocadoYamOrder
                + TempuraShrimp * TempuraShrimpOrder + BBQEel * BBQEelOrder;
        double Cost = Double.parseDouble(new DecimalFormat("0.00").format(total));
        return Cost;
    }
    
    @Override
    public String toString() {
        String outPut=""; 
        if (getSubtotal()!=0){
            outPut += "Sushi" + "\t\t\tTotalPrice: $" + getSubtotal() + "#";
        }
        if (this.LasVegasOrder > 0) {
            outPut += " > Las Vegas Roll (5pc)" +"\t\t"+"x"+LasVegasOrder+"#";
        }
        if (this.RedDragonorder > 0) {
            outPut += " > Red Dragon Roll (8pc)" +"\t\t"+"x"+RedDragonorder+ "#";
        }
        if (this.CaliforniaRollOrdder > 0) {
            outPut += " > California Roll" +"\t\t\t"+"x"+CaliforniaRollOrdder+ "#";
        }
        if (this.AvocadoYamOrder > 0) {
            outPut += " > Avocado Yam Roll" +"\t\t"+"x"+AvocadoYamOrder+ "#";
        }
        if (this.TempuraShrimpOrder > 0) {
            outPut += " > Tempura Shrimp Roll" +"\t\t"+"x"+TempuraShrimpOrder+ "#";
        }
        if (this.BBQEelOrder > 0) {
            outPut += " > B.B.Q Eel Roll" +"\t\t\t"+"x"+BBQEelOrder+ "#";
        }
//        if (this.Text!=null){
//            outPut += this.Text;
//        }

        return outPut;
    }
    
}
