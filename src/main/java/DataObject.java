import java.util.ArrayList;
import java.util.List;

public class DataObject {
    private String column1;
    private String column2;
    private Double column3;
    private Integer column4;

    public DataObject(String column1, String column2, Double column3, Integer column4) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public void setColumn3(Double column3) {
        this.column3 = column3;
    }

    public void setColumn4(Integer column4) {
        this.column4 = column4;
    }


    public String getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }

    public Double getColumn3() {
        return column3;
    }

    public Integer getColumn4() {
        return column4;
    }

    public String errorMessages() {
        final List<String> result = new ArrayList<>();
        if (column1 == null) {
            result.add("column1 shoule not be null");
        }
        if ("".equals(column2)) {
            result.add("column2 should not be empty");
        }

        if (10.00 > column3) {
            result.add("column3 should not less than 10.00");
        }

        if (100 > column4) {
            result.add("column4 should not less than 100");
        }

        final String join = String.join("，", result);
        return !join.isEmpty() ? "【" + join + "】" : join;
    }
}
