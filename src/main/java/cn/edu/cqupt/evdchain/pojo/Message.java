package cn.edu.cqupt.evdchain.pojo;

public class Message {

    private Boolean status;

    private String msg;

    public Message(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}
