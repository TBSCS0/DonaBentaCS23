package view;
import controller.ProductController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CreateProduct {
    private Button createBtn;
    private TextField idField, nameField, quantityField, valueField;
    private VBox mainBox;

    private Scene scene;
    private ProductController productController;

    public CreateProduct(String activeUser){
        initComponents(activeUser);
    }

    public void initComponents(String activeUser){
        idField = new TextField();
        idField.setPromptText("ID");

        nameField = new TextField();
        nameField.setPromptText("Nome");

        quantityField = new TextField();
        quantityField.setPromptText("Quantidade");

        valueField = new TextField();
        valueField.setPromptText("Valor");

        createBtn = new Button("Registrar Produto");
        createBtn.setOnAction(e->{
            productController = new ProductController();
            productController.create(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    Integer.parseInt(quantityField.getText()),
                    Double.parseDouble(valueField.getText()),
                    activeUser
            );
        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(idField,nameField,quantityField,valueField,createBtn);

        scene = new Scene(mainBox);
    }

    public Scene getScene(){
        return scene;
    }
}
