import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class DataObjectValidationServiceTest {


    private DependencyService dependencyServiceStub;

    @BeforeEach
    void setUp() {
        dependencyServiceStub = mock(DependencyService.class);
    }

    @Test
    public void should_find_error_row() {
//        given
        given(dependencyServiceStub.getValueByRaw("column1")).willReturn("column1");
        final DataObjectValidationService service = new DataObjectValidationService(dependencyServiceStub);

//        when
        final ThrowableAssert.ThrowingCallable validationCallable = () -> service.validate(Arrays.asList(new String[]{"column1", "column2", "9", "99"},
                                                                                                         new String[]{null, "9.99", "9", "99"}));
//        then
        assertThatThrownBy(validationCallable)
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("【column3 should not less than 10.00，column4 should not less than 100】");
    }
}
