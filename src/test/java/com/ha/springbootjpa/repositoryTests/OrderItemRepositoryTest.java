package com.ha.springbootjpa.repositoryTests;

import com.ha.springbootjpa.entity.Item;
import com.ha.springbootjpa.entity.Member;
import com.ha.springbootjpa.entity.OrderItem;
import com.ha.springbootjpa.repository.ItemRepository;
import com.ha.springbootjpa.repository.MemberRepository;
import com.ha.springbootjpa.repository.OrderItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
public class OrderItemRepositoryTest {
    @Autowired ItemRepository itemRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired OrderItemRepository orderItemRepository;

    @Test
    void createTest(){
        //given
        String username = "Harry";
        Member member = Member.builder()
                .username(username)
                .build();
        memberRepository.save(member);
        List<OrderItem> orderItems = new ArrayList<>();

        for(int i=1; i<=2; i++){
            Item item = itemRepository.save(Item.builder()
                    .name("item "+i)
                    .build());
            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .member(member)
                    .build();
            orderItems.add(orderItem);
        }
        //when
        List<OrderItem> savedOrderItems = orderItemRepository.saveAll(orderItems);
        //then
        Assertions.assertEquals(username,savedOrderItems.get(0).getMember().getUsername());
        Assertions.assertEquals(username,savedOrderItems.get(1).getMember().getUsername());
    }
}
