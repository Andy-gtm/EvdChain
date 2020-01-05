package cn.edu.cqupt.evdchain.pojo;

public class Message {

    private Boolean status;

    private String msg;

    public Message(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "{" +
                "\"status\":" + status +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }
}
