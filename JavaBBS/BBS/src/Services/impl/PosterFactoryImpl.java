package Services.impl;

import Dao.AreaDao;
import Dao.PostDao;
import Dao.impl.AreaDaoImpl;
import Dao.impl.PostDaoImpl;
import Services.PosterFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PosterFactoryImpl implements PosterFactory {
    @Override
    public void createNewPoster() {
        Scanner input = new Scanner(System.in);
        System.out.println("***********请输入帖子内容！**************");
        System.out.println("请输入帖子id：");
        int id = input.nextInt();
        System.out.println("请输入帖子标题：");
        String title = input.next();
        System.out.println("请输入日期：");
        //String date = (new SimpleDateFormat("yyyy-MM-dd")).format();
        String date = input.next();
        System.out.println("请输入帖子内容！");
        String content = input.next();
        System.out.println("请输入你的用户id");
        int Userid = input.nextInt();
        System.out.println("请输入你想插入的分区id");
        int Areaid = input.nextInt();
        System.out.println("是否是公告？1是0否");
        int ifAnno = input.nextInt();
        String sql = "insert into poster(id,title,date,content,Userid,Areaid,ifAnno) values(?,?,?,?,?,?,?)";
        Object[] param = new Object[]{id,title,date,content,Userid,Areaid,ifAnno};
        PostDao postDao = new PostDaoImpl();
        int count = postDao.updatePoster(sql,param);
        if(count>0){
            System.out.println("成功发送帖子["+title+"]!");
        }
    }
}
