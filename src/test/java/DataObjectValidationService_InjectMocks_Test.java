import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

class DataObjectValidationService_InjectMocks_Test {


    @Mock
    private DependencyService dependencyServiceStub;

    @InjectMocks
    private DataObjectValidationService service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_find_error_row() {
//        given
        given(dependencyServiceStub.getValueByRaw("column1")).willReturn("column1");


//        when
        final ThrowableAssert.ThrowingCallable validationCallable = () -> service.validate(Arrays.asList(new String[]{"column1", "column2", "9", "99"},
                                                                                                         new String[]{null, "9.99", "9", "99"}));
//        then
        assertThatThrownBy(validationCallable)
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("【column3 should not less than 10.00，column4 should not less than 100】");
    }
}
