package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface PostRepository extends JpaRepository<Post, BigDecimal> {
}
