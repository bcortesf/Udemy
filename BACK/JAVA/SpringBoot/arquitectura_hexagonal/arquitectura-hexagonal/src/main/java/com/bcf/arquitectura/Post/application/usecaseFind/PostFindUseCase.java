package com.bcf.arquitectura.Post.application.usecaseFind;

import com.bcf.arquitectura.Post.application.PostResponse;
import com.bcf.arquitectura.Post.application.mappers.ResponseMapper;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import com.bcf.arquitectura.Post.domain.repositorys_ports.PostQueryRepository;
import com.bcf.arquitectura.Post.infraestructure.outbound.adapter.DtoPost;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class PostFindUseCase {

    private final PostQueryRepository postQueryRepository;
    private final ResponseMapper responseMapper;


    public PostResponse<List<PostQuery>> findAllPost() {
        //                  ** retorno-1 **
//        return responseMapper.dtoPostToPostResponse(
//                postQueryRepository.findAllPost()
//        );

        //---------------------------------------------
        //---------------------------------------------
        //                  ** retorno-2 **
//        PostResponse<List<PostQuery>> response = responseMapper.dtoPostToPostResponse(
//                postQueryRepository.findAllPost()
//        );
//        return response;

        //---------------------------------------------
        //---------------------------------------------
        //                  ** retorno-3 **
//        return PostResponse.<List<PostQuery>>builder()
//                .response(
//                        postQueryRepository
//                                .findAllPost()
//                                .getResponseDto()
//                )
//                .build();

        //---------------------------------------------
        //                  ** retorno-4 **
        List<PostQuery> responseList = responseMapper.dtoPostListToPostResponse(
                postQueryRepository.findAllPost()
        ).getResponse();


        return PostResponse.<List<PostQuery>>builder()
                .response( responseList )
                .build();

        //---------------------------------------------
        //---------------------------------------------
    }


    public PostResponse<PostQuery> findById(Integer id) {

        PostQuery postQuery = postQueryRepository.findById(id)
                .getResponseDto()
                .orElseThrow();

        return PostResponse
                .<PostQuery>builder()
                .response( postQuery )
                .build();

        // /////////////////////////////////////////////////////////
//        var postResponseObject1 = PostResponse.builder()
//                .response( postQuery )
//                .build();

//        PostResponse<Object> postResponseObject2 = PostResponse
//                .<Object>builder()
//                .response( postQuery )
//                .build();

//        PostResponse<PostQuery> postResponseObject3 = PostResponse
//                .<PostQuery>builder()
//                .response( postQuery )
//                .build();
        // /////////////////////////////////////////////////////////
    }




    public PostResponse<List<PostQuery>> findAllPostByUser(Integer userId) {
        Map<String, String> params = Map.of("userId", String.valueOf(userId));
        log.error(params);

        DtoPost<List<PostQuery>> dtoPost = this.postQueryRepository.findPostsByUserId(
                Integer.parseInt( params.get("userId") )
        );

        return responseMapper.dtoPostListToPostResponse( dtoPost );
    }


    public PostResponse<List<PostQuery>> findAllPostByFilteringResources(Map<String, String> params /*,int userId*/) {

        return this.responseMapper.dtoPostListToPostResponse(
                this.postQueryRepository.searchPostsByFilteringParams(
                        //Map.of("userId", String.valueOf(userId))
                        params
                )
        );

    }

}
