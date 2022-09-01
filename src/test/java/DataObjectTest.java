import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataObjectTest {
    @Test
    void should_column1_not_be_null() {
        final DataObject dataObject = defaultDataObject();
        dataObject.setColumn1(null);

        final String errorMessages = dataObject.errorMessages();

        assertThat(errorMessages)
                .isEqualTo(format("column1 shoule not be null"));
    }

    @Test
    void should_column2_not_be_empty() {
        final DataObject dataObject = defaultDataObject();
        dataObject.setColumn2("");

        final String errorMessages = dataObject.errorMessages();

        assertThat(errorMessages)
                .isEqualTo(format("column2 should not be empty"));
    }


    @Test
    void should_column3_not_less_than_10() {
        final DataObject dataObject = defaultDataObject();
        dataObject.setColumn3(9.99);

        final String errorMessages = dataObject.errorMessages();

        assertThat(errorMessages)
                .isEqualTo(format("column3 should not less than 10.00"));
    }


    @Test
    void should_column4_not_less_than_100() {
        final DataObject dataObject = defaultDataObject();
        dataObject.setColumn4(99);

        final String errorMessages = dataObject.errorMessages();

        assertThat(errorMessages)
                .isEqualTo(format("column4 should not less than 100"));
    }


    private String format(String rawMessage) {
        return "【" + rawMessage + "】";
    }

    private DataObject defaultDataObject() {
        return new DataObject("column 1", "column 2", 100.00, 100);
    }


}
