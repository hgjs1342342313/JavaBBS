package Services.impl;

import Dao.CommentDao;
import Dao.PersonDao;
import Dao.PostDao;
import Dao.impl.CommentDaoImpl;
import Dao.impl.PersonDaoImpl;
import Dao.impl.PostDaoImpl;
import Entity.Person;
import Entity.comment;
import Entity.poster;
import Services.PersonService;

import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    public Person login() {
        Scanner input = new Scanner(System.in);
        Person person = null;
        boolean type = true;

        while (type) {
            System.out.println("请先登录，请输入您的用户名：");
            String userName = input.nextLine().trim();
            System.out.println("请输入密码：");
            String Password = input.nextLine().trim();
            PersonDao personDao = new PersonDaoImpl();
            String sql = "select * from person where username=? and pwd=?";
            String[] param = new String[]{userName, Password};
            person = personDao.getPerson(sql, param);
            if (person != null) {
                System.out.println("-------恭喜成功登录-------");
                System.out.println("名字：" + person.getName());
                System.out.println("等级：" + person.getLevel());
                System.out.println("状态：" + person.getstatus());
                System.out.println("是否为管理员：" + person.ifMgr());
                type = false;
            } else {
                System.out.println("登录失败，请确认您的用户名和密码是否正确,重新登录");
                type = true;
            }
        }

        return person;

    }

    public List<poster> getMyPoster(int id) {
        PostDao postDao = new PostDaoImpl();
        String[] param = new String[]{String.valueOf(id)};
        String sql = "";
        if (id != 0) {
            sql = "select * from poster where Userid = ?";
        }

        if (0 == id) {
            System.out.println("id不应等于0");
            return null;
        }

        List<poster> posterList = postDao.selectPoster(sql, param);
        return posterList;
    }

    public List<comment> getMyComment(int id) {
        CommentDao commentDao = new CommentDaoImpl();
        String[] param = new String[]{String.valueOf(id)};
        String sql = "";
        if (id != 0) {
            sql = "select * from com where Userid = ?";
        }

        if (0 == id) {
            System.out.println("id不应等于0");
            return null;
        }

        List<comment> commentList = commentDao.selectComm(sql, param);
        return commentList;
    }

    public void deletePoster(poster p) {
        PostDao postDao = new PostDaoImpl();
        String[] param = new String[]{String.valueOf(p.getId())};
        String sql = "DELETE FROM poster WHERE id = ?";
        postDao.deletePoster(sql, param);
    }

    public void deleteComm(comment c) {
        CommentDao commentDao = new CommentDaoImpl();
        String[] param = new String[]{String.valueOf(c.getId())};
        String sql = "DELETE FROM com WHERE id = ?";
        commentDao.deleteComm(sql, param);
    }


    public List<Person> person(int id) {
        String sql = "select * from person where id =? ";
        String[] param = new String[]{String.valueOf(id)};
        PersonDao personDao = new PersonDaoImpl();
        List<Person> list = (List<Person>) personDao.getPerson(sql, param);
        return list;
    }


    public void signin(Person p) {
        int person;
        boolean type = true;
        while (type) {
            PersonDao personDao = new PersonDaoImpl();
            String sql = "INSERT INTO person(id,NAME,username,pwd,LEVEL,STATUS,IfMgr) VALUE (?,?,?,?,?,?,?) ";
            Object[] param = new Object[]{p.getId(), p.getName(), p.getUsername(), p.getPwd(), 1, 1, 0};
            person = personDao.updatePerson(sql, param);
            if (person > 0) {
                System.out.println("注册成功！您的账号是：" + p.getUsername());
                type = false;
            } else {
                System.out.println("注册失败，请联系管理员");
                type = false;
            }
        }

    }


}
