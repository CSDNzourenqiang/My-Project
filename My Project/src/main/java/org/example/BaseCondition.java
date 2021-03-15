package org.example;

import java.util.ArrayList;
import java.util.List;

/*
* 查询条件的基类*/
public abstract class BaseCondition {
    private Integer start=0;//起始行
    private Integer cur_page=1;//当前页
    private Integer pageCount;//页数
    private Integer rowCount;//记录数
    private Integer pageSize=10;//页大小
    protected StringBuffer sb = new StringBuffer();
    protected List<Object> param =new ArrayList<>();

    public abstract void getCondition();

    public String getCond(){
        param.clear();
        sb.setLength(0);
        getCondition();
        return sb.toString();
    };

    public void add(String s,String sql,Integer i){
        if (i==2){
            if(s!=null&&!s.equals("")){
                sb.append(sql);
                param.add("%"+s+"%");
            }
        }else {
            if(s!=null&&!s.equals("")){
                sb.append(sql);
                param.add(s);
            }
        }

    }

    public void add(Integer s,String sql){
        if(s!=null){
            sb.append(sql);
            param.add(s);
        }
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCur_page() {
        return cur_page;
    }

    public Object[] getParam(){
        return param.toArray();
    }

    public void setCur_page(Integer cur_page) {
        this.cur_page = cur_page;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
