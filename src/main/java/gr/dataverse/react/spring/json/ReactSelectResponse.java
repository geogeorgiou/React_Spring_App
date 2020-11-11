package gr.dataverse.react.spring.json;
import java.util.ArrayList;
import java.util.List;

public class ReactSelectResponse {

    List<String> labels;
    List<String> values;

    public ReactSelectResponse(List<String> labels, List<String> values) {
        this.labels = labels;
        this.values = values;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
