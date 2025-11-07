public class Message {
    private String message;
    private String messageId;

    public Message(String message){
        this.message = message;
        this.messageId = "";
    }
    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessageId(String messageId){
        this.messageId = messageId;
    }

    public String getMessageId(){
        return this.messageId;
    }
}
