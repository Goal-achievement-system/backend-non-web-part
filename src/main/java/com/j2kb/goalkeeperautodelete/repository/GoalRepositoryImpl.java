package com.j2kb.goalkeeperautodelete.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoalRepositoryImpl implements GoalRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void updateTimeLimitGoal() {
        String sql = "update goal set verification_result = 'fail' where limit_date < current_timestamp() and verification_result = 'ongoing' and (select count(*) from certification where goal_id = goal.goal_id) = 0";
        jdbcTemplate.update(sql);
    }

    @Override
    public void updateTimeLimitCert() {
        String sql = "update goal,certification set goal.verification_result = 'hold', certification.verification_result='hold' where goal.limit_date < current_timestamp() and goal.verification_result ='oncertification' and (select count(*) from certification where goal_id = goal.goal_id) = 1";
        jdbcTemplate.update(sql);
    }
}
