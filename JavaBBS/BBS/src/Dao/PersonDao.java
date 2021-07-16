package Dao;

import Entity.Person;

import java.util.List;

public interface PersonDao {
    int updatePerson(String var1,Object[] var2);
    List<Person> getAllPerson();
    Person getPerson(String var1,String[] var2);
    Person selectPerson(String var1,String[] var2);
}
