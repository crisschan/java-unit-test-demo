package concurrent;

public class EmailService {
    public void send(Email email) {
        try {
            System.out.println(email);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
