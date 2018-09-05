package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.model.DataModel;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        showWelcomeScreen(primaryStage);

    }

    private void showWelcomeScreen(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "welcome.fxml"
                )
        );
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setTitle("Sunset");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        WelcomeController controller =  loader.getController();
        controller.initialiseWelcomeData(new DataModel());
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
