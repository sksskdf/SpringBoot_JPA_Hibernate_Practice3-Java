package com.ha.springbootjpa.repositoryTests;

import com.ha.springbootjpa.entity.Member;
import com.ha.springbootjpa.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class lambdaTests {

    @Test
    public void lambdaDoublecolon(){
        List<String> list = List.of("a","b","c","d","e");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
