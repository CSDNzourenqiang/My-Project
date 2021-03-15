package org.example.User.action;

import com.sun.deploy.net.HttpResponse;
import org.example.User.model.User;
import org.example.User.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("user")
public class UserAction {
    @Autowired
    private IUserService service;

    @RequestMapping(path = "/list")
    public String queryList(@ModelAttribute("user") User user, Map<String,Object> map){
        map.put("userList",service.queryList(user));
        ArrayList<Object> objects = new ArrayList<>();
        for(int i=0;i<user.getPageCount();i++){
            objects.add(i+1);
        }
        map.put("pageCount",objects);
        map.put("dept",service.queryDeptList());
        return "/user/list";
    }
    @RequestMapping("toDelete")
    public String toDelete(int id){
        service.delete(id);
        return "redirect:list";
    }
    @RequestMapping("toInsert")
    public String toInsert(){
        Random r = new Random(1);
        for (int i = 0;i<10;i++){
            service.insert(new User(r.nextInt(1000),getRandomChar()+getRandomChar(),"1"));
        }
        return "redirect:list";
    }
    @RequestMapping("toInsert2")
    public String toInsert2(@ModelAttribute("user")User user,Map<String,Object> map){
        map.put("dept",service.queryDeptList());
        return "/user/insert";
    }
    @RequestMapping("toUpdate")
    public String toUpdate(int id,Map<String,Object> map){
        map.put("user",service.findById(id));
        map.put("dept",service.queryDeptList());
        return "/user/update";
    }
    @RequestMapping("toUpdate1")
    public String toUpdate1(User user){
        service.update(user);
        return "redirect:list";
    }
    @RequestMapping("toUpdate2")
    public String toUpdate2(User user){
        service.insert(user);
        return "redirect:list";
    }
    @RequestMapping("toNext")
    public String toNext(){
        service.queryList(new User());
        return "redirect:list";
    }
    public static String getRandomChar() {
        return String.valueOf((char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1))));
    }
    public static List<Integer> getArray(int o) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=o;i++){
            list.add(i);
        }
        return list;
    }
}
