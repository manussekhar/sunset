package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by 226455 on 02-09-2018.
 */
public class Flow {

    private StringProperty flowName = new SimpleStringProperty();

    private String dataSourceInfo;

    public Flow(String flowName, String dataSourceInfo) {
        setStringFlowName(flowName);
        this.dataSourceInfo=dataSourceInfo;
    }

    private void setStringFlowName(String flowName) {
        this.flowName.set(flowName);
    }

    public String getFlowName() {
        return flowName.get();
    }

    public StringProperty flowNameProperty() {
        return flowName;
    }

    public String getDataSourceInfo() {
        return dataSourceInfo;
    }

    public void setDataSourceInfo(String dataSourceInfo) {
        this.dataSourceInfo = dataSourceInfo;
    }
}
