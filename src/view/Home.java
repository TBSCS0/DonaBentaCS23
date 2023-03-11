package view;

import controller.ProductController;
import controller.UserController;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Home {
    private Scene scene;
    private PasswordField newPassword;
    private Button updateBtn, deleteBtn, createProductBtn, updateProductBtn, deleteProductBtn;
    private VBox userBox, productBox;
    private HBox buttonsBox, mainBox;

    private Label userArea, productArea;
    private TableView table;
    private UserController userController;
    private ProductController productController;


    public Home(String activeUser){
        userController = new UserController();
        productController = new ProductController();
        initComponents(activeUser);
    }

    public void initComponents(String activeUser){
        // Create scene elements
        userArea = new Label("Área Usuário");

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

        productArea = new Label("Área de Produtos");

        table = new TableView();
        table.setItems(FXCollections.observableList(productController.read(activeUser)));

        TableColumn productId = new TableColumn<>("ID");
        productId.setPrefWidth(100);
        productId.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn productName = new TableColumn<>("Nome");
        productName.setPrefWidth(100);
        productName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn productQuantity = new TableColumn<>("Quantidade");
        productQuantity.setPrefWidth(100);
        productQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        TableColumn productValue= new TableColumn<>("Valor");
        productValue.setPrefWidth(100);
        productValue.setCellValueFactory(new PropertyValueFactory<>("Value"));

        table.getColumns().setAll(productId,productName,productQuantity,productValue);

        createProductBtn = new Button("Registrar Produto");
        createProductBtn.setOnAction(e->{

        });

        updateProductBtn = new Button("Atualizar Produto");
        updateProductBtn.setOnAction(e->{

        });

        deleteProductBtn = new Button("Deletar Produto");
        deleteProductBtn.setOnAction(e->{

        });

        // Organize boxes area
        userBox = new VBox();
        userBox.getChildren().addAll(userArea,newPassword,updateBtn,deleteBtn);

        buttonsBox = new HBox();
        buttonsBox.getChildren().addAll(createProductBtn,updateProductBtn,deleteProductBtn);

        productBox = new VBox();
        productBox.getChildren().addAll(productArea,table,buttonsBox);

        mainBox = new HBox();
        mainBox.getChildren().addAll(userBox,productBox);

        scene = new Scene(mainBox);
    }

    public Scene getScene(){
        return scene;
    }
}
