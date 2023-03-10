package view;

import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;

public class Home {
    private Scene scene;
    private PasswordField newPassword;
    private Button updateBtn, deleteBtn;
    private VBox mainBox;
    private UserController userController;

    public Home(String activeUser){
        userController = new UserController();
        initComponents(activeUser);
    }

    public void initComponents(String activeUser){
        newPassword = new PasswordField();
        newPassword.setPromptText("Nova Senha");

        updateBtn = new Button("Atualizar");
        updateBtn.setOnAction(e->{
            userController.update(activeUser,newPassword.getText());
        });

        deleteBtn = new Button("Deletar Conta");
        deleteBtn.setOnAction(e->{
            System.out.println("deletar");
            userController.delete(activeUser);
        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(newPassword,updateBtn,deleteBtn);

        scene = new Scene(mainBox);
    }

    public Scene getScene(){
        return scene;
    }
}
