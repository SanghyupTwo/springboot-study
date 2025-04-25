package me.leesanghyup.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.leesanghyup.springbootdeveloper.domain.Article;
import me.leesanghyup.springbootdeveloper.dto.AddArticleRequest;
import me.leesanghyup.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 데이터베이스에 저장되어 있는 모든 글 가져오기
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // ID를 이용해 글을 조회
    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
