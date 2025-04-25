package me.leesanghyup.springbootdeveloper.repository;

import me.leesanghyup.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
