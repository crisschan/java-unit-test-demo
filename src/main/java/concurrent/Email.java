package concurrent;

import java.time.LocalDateTime;

public class Email {
    String emailContent;

    public Email(String title) {
        emailContent = title + LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailContent='" + emailContent + '\'' +
                '}';
    }
}
