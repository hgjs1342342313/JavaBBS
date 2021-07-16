package Services.impl;

import Dao.AreaDao;
import Dao.CommentDao;
import Dao.impl.AreaDaoImpl;
import Dao.impl.CommentDaoImpl;
import Services.ComFatory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ComFatoryImpl implements ComFatory {
    @Override
    public void createComment() {
        Scanner input = new Scanner(System.in);
        System.out.println("***********请输入创建评论内容！**************");
        System.out.println("请输入评论id：");
        int id = input.nextInt();
        System.out.println("请输入帖子id：");
        String posid = input.next();
        System.out.println("请输入日期：");
        String date = input.next();
        System.out.println("请输入评论内容！");
        String content = input.next();
        System.out.println("请输入你的用户id");
        int Userid = input.nextInt();
        String sql = "insert into com(id,posid,date,content,Userid) values(?,?,?,?,?)";
        Object[] param = new Object[]{id,posid,date,content,Userid};
        CommentDao commentDao = new CommentDaoImpl();
        int count = commentDao.updateComm(sql,param);
        if(count>0){
            System.out.println("成功向帖子["+posid+"]进行评论！");
        }
    }
}
