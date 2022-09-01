import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ImportServiceTest {

    @InjectMocks
    private ImportService importService;
    @Spy
    private Repository<DataObject> repository;
    @Mock
    private DataObjectValidationService validationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_save_data_successfully() {

        List<String[]> rows = Arrays.asList(new String[]{"column1", "column2", "9", "99"},
                                            new String[]{"column11", "9.99", "9", "99"});
        doNothing().when(validationService).validate(rows);

        importService.batchImport(rows);


        ArgumentCaptor<List<DataObject>> argumentCaptor = ArgumentCaptor.forClass(((Class) List.class));
        verify(repository, times(1)).saveAll(argumentCaptor.capture());

        List<DataObject> dataObjectList = argumentCaptor.getValue();
        assertThat(dataObjectList.size()).isEqualTo(2);

        DataObject first = dataObjectList.get(0);
        assertThat(first.getColumn1()).isEqualTo("column1");
        assertThat(first.getColumn2()).isEqualTo("column2");
        assertThat(first.getColumn3()).isEqualTo(9D);
        assertThat(first.getColumn4()).isEqualTo(99);

        DataObject second = dataObjectList.get(1);
        assertThat(second.getColumn1()).isEqualTo("column11");
        assertThat(second.getColumn2()).isEqualTo("9.99");
        assertThat(second.getColumn3()).isEqualTo(9D);
        assertThat(second.getColumn4()).isEqualTo(99);
    }
}
