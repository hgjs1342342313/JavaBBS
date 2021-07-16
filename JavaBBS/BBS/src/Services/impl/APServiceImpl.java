package Services.impl;

import Dao.AreaDao;
import Dao.CommentDao;
import Dao.PostDao;
import Dao.impl.AreaDaoImpl;
import Dao.impl.CommentDaoImpl;
import Dao.impl.PostDaoImpl;
import Entity.Area;
import Entity.Person;
import Entity.comment;
import Entity.poster;
import Services.APService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class APServiceImpl implements APService {
    public poster getPoster(int posid) {
        PostDao posterDao = new PostDaoImpl();
        String[] param = new String[]{String.valueOf(posid)};
        String sql = "";
        if (posid != 0L) {
            sql = "select * from poster where id = ?";
        }
        poster p = (poster) posterDao.selectPoster(sql, param);
        return p;

    }

    public List<comment> getCommentInPoster(int posid) {
        CommentDao commentDao = new CommentDaoImpl();
        String[] param = new String[]{String.valueOf(posid)};
        String sql = "select * from com where posid = ?";
        List<comment> comList = (List<comment>) commentDao.selectComm(sql, param);
        System.out.println("****************************************************");
        System.out.println("发送者\t内容\t日期\t");
        for (int i = 0; i < comList.size(); ++i) {
            comment comm = (comment) comList.get(i);
            System.out.println("" + comm.getUserid() + "\t" + comm.getContent() + "\t" + comm.getDate());
        }
        return comList;

    }

    public List<poster> getAllPoster() {
        PostDao posterDao = new PostDaoImpl();
        String[] param = new String[]{};
        String sql = "select * from poster";
        List<poster> posterList = (List<poster>) posterDao.selectPoster(sql, param);
        System.out.println("序号\t帖子标题\t");

        for (int i = 0; i < posterList.size(); ++i) {
            poster p = (poster) posterList.get(i);
            System.out.println(p.getId() + "\t" + p.getTitle() + "\t");
        }

        System.out.println("****************************************************");
        return posterList;
    }

    public void deletePoster(int posid){
        PostDao postDao = new PostDaoImpl();
        String deletePostersql = "delete from poster where id = ?";
        Object[] posterParam={posid};
        postDao.deletePoster(deletePostersql,posterParam);
        System.out.println("删除成功！");
    }
    @Override
    public int modifyPoster(poster p) {
        PostDaoImpl postDao = new PostDaoImpl();
        int updatePoster = 0;
        String title;
        String date = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        String content;
        int Userid;
        int Areaid;
        int IfAnno;
        String updatePosterSql = "update person set " +
                "title = ?," +
                "DATE = ?," +
                "content = ?," +
                "Userid = ?," +
                "Areaid = ?," +
                "IfAnno = ?" +
                "WHERE id = ?;";
        Scanner input = new Scanner(System.in);
        Object[] posterParam = new Object[]{"title", "DATE", "content", "Userid", "Areaid", "IfAnno", "id"};
        posterParam = new Object[]{"title", "DATE", "content", "Userid", "Areaid", "IfAnno", p.getId()};
        System.out.println("Change your title?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updatePoster = postDao.executeSQL(updatePosterSql, posterParam);
            return updatePoster;
        } else {
            title = input.next();
            posterParam = new Object[]{title, "DATE", "content", "Userid", "Areaid", "IfAnno", p.getId()};
        }
        System.out.println("Change your DATE?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updatePoster = postDao.executeSQL(updatePosterSql, posterParam);
            return updatePoster;
        } else {

            date = input.next();
            posterParam = new Object[]{title, date, "content", "Userid", "Areaid", "IfAnno", p.getId()};
        }
        System.out.println("Change your content?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updatePoster = postDao.executeSQL(updatePosterSql, posterParam);
            return updatePoster;
        } else {
            content = input.next();
            posterParam = new Object[]{title, date, content, "Userid", "Areaid", "IfAnno", p.getId()};
        }
        System.out.println("Change your Userid?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updatePoster = postDao.executeSQL(updatePosterSql, posterParam);
            return updatePoster;
        } else {
            Userid = input.nextInt();
            posterParam = new Object[]{title, date, content, Userid, "Areaid", "IfAnno", p.getId()};
        }
        System.out.println("Change your Areaid?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updatePoster = postDao.executeSQL(updatePosterSql, posterParam);
            return updatePoster;
        } else {
            Areaid = input.nextInt();
            posterParam = new Object[]{title, date, content, Userid, Areaid, "IfAnno", p.getId()};
        }
        System.out.println("Change IfAnno?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updatePoster = postDao.executeSQL(updatePosterSql, posterParam);
            return updatePoster;
        } else {
            IfAnno = input.nextInt();
            posterParam = new Object[]{title, date, content, Userid, Areaid, IfAnno, p.getId()};
        }
        System.out.println("input finished!!");
        updatePoster = postDao.executeSQL(updatePosterSql, posterParam);
        return updatePoster;
    }

    public int modifyComment(comment c) {
        CommentDaoImpl CommentDao = new CommentDaoImpl();
        int updateComment = 0;
        String date = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        String content;
        int Userid;
        String updatePosterSql = "UPDATE poster set " +
                "DATE = ?," +
                "content = ?," +
                "Userid = ?," +
                "WHERE id = ?;";
        Scanner input = new Scanner(System.in);
        Object[] commentParam = new Object[]{"DATE", "content", "Userid", c.getId()};
        System.out.println("Change your DATE?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updateComment = CommentDao.executeSQL(updatePosterSql, commentParam);
            return updateComment;
        } else {
            date = input.next();
            commentParam = new Object[]{date, "content", "Userid", c.getId()};
        }
        System.out.println("Change your content?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updateComment = CommentDao.executeSQL(updatePosterSql, commentParam);
            return updateComment;
        } else {
            content = input.next();
            commentParam = new Object[]{date, content, "Userid", c.getId()};
        }
        System.out.println("Change your Userid?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updateComment = CommentDao.executeSQL(updatePosterSql, commentParam);
            return updateComment;
        } else {
            Userid = input.nextInt();
            commentParam = new Object[]{date, content, Userid, c.getId()};
        }
        System.out.println("input finished!!");
        updateComment = CommentDao.executeSQL(updatePosterSql, commentParam);
        return updateComment;
    }

    public Area getArea(int Areaid) {
        AreaDao areaDao = new AreaDaoImpl();
        String[] param = new String[]{String.valueOf(Areaid)};
        String sql = "";
        if (Areaid != 0L) {
            sql = "select * from area where id = ?";
        }
        Area a = (Area) areaDao.selectArea(sql, param);
        return a;
    }

    public List<Area> getAllArea() {
        AreaDao areaDao = new AreaDaoImpl();
        String[] param = new String[]{};
        String sql = "select * from area";
        List<Area> areaList = areaDao.selectArea(sql, param);
        System.out.println("序号\t分区名称\t");
        for (int i = 0; i < areaList.size(); ++i) {
            Area area = areaList.get(i);
            System.out.println("" + area.getId() + "\t" + area.getName());
        }
        return areaList;
    }

    public int modifyArea(Area a) {
        AreaDaoImpl areaDao = new AreaDaoImpl();
        int updateArea = 0;
        String name;
        String updateAreaSql = "UPDATE area set " +
                "name = ?" +
                "WHERE id = ?;";
        Scanner input = new Scanner(System.in);
        Object[] areaParam = new Object[]{"name", a.getId()};
        System.out.println("Change area name?(input 0 to exit)");
        if (input.nextInt() == 0) {
            updateArea = areaDao.executeSQL(updateAreaSql, areaParam);
            return updateArea;
        } else {
            name = input.next();
            areaParam = new Object[]{name, a.getId()};
        }
        System.out.println("input finished!!");
        updateArea = areaDao.executeSQL(updateAreaSql, areaParam);
        return updateArea;
    }

    public void post(poster psr) {
        String insertsql = "insert into poster values (?, ?, ?, ?, ?, ?)";
        String date = (new SimpleDateFormat("yyyy-MM-dd")).format(psr.getDate());
        Object[] posterParam = new Object[]{psr.getId(), psr.getTitle(), date, psr.getContent(), psr.getUserid(), psr.getAreaid(), psr.ifAnno()};
        PostDao postDao = new PostDaoImpl();
        int insertPoster = postDao.updatePoster(insertsql, (String[]) posterParam);
        if (insertPoster > 0) {
            System.out.println(psr.getTitle() + "已成功发送！");
        }

    }

    public void comm(comment c) {
        String insertsql = "insert into com values (?, ?, ?, ?, ?, ?)";
        String date = (new SimpleDateFormat("yyyy-MM-dd")).format(c.getDate());
        Object[] posterParam = new Object[]{c.getId(), c.getPosid(), date, c.getContent(), c.getUserid()};
        PostDao postDao = new PostDaoImpl();
        int insertPoster = postDao.updatePoster(insertsql, (String[]) posterParam);
        if (insertPoster > 0) {
            System.out.println(c.getContent() + "已成功发送！");
        }
    }
}
