package concurrent;

import java.util.concurrent.ExecutorService;

public class MultipleSendEmail {
    public MultipleSendEmail(EmailService emailService, ExecutorService executorService) {
        this.emailService = emailService;
        this.executorService = executorService;
    }

    private EmailService emailService;
    private ExecutorService executorService;

    void send() {
        executorService.submit(() -> {
            emailService.send(new Email("aTitle"));
        });

    }

}
