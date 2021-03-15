package org.example.User.service;

import org.example.User.dao.IUserDao;
import org.example.User.model.Dept;
import org.example.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public int insert(User user) {
        return dao.insert(user);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public List<User> queryList(User user) {
        Map<Integer, String> map = queryDeptList();
        List<User> users = dao.queryList(user);
        for (User user1 : users) {
            user1.setDept(map.get(Integer.parseInt(user1.getDept())));
        }
        return users;
    }

    @Override
    public User findById(int i) {
        return dao.findById(i);
    }

    @Override
    public Map<Integer, String> queryDeptList() {
        Map<Integer,String> map=new LinkedHashMap();
        List<Dept> depts = dao.queryDeptList();
        map.put(null,"");
        for (Dept dept :
                depts) {
            map.put(dept.getId(),dept.getDept());
        }
        return map;
    }
}
