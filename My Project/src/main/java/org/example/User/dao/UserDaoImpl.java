package org.example.User.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.BaseDao;
import org.example.User.model.Dept;
import org.example.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {

    @Override
    public int insert(User user) {
        String sql="insert into user (id,name,age,dept) values (?,?,?,?)";
        Object[] obj = {user.getId(),user.getName(),user.getAge(),user.getDept()};
        return insert(sql,obj);
    }

    @Override
    public int update(User user) {
        String sql="update user set name=?,age=?,dept=? where id=?";
        Object[] obj = {user.getName(),user.getAge(),user.getDept(),user.getId()};
        return update(sql,obj);
    }

    @Override
    public int delete(int id) {
        String sql="delete from user where id=?";
        Object[] obj = {id};
        return update(sql,obj);
    }

    @Override
    public List<User> queryList(User user) {
        StringBuffer sb= new StringBuffer();
        sb.append("select id,name,age,dept from user where 1=1 ");
        sb.append(user.getCond());
        return queryPage(user,sb.toString(),User.class);
    }

    @Override
    public User findById(int i) {
        String sql="select id,name,age,dept from user where id=?";
        Object[] object = {i};
        return (User)findById(sql, object, User.class);
    }

    @Override
    public List<Dept> queryDeptList() {
        String sql="select id,dept from dept";
        return queryAll(sql,Dept.class);
    }
}
