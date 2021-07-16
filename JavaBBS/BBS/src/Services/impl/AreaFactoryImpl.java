package Services.impl;

import Dao.AreaDao;
import Dao.impl.AreaDaoImpl;
import Entity.Area;

import java.util.Scanner;

public class AreaFactoryImpl {
    public AreaFactoryImpl() {

    }

    public void CreateNewArea() {
        Scanner input = new Scanner(System.in);
        System.out.println("***********请输入创建分区属性！**************");
        System.out.println("请输入分区id：");
        int id = input.nextInt();
        System.out.println("请输入分区名字：");
        String name = input.next();
        String sql = "insert into area(id,name) values(?,?)";
        Object[] param = new Object[]{id, name};
        AreaDao areaDao = new AreaDaoImpl();
        int count = areaDao.updateArea(sql, param);
        if (count > 0) {
            System.out.println("成功创建分区[" + name + "]，id：" + id + "!");
        }
    }

}
