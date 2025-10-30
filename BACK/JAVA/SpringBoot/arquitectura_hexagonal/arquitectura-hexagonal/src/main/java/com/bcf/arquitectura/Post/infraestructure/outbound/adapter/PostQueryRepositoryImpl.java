package com.bcf.arquitectura.Post.infraestructure.outbound.adapter;

import com.bcf.arquitectura.Post.domain.modelEntitys.PostComand;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import com.bcf.arquitectura.Post.domain.repositorys_ports.PostQueryRepository;
import com.bcf.arquitectura.Post.infraestructure.outbound.externalAPI.JsonPlaceholderAPIClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Nuestros adaptadores serian clases concretas o implementaciones
 * de nuestras interfaces definidas en capa "Domain".repositorys
 */

/*                          ES UN ADAPTADOR                     */

@Repository
@RequiredArgsConstructor
@Log4j2
public class PostQueryRepositoryImpl implements PostQueryRepository {

    private final JsonPlaceholderAPIClient jsonPlaceholderAPIClient;

    //implementando-este-de-momento
    @Override
    public DtoPost<List<PostQuery>> findAllPost() {
        log.error("consume API, todos los post");
        return DtoPost.<List<PostQuery>>builder()
                .responseDto(jsonPlaceholderAPIClient.getAllPost())
                .build();
    }

    @Override
    public DtoPost<Optional<PostQuery>> findById(int id) {
        //return Optional.ofNullable( jsonPlaceholderAPIClient.findPostById(id) )
        log.error("consume API, busca post por {id}");
        return DtoPost.<Optional<PostQuery>>builder()
                .responseDto(
                        Optional.ofNullable( jsonPlaceholderAPIClient.findPostById(id) )
                )
                .build();
    }

    @Override
    public DtoPost<List<PostQuery>> findPostsByUserId(int userId) {
        log.error("consume API, busca post por usuario {userId}");
        return DtoPost.<List<PostQuery>>builder()
                .responseDto( jsonPlaceholderAPIClient.findPostsByUserId(userId) )
                .build();
    }

    @Override
    public DtoPost<List<PostQuery>> searchPostsByFilteringParams(Map<String, String> params) {
        log.error("consume API, busca post por parametros de consulta: ?userId={userId}");
        return DtoPost.<List<PostQuery>>builder()
                .responseDto( jsonPlaceholderAPIClient.searchPostsByFilteringParams(params) )
                .build();
    }


    @Override
    public DtoPost<Optional<PostQuery>> creatingResource(PostComand postComand) {
        log.error("consume API, crear recurso post");
        return DtoPost.<Optional<PostQuery>>builder()
                .responseDto(
                        Optional.ofNullable( jsonPlaceholderAPIClient.create(postComand) )
                )
                .build();
    }

}
