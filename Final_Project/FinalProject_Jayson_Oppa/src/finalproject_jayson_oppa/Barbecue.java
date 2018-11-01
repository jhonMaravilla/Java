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
public class Barbecue implements Food {
    private double PullChicken = 9.99;
    private double ChickenFriedSteak = 18.99;
    private double ChickenSkewers = 8.99;
    private double ChickenBisket = 7.99;
    private double BeffShortRibs = 9.99;
    private double PotatoFries = 5.99;

    private int PullChickenOrder = 0;
    private int ChickenFriedSteakOrder = 0;
    private int ChickenSkewersOrder = 0;
    private int ChickenBisketOrder = 0;
    private int BeffShortRibsOrder = 0;
    private int PotatoFriesOrder = 0;
    private static String Text;

    public Barbecue() {
    }
    
    public Barbecue(int PullChickenOrder, int ChickenFriedSteakOrder, int ChickenSkewersOrder, int ChickenBisketOrder,
            int BeffShortRibsOrder, int PotatoFriesOrder) {
        this.BeffShortRibsOrder=BeffShortRibsOrder;
        this.ChickenBisketOrder=ChickenBisketOrder;
        this.ChickenFriedSteakOrder=ChickenFriedSteakOrder;
        this.ChickenSkewersOrder=ChickenSkewersOrder;
        this.PotatoFriesOrder=PotatoFriesOrder;
        this.PullChickenOrder=PullChickenOrder;
        
        
    }

    public double getPullChicken() {
        return PullChicken;
    }

    public double getChickenFriedSteak() {
        return ChickenFriedSteak;
    }

    public double getChickenSkewers() {
        return ChickenSkewers;
    }

    public double getChickenBisket() {
        return ChickenBisket;
    }

    public double getBeffShortRibs() {
        return BeffShortRibs;
    }

    public double getPotatoFries() {
        return PotatoFries;
    }

    public static String getText() {
        return Text;
    }
    
    
    
    
    
    public double getSubtotal() {
        double total = PullChicken * PullChickenOrder + ChickenFriedSteak * ChickenFriedSteakOrder
                + ChickenSkewers * ChickenSkewersOrder + ChickenBisket * ChickenBisketOrder
                + BeffShortRibs * BeffShortRibsOrder + PotatoFries * PotatoFriesOrder;
        double Cost = Double.parseDouble(new DecimalFormat("0.00").format(total));
        return Cost;
    }

    @Override
    public String toString() {
        String outPut=""; 
        if (getSubtotal()!=0){
            outPut += "BBQ  " + "\t\t\tTotalPrice: $" + getSubtotal() + "#";
        }
        if (this.PullChickenOrder > 0) {
            outPut += " > Woodfire Steak\t\t\t" +"x"+PullChickenOrder+"#";
        }
        if (this.ChickenFriedSteakOrder > 0) {
            outPut += " > Filet Lobster" +"\t\t\t"+"x"+ChickenFriedSteakOrder+ "#";
        } 
        if (this.ChickenSkewersOrder > 0) {
            outPut += " > Rosted Chiken" +"\t\t\t"+"x"+ChickenSkewersOrder+ "#";
        } 
        if (this.ChickenBisketOrder > 0) {
            outPut += " > Mashroom Burger" +"\t\t"+"x"+ChickenBisketOrder+ "#";
        }
        if (this.BeffShortRibsOrder > 0) {
            outPut += " > BLT Sandwich" +"\t\t\t"+"x"+BeffShortRibsOrder+ "#";
        }
        if (this.PotatoFriesOrder > 0) {
            outPut += " > Bacon Burger" +"\t\t\t"+"x"+PotatoFriesOrder+ "#";
        }
//        if (this.Text!=null){
//            outPut += this.Text;
//        }

        return outPut;
    }

}
