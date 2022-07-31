package com.j2kb.goalkeeperautodelete.repository;

import com.j2kb.goalkeeperautodelete.dto.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;

public class NotificationRepositoryImpl implements NotificationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void sendNotification(Notification notification) {
        String sql = "insert into notification(content,member_email,url) values(?,?,?)";
        jdbcTemplate.update(sql,notification.getContent(),notification.getMemberEmail(),notification.getUrl());
    }
}
