package Runpkg;

import Dao.*;
import Dao.impl.AreaDaoImpl;
import Dao.impl.CommentDaoImpl;
import Dao.impl.PersonDaoImpl;
import Dao.impl.PostDaoImpl;
import Entity.*;
import Services.*;
import Services.impl.APServiceImpl;
import Services.impl.ComFatoryImpl;
import Services.impl.PersonServiceImpl;
import Services.impl.PosterFactoryImpl;

import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        startBBS();
    }

    private static void startBBS() {
        System.out.println("----------------------论坛系统启动-----------------");
        System.out.println("分区信息");
        System.out.println("****************************************************");
        AreaDao areaDao = new AreaDaoImpl();
        List<Area> areaList = areaDao.getALLArea();
        System.out.println("序号\t分区名称\t");

        for (int i = 0; i < areaList.size(); ++i) {
            Area area = areaList.get(i);
            System.out.println("" + area.getId() + "\t" + area.getName());
        }

        System.out.println("****************************************************");
        System.out.print("\n");
        System.out.println("用户排行");
        PersonDao personDao = new PersonDaoImpl();
        List<Person> personList = personDao.getAllPerson();
        System.out.println("****************************************************");
        System.out.println("序号\t姓名\t等级");

        for (int i = 0; i < personList.size(); ++i) {
            Person person = (Person) personList.get(i);
            System.out.println(person.getId() + "\t" + person.getName() + "\t" + person.getLevel());
        }

        System.out.println("****************************************************");
        System.out.print("\n");
        System.out.println("帖子信息");
        System.out.println("****************************************************");
        PostDao posterDao = new PostDaoImpl();
        List<poster> posterList = posterDao.getAllPoster();
        System.out.println("序号\t帖子标题\t");

        for (int i = 0; i < posterList.size(); ++i) {
            poster p = (poster) posterList.get(i);
            System.out.println(p.getId() + "\t" + p.getTitle() + "\t");
        }

        System.out.println("****************************************************");
        System.out.print("\n");
        Scanner input = new Scanner(System.in);
        boolean flag = false;
        do {
            System.out.println("请登录或注册:1-登录/\\2-注册");
            int i = input.nextInt();
            if(i==2){
                flag = true;
                System.out.println("注册！");
                registerGOOOOOO();

            }else if(i==1){
                flag = true;
                boolean type = true;

                while (type) {
                    //PersonService pss = new PersonServiceImpl();
                    //pss.login();
                    personLogin();
                    type = false;
                }
            }
            else{
                System.out.println("您输入有误");
            }
        }while(flag == false);
    }

    private static Person personLogin() {
        new Scanner(System.in);
        PersonService person = new PersonServiceImpl();
        Person pp = person.login();
        System.out.println("您已登录成功！可以进行如下操作！");
        Choose(pp);
        return pp;
    }

    private static void post() {
        PosterFactory posterFactory = new PosterFactoryImpl();
        posterFactory.createNewPoster();
    }

    private static void comment2() {
        ComFatory comFatory = new ComFatoryImpl();
        comFatory.createComment();
    }

    private static void showArea() {
        APService apService = new APServiceImpl();
        apService.getAllArea();
    }

    private static void showPoster() {
        APService apService = new APServiceImpl();
        apService.getAllPoster();
    }

    private static void showCommentInPoster(int posid) {
        APService apService = new APServiceImpl();
        apService.getCommentInPoster(posid);
    }

    private static void Choose(Person p) {
        Scanner input = new Scanner(System.in);
        boolean type = true;

        while (type) {
            System.out.println("请输入数字以进行选择");
            System.out.println("1:发帖");
            System.out.println("2:评论");
            System.out.println("3:再看看分区");
            System.out.println("4:再看看帖子");
            System.out.println("5:找个帖子看看评论");
            System.out.println("6:删帖");
            System.out.println("0:退出");
            int num = input.nextInt();
            switch (num) {
                case 0:
                    System.out.println("再见，欢迎再次使用");
                    type = false;
                    break;
                case 1:
                    post();
                    //type = true;
                    break;
                case 2:
                    comment2();
                   // type = false;
                    break;
                case 3:
                    showArea();
                   // type = false;
                    break;
                case 4:
                    showPoster();
                    //type = false;
                    break;
                case 5:
                    System.out.println("你要查看哪个id的帖子的评论呢？");
                    int posid = input.nextInt();
                    showCommentInPoster(posid);
                   // type = false;
                    break;
                case 6:
                    System.out.println("你要删除哪个id的帖子呢？");
                    int pod = input.nextInt();
                    changeComm(pod);
                default:
                    System.out.println("输入有误，重新输入请！");
                    type = true;
            }
        }
    }

    private static void changeComm(int poid){
            APService apService = new APServiceImpl();
            apService.deletePoster(poid);
    }
    private static void registerGOOOOOO() {
        PersonService ps = new PersonServiceImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("开始注册！");
        Person p = new Person();
        System.out.println("您的id是？");
        int id = input.nextInt();
        System.out.println("您的用户名：");
        String userName = input.next();
        System.out.println("您的昵称");
        String name = input.next();
        boolean flag = false;
        String pwd = new String();
        do {
            System.out.println("您的密码是：");
            pwd = input.next();
            System.out.println("请再次输入您的密码以确保您能准确记忆");
            String pwd2 = input.next();
            if(pwd == pwd2){
                flag = true;
            }
        }while (flag = false);
        p.setId(id);p.setUsername(userName);
        p.setName(name);p.setPwd(pwd);
        ps.signin(p);
    }

}
