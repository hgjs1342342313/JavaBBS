package Entity;

public class Person {
    private int id;
    private String name;
    private String username;
    private String pwd;
    private int level;
    private boolean status;
    private boolean ifMgr;

    public Person() {
    }
public void setId(int id){
        this.id = id;
}
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getLevel() {
        return level;
    }
    public void setLevelPlus(int level,Person p){if(this.ifMgr){p.level=level;}}
    public void setLevel(int level){this.level = level;}
    public void setStatus(boolean status){
        this.status = status;
    }
    public boolean getstatus() {
        return status;
    }

    public void changestatus(boolean st) {
        status = st;
    }

    public boolean ifMgr() {
        return ifMgr;
    }

    public void setIfMgr(boolean ifMgr) {
        this.ifMgr = ifMgr;
    }

    public void setStatusPlus(boolean status,Person p) {
        if (this.ifMgr) {
            p.status = status;
        }
    }
}
