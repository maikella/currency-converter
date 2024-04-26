import java.util.Collections;
import java.util.List;

public class Converter {

    private String from, to;
    private List<CodeDeserialize> listCode;

    public Converter(String from, String to, List<CodeDeserialize> listCode) {
        this.from = from;
        this.to = to;
        this.listCode = listCode;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<CodeDeserialize> getListCode() {
        return Collections.unmodifiableList(listCode);
    }

    public void setListCode(List<CodeDeserialize> listCode) {
        this.listCode = listCode;
    }
}
