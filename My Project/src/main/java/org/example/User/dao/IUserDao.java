package org.example.User.dao;

import org.example.User.model.Dept;
import org.example.User.model.User;

import java.util.List;

public interface IUserDao {
    int insert(User user);

    int update(User user);

    int delete(int id);

    List<User> queryList(User user);

    User findById(int i);

    List<Dept> queryDeptList();
}
