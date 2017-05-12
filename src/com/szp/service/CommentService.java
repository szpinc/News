package com.szp.service;

import com.szp.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/4/23.
 */
public class CommentService extends BaseService {


    private String sql;

    public void add (Comment comment) {

        sql = "INSERT INTO tb_comment(content,article_id,user_id,time) VALUES(?,?,?,NOW())";

        dao.update(sql,comment.getContent(),comment.getArticleId(),comment.getUserId());

    }

    public void delete (int id) {
        sql = "DELETE FROM tb_comment WHERE id=?";
        dao.update(sql,id);
    }

    public Comment getById (int id) {
        sql = "SELECT * FROM tb_comment WHERE id=?";
        return dao.queryBean(sql,Comment.class,id);
    }

    public List<Comment> getAll () {
        return queryAll("tb_comment",Comment.class);
    }

    public List<Comment> getByTimeDescLimit (int count) {
        sql ="SELECT * FROM (SELECT * FROM tb_comment ORDER BY TIME DESC) temp ORDER BY TIME DESC LIMIT ?";
        return dao.query(sql,Comment.class,count);
    }



}
