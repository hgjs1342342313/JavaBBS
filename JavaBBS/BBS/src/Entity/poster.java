package Entity;

import java.util.Date;

public class poster {
    private int id;
    private String title;
    private Date date;
    private String content;
    private int Userid;
    private int Areaid;
    private int ifAnno;

    public poster() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAreaid() {
        return Areaid;
    }

    public void setAreaid(int Areaid) {
        this.Areaid = Areaid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int ifAnno() {
        return ifAnno;
    }
    public Date getDate(){
        return date;
    }
    public void setIfAnno(int IfAnno) {
        this.ifAnno = IfAnno;
    }

}
