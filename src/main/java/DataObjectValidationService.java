import java.util.List;

public class DataObjectValidationService {

    private DependencyService service;

    public DataObjectValidationService(DependencyService service) {
        this.service = service;
    }

    public void validate(List<String[]> rawData) {

//        final Optional<DataObject> firstErrorRow =
//                rawData.stream()
//                       .map(raw -> new DataObject(
//                               raw[0],
//                               raw[1],
//                               Double.valueOf(raw[2]),
//                               Integer.valueOf(raw[3])))
//                       .filter(x -> !x.errorMessages().isEmpty())
//                       .findFirst();
//
//        if (firstErrorRow.isPresent()) {
//            throw new RuntimeException(firstErrorRow.get()
//                                                    .errorMessages()
//                                                    .toString());
//        }

        for (String[] raw : rawData) {
            final DataObject dataObject = new DataObject(
                    service.getValueByRaw(raw[0]),
                    raw[1],
                    Double.valueOf(raw[2]),
                    Integer.valueOf(raw[3]));
            if (!dataObject.errorMessages().isEmpty()) {
                throw new RuntimeException(dataObject
                                                   .errorMessages()
                                                   .toString());
            }

        }
    }
}

//1. 改动赋值代码
//2. 将 validation 挪到实体类中
//3. 添加 validation 测试
//4. 添加 service 测试（看情况，因为需要测试替身）
