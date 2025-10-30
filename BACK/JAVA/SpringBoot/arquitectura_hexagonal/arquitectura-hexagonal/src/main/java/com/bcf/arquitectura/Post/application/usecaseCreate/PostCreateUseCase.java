package com.bcf.arquitectura.Post.application.usecaseCreate;

import com.bcf.arquitectura.Post.application.PostResponse;
import com.bcf.arquitectura.Post.application.mappers.ResponseMapper;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostComand;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import com.bcf.arquitectura.Post.domain.repositorys_ports.PostQueryRepository;
import com.bcf.arquitectura.Post.infraestructure.outbound.adapter.DtoPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostCreateUseCase {

    private final PostQueryRepository postQueryRepository;
    private final ResponseMapper responseMapper;

    public PostResponse<PostQuery> creatingResource(PostComand postComand) {
        //RESPUESTA-MICROSERVICIO: por partes
        DtoPost<PostQuery> dtoPostQuery = postQueryRepository.creatingResource(postComand)
                .getResponseDto()
                .map(postQuery -> DtoPost.<PostQuery>builder().responseDto(postQuery).build())
                .orElseThrow();

        return responseMapper.dtoPostSingleToPostResponse( dtoPostQuery );
    }
}
