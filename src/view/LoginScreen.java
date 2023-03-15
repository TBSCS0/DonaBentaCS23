package view;

import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LoginScreen {
    private Label title;
    private TextField userField;
    private PasswordField pswField;
    private Button signBtn, signupBtn;
    private VBox box;
    private UserController userController;

    private Scene scene;

    private Home home;

    public LoginScreen(Stage primaryStage){
        userController = new UserController();
        initComponents(primaryStage);
    }

    public void initComponents(Stage primaryStage){
        title = new Label();
        title.setText("Dona Benta");

        userField = new TextField();
        userField.setPromptText("Usuário");

        pswField = new PasswordField();
        pswField.setPromptText("Senha");

        signBtn = new Button("Entrar");
        signBtn.setOnAction(e->{
            if(userController.read(userField.getText(),pswField.getText())){
                System.out.println("Welcome!");
                home = new Home(userField.getText(), primaryStage);
                primaryStage.setScene(home.getScene());
            }
        });

        signupBtn = new Button("Inscrever-se");
        signupBtn.setOnAction(e->{
            userController.create(userField.getText(), pswField.getText());
        });

        box = new VBox();
        box.getChildren().addAll(title, userField, pswField, signBtn, signupBtn);
        box.setId("mainbox");

        scene = new Scene(box);
        scene.getStylesheets().add("./style/style.css");
    }

    public Scene getScene(){
        return scene;
    }
}
