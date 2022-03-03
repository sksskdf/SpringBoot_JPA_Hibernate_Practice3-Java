package com.ha.springbootjpa.repository;

import com.ha.springbootjpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
