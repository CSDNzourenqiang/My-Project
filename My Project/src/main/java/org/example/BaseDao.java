package org.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BaseDao<T> {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    protected Log logger= LogFactory.getLog(getClass());

    protected int queryCount(BaseCondition bc, String listSql) {
        StringBuffer sb= new StringBuffer();
        sb.append("select count(id) from ("+listSql+") t where 1=1 ");
        return jdbcTemplate.queryForObject(sb.toString(), bc.getParam(),Integer.class);
    }

    protected List<T> queryPage(BaseCondition bc,String sql,Class<T> clazz){
        StringBuffer totalSql = new StringBuffer();
        totalSql.append(sql);
        int rowCount=queryCount(bc,totalSql.toString());//记录个数
        int pageSize= bc.getPageSize();//页面记录数量大小
        int pageCount=rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;//页面个数
        bc.setRowCount(rowCount);
        bc.setPageCount(pageCount);
        int start=pageSize*(bc.getCur_page()-1);
        bc.setStart(start);
        totalSql.append(" limit "+start+","+(start+pageSize));
        return jdbcTemplate.query(totalSql.toString(), bc.getParam(),new BeanPropertyRowMapper<>(clazz));
    }

    protected int insert(String sql,Object[] obj){
        return jdbcTemplate.update(sql,obj);
    }
    protected int update(String sql,Object[] obj){
        return jdbcTemplate.update(sql,obj);
    }
    protected T findById(String sql,Object[] obj,Class<T> clazz){
        return jdbcTemplate.queryForObject(sql, obj, new BeanPropertyRowMapper<>(clazz));
    }

    protected List<T> queryAll(String sql,Class<T> clazz){
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(clazz));
    }
}
