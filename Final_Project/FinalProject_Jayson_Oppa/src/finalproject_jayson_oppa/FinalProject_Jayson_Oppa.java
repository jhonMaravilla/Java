package finalproject_jayson_oppa;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author jason
 */
public class FinalProject_Jayson_Oppa extends Application {

    static Stage stage1 = new Stage();
    static Stage stage2 = new Stage();
    static Stage stage3 = new Stage();
    static Stage stage4 = new Stage();
    static Stage stage5 = new Stage();
    static Stage stage6 = new Stage();
    static Stage stage7 = new Stage();
    static Stage stage8 = new Stage();
    

    static HomeController c1;
    static BarbecueController c2;
    static ChickenController c3;
    static SushiController c4;
    static CheckoutController c5;
    static IndexController c6;
    static AdminPageController c7;
    static PrintReceiptController c8;
    
    
    public static ArrayList<Food> foods = new ArrayList<Food>();


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader r1 = new FXMLLoader(getClass().getResource("Home.fxml"));
        FXMLLoader r2 = new FXMLLoader(getClass().getResource("Barbecue.fxml"));
        FXMLLoader r3 = new FXMLLoader(getClass().getResource("Chicken.fxml"));
        FXMLLoader r4 = new FXMLLoader(getClass().getResource("Sushi.fxml"));
        FXMLLoader r5 = new FXMLLoader(getClass().getResource("Checkout2.fxml"));
        FXMLLoader r6 = new FXMLLoader(getClass().getResource("index.fxml"));
        FXMLLoader r7 = new FXMLLoader(getClass().getResource("adminPage1.fxml"));
        FXMLLoader r8 = new FXMLLoader(getClass().getResource("PrintReceipt.fxml"));

        Parent root1 = r1.load();
        Parent root2 = r2.load();
        Parent root3 = r3.load();
        Parent root4 = r4.load();
        Parent root5 = r5.load();
        Parent root6 = r6.load();
        Parent root7 = r7.load();
        Parent root8 = r8.load();

        c1 = r1.getController();
        c2 = r2.getController();
        c3 = r3.getController();
        c4 = r4.getController();
        c5 = r5.getController();
        c6 = r6.getController();
        c7 = r7.getController();
        c8 = r8.getController();

        Scene scene1 = new Scene(root1);
        Scene scene2 = new Scene(root2);
        Scene scene3 = new Scene(root3);
        Scene scene4 = new Scene(root4);
        Scene scene5 = new Scene(root5);
        Scene scene6 = new Scene(root6);
        Scene scene7 = new Scene(root7);
        Scene scene8 = new Scene(root8);

        stage1.setTitle("Home");
        stage2.setTitle("Barbecue");
        stage3.setTitle("Chicken");
        stage4.setTitle("Sushi");
        stage5.setTitle("Checkout");
        stage6.setTitle("Admin Login");
        stage7.setTitle("Sales Report");
        stage8.setTitle("Receipt");

        stage1.getIcons().add(new Image("images/logo.png"));
        stage2.getIcons().add(new Image("images/logo.png"));
        stage3.getIcons().add(new Image("images/logo.png"));
        stage4.getIcons().add(new Image("images/logo.png"));
        stage5.getIcons().add(new Image("images/logo.png"));
        stage6.getIcons().add(new Image("images/logo.png"));
        stage7.getIcons().add(new Image("images/logo.png"));
        stage8.getIcons().add(new Image("images/logo.png"));

        stage1.setScene(scene1);
        stage2.setScene(scene2);
        stage3.setScene(scene3);
        stage4.setScene(scene4);
        stage5.setScene(scene5);
        stage6.setScene(scene6);
        stage7.setScene(scene7);
        stage8.setScene(scene8);
        
        stage1.show();

    }

    public static void show1H() {
        stage1.show();
        stage2.hide();
        stage3.hide();
        stage4.hide();
        stage5.hide();
        stage6.hide();
        stage7.hide();
        stage8.hide();
    }

    public static void show2B() {
        stage1.hide();
        stage2.show();
        stage3.hide();
        stage4.hide();
        stage5.hide();
        stage6.hide();
        stage7.hide();
        stage8.hide();
    }

    public static void show3C() {
        stage1.hide();
        stage2.hide();
        stage3.show();
        stage4.hide();
        stage5.hide();
        stage6.hide();
        stage7.hide();
        stage8.hide();
    }

    public static void show4S() {
        stage1.hide();
        stage2.hide();
        stage3.hide();
        stage4.show();
        stage5.hide();
        stage6.hide();
        stage7.hide();
        stage8.hide();
    }

    public static void show5O() {
        stage1.hide();
        stage2.hide();
        stage3.hide();
        stage4.hide();
        stage5.show();
        stage6.hide();
        stage7.hide();
        stage8.hide();
    }

    public static void show6() {
        stage1.hide();
        stage2.hide();
        stage3.hide();
        stage4.hide();
        stage5.hide();
        stage6.show();
        stage7.hide();
        stage8.hide();
    }

    public static void show7() {
        stage1.hide();
        stage2.hide();
        stage3.hide();
        stage4.hide();
        stage5.hide();
        stage6.hide();
        stage7.show();
        stage8.hide();
    }
    
    public static void show8() {
        stage1.show();
        stage2.hide();
        stage3.hide();
        stage4.hide();
        stage5.hide();
        stage6.hide();
        stage7.hide();
        stage8.show();
    }
    

    public static void main(String[] args) {
        launch(args);
    }

}
