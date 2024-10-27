import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UnitConverter extends Application {

    private ComboBox<String> fromUnit = new ComboBox<>();
    private ComboBox<String> toUnit = new ComboBox<>();
    private TextField valueField = new TextField();
    private Label resultLabel = new Label("Result: ");

    @Override
    public void start(Stage primaryStage) {
        fromUnit.getItems().addAll("Meters", "Kilometers", "Miles", "Yards");
        toUnit.getItems().addAll("Meters", "Kilometers", "Miles", "Yards");

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> convert());

        HBox inputBox = new HBox(10, fromUnit, valueField, toUnit, convertButton);
        inputBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, inputBox, resultLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20; -fx-font-size: 16; -fx-background-color: #f0f0f0;");

        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setTitle("Unit Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convert() {
        try {
            String from = fromUnit.getValue();
            String to = toUnit.getValue();
            double value = Double.parseDouble(valueField.getText());
            double result = 0;

            // Sample conversion logic
            if (from.equals("Meters") && to.equals("Kilometers"))
                result = value / 1000;
            else if (from.equals("Kilometers") && to.equals("Meters"))
                result = value * 1000;
            else if (from.equals("Miles") && to.equals("Kilometers"))
                result = value * 1.60934;
            else if (from.equals("Kilometers") && to.equals("Miles"))
                result = value / 1.60934;
            else
                result = value; // for same units

            resultLabel.setText("Result: " + result + " " + to);
        } catch (Exception e) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
