import java.util.List;
import java.util.stream.Collectors;

public class ImportService {

    private DataObjectValidationService validationService;
    private Repository<DataObject> repository;


    public void batchImport(List<String[]> rawData) {
        validationService.validate(rawData);
        List<DataObject> dataObjects = rawData.stream()
                                              .map(x -> new DataObject(x[0],
                                                                       x[1],
                                                                       Double.valueOf(x[2]),
                                                                       Integer.valueOf(x[3])))
                                              .collect(Collectors.toList());
        repository.saveAll(dataObjects);
    }

}
