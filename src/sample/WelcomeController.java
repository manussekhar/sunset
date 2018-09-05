package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.DataModel;
import sample.model.Flow;

public class WelcomeController {

    @FXML
    private ListView<Flow> listView;


    @FXML
    private Label log;


    @FXML
    private Button extractButton;


    @FXML
    private Button searchButton;


    @FXML
    private Label extractDataLabel;


    @FXML
    private Label searchDataLabel;


    private DataModel dataModel;


    public void initialiseExtractList(DataModel dataModel) {
        listView.setItems(dataModel.initExtractList());
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldFlow, newFlow) -> performListViewSelectionActions(newFlow));
        dataModel.selectedFlowProperty().addListener((observable, oldValue, newValue) -> log.setText(logExtractListSelection(newValue)));

        listView.setCellFactory(lv -> new ListCell<Flow>() {
            @Override
            public void updateItem(Flow flow, boolean empty) {
                super.updateItem(flow, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(flow.getFlowName());
                }
            }
        });
    }

    private void performListViewSelectionActions(Flow newFlow) {
        dataModel.setSelectedFlow(newFlow);
        extractButton.setDisable(false);
        if (newFlow.getFlowName().startsWith("*")) {
            searchButton.setDisable(true);
            extractDataLabel.setText("Create new Data Flow");
            searchDataLabel.setText("");


            ImageView extractImageView = (ImageView) extractButton.getGraphic();

            double width = extractImageView.getImage().getRequestedWidth();
            double height = extractImageView.getImage().getRequestedHeight();
            boolean smooth = extractImageView.getImage().isSmooth();
            boolean preserveRatio = extractImageView.getImage().isPreserveRatio();
            Image extractImage = new Image(getClass().getResourceAsStream("../img/extract.png"),width,height,preserveRatio,smooth);
            extractImageView.setImage(extractImage);
        } else {
            searchButton.setDisable(false);
            extractDataLabel.setText("Edit Data Flow");
            searchDataLabel.setText("Search Data");

            ImageView editImageView = (ImageView) extractButton.getGraphic();

            double width = editImageView.getImage().getRequestedWidth();
            double height = editImageView.getImage().getRequestedHeight();
            boolean smooth = editImageView.getImage().isSmooth();
            boolean preserveRatio = editImageView.getImage().isPreserveRatio();
            Image editImage = new Image(getClass().getResourceAsStream("../img/edit.png"),width,height,preserveRatio,smooth);
            editImageView.setImage(editImage);
        }
    }


    private String logExtractListSelection(Flow newValue) {
        return newValue.getDataSourceInfo();
    }


    public void initialiseWelcomeData(DataModel dataModel) {
        this.dataModel = dataModel;
        initialiseExtractList(dataModel);
    }

}
