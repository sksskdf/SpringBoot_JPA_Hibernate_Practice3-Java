package com.ha.springbootjpa.controller;

import com.ha.springbootjpa.entity.Member;
import com.ha.springbootjpa.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @GetMapping("/")
    public Page<Member> getAllMembers(){
        PageRequest pageRequest = PageRequest.of(0,5);
        return memberRepository.findAll(pageRequest);
    }

    @GetMapping("/members")
    public Page<Member> getAllMembersWithPageByQueryMethod(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return memberRepository.findByUsername("harry",pageRequest);
    }

    /*@PostConstruct
    public void init(){
        for(int i=0; i<100; i++){
            Member member = Member.builder()
                    .username("TestUser"+i)
                    .build();
            memberRepository.save(member);
        }
    }*/
    @PostConstruct
    public void init2(){
        for(int i=0; i<100; i++){
            Member member = Member.builder()
                    .username("harry")
                    .build();
            memberRepository.save(member);
        }
    }
}
