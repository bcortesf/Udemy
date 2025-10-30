package com.bcf.arquitectura.Post.domain.repositorys_ports;

import com.bcf.arquitectura.Post.domain.modelEntitys.PostComand;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;

import java.util.Optional;

public interface PostCommandRepository {
    Optional<PostQuery> createPost(PostComand postComand);
    Optional<PostQuery> updatePost(PostComand postComand);
    void deletePost(int id);
}
