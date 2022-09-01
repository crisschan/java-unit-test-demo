package concurrent;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import java.util.concurrent.ExecutorService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * https://dzone.com/articles/workaround-multi-threaded 参考文章
 */
class ExecutorSubmitTest {

    @Test
    void should_verify_submit_and_task_execute() {

        ExecutorService executorService = mock(ExecutorService.class);
        doAnswer((Answer<Object>) invocation -> {
            Object[] args = invocation.getArguments();
            Runnable runnable = (Runnable)args[0];
            runnable.run();
            return null;
        }).when(executorService).submit(any(Runnable.class));

        EmailService emailService = mock(EmailService.class);
        final MultipleSendEmail multipleSendEmail = new MultipleSendEmail(emailService, executorService );

        multipleSendEmail.send();

        verify(executorService).submit(any(Runnable.class));
        verify(emailService).send(any(Email.class));
    }


}
