package di_bean.property_file;

public class MessageServiceImpl implements MessageService {
    private String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
