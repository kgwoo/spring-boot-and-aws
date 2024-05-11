package com.gunwoo.spring_boot_aws.web;

import com.gunwoo.spring_boot_aws.service.posts.PostsService;
import com.gunwoo.spring_boot_aws.web.dto.PostsResponseDto;
import com.gunwoo.spring_boot_aws.web.dto.PostsSaveRequestDto;
import com.gunwoo.spring_boot_aws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long Update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDTO){
        return postsService.update(id, requestDTO);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }




}
