package com.bcf.arquitectura.Post.domain.repositorys_ports;

import com.bcf.arquitectura.Post.domain.modelEntitys.PostComand;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import com.bcf.arquitectura.Post.infraestructure.outbound.adapter.DtoPost;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PostQueryRepository {
    DtoPost<List<PostQuery>> findAllPost();
    DtoPost<Optional<PostQuery>> findById(int id);

    DtoPost<List<PostQuery>> findPostsByUserId(int userId);
    DtoPost<List<PostQuery>> searchPostsByFilteringParams(Map<String, String> params);

    DtoPost<Optional<PostQuery>> creatingResource(PostComand postComand);
}
