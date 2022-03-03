package com.ha.springbootjpa.repositoryTests;

import com.ha.springbootjpa.entity.Member;
import com.ha.springbootjpa.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void saveMemberTest(){
        //given
        String username = "Member B";

        //when
        Member member = Member.builder()
                .username(username)
                .build();
        Member saveMember = memberRepository.save(member);

        //then
        Assertions.assertEquals(saveMember.getUsername(),username);
    }
}
