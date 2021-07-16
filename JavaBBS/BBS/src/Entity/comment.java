package Entity;

import java.util.Date;

public class comment {
    private int id;
    private int posid;
    private Date date;
    private String content;
    private int Userid;

    public comment() {
    }


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getPosid() {
        return posid;
    }

    public void setPosid(int posid) {
        this.posid = posid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }
}
