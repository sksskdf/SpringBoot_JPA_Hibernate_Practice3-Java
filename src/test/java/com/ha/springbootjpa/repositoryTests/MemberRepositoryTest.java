package com.ha.springbootjpa.repositoryTests;

import com.ha.springbootjpa.entity.Member;
import com.ha.springbootjpa.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Slf4j
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
    
    @Test
    @DisplayName("쿼리테스트")
    @Disabled
    public void queryTest(){
        Member member = Member.builder()
                .username("harry")
                .build();

        memberRepository.save(member);

        /*Optional<Member> findMember = memberRepository.findByUsername("harry");*/

        /*log.info("Username : " + findMember.get().getUsername());*/
    }
}
