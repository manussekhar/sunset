package sample.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by 226455 on 02-09-2018.
 */
public class DataModel {

    private final ObjectProperty<Flow> selectedFlow = new SimpleObjectProperty<>(null);

    private final ObservableList<Flow> extractList =  FXCollections.observableArrayList();



    public ObservableList<Flow> initExtractList(){
        this.extractList.addAll(new Flow("*New Data Flow",""), new Flow("Alive Data Flow","Data source: dbc:db2://localhost:8080/ALIVE"), new Flow("SAF2 Data Flow","Data source: dbc:db2://localhost:8080/SAF2"),new Flow("Access Data Flow","Data source: dbc:db2://localhost:8080/ACCESS"));
        return extractList;
    }


    public Flow getSelectedFlow() {
        return selectedFlow.get();
    }

    public ObjectProperty<Flow> selectedFlowProperty() {
        return selectedFlow;
    }

    public void setSelectedFlow(Flow selectedFlow) {
        this.selectedFlow.set(selectedFlow);
    }
}
