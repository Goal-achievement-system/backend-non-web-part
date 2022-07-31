package com.j2kb.goalkeeperautodelete.repository;

public interface MemberRepository {
    void minusMoney(String email,int money);
}
