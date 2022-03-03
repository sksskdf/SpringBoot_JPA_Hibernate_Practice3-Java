package com.ha.springbootjpa.repository;

import com.ha.springbootjpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
