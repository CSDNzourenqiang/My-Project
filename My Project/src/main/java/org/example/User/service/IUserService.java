package org.example.User.service;

import org.example.User.model.Dept;
import org.example.User.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    int insert(User user);

    int update(User user);

    int delete(int id);

    List<User> queryList(User user);

    User findById(int i);

    Map<Integer,String> queryDeptList();
}
