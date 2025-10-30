package com.bcf.arquitectura.Post.application.mappers;


import com.bcf.arquitectura.Post.application.PostResponse;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import com.bcf.arquitectura.Post.infraestructure.outbound.adapter.DtoPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    @Mapping(target = "response", source = "responseDto")
    PostResponse<List<PostQuery>> dtoPostListToPostResponse(DtoPost<List<PostQuery>> dtoPost);

    @Mapping(target = "response", source = "responseDto")
    PostResponse<PostQuery> dtoPostSingleToPostResponse(DtoPost<PostQuery> dtoPost);
}
/*
    PostResponse<Object> dtoPostSingleToPostResponse(DtoPost<Object> dtoPost)

    PostResponse sourceToDestination(DtoPost dtoPost)
    DtoPost destinationToSource(PostResponse postResponse)

    SimpleDestination sourceToDestination(SimpleSource source)
    SimpleSource destinationToSource(SimpleDestination destination)
 */