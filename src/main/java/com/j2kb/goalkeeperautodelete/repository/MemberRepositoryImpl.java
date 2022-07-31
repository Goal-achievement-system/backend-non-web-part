package com.j2kb.goalkeeperautodelete.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MemberRepositoryImpl implements MemberRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void minusMoney(String email, int money) {
        String sql = "update member set money = money - ? where email = ?";
        jdbcTemplate.update(sql,money,email);
    }
}
