package com.bcf.arquitectura.Post.infraestructure.outbound.adapter;

import com.bcf.arquitectura.Post.domain.modelEntitys.PostComand;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import com.bcf.arquitectura.Post.domain.repositorys_ports.PostCommandRepository;
import com.bcf.arquitectura.Post.infraestructure.outbound.externalAPI.JsonPlaceholderAPIClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Nuestros adaptadores serian clases concretas o implementaciones
 * de nuestras interfaces definidas en capa "Domain".repositorys
 */

/*                          ES UN ADAPTADOR                     */

@Repository
@RequiredArgsConstructor
public class PostComandRepositoryImpl implements PostCommandRepository {

    private final JsonPlaceholderAPIClient jsonPlaceholderAPIClient;

    @Override
    public Optional<PostQuery> createPost(PostComand postComand) {
        return Optional.ofNullable( jsonPlaceholderAPIClient.create(postComand) );
    }

    @Override
    public Optional<PostQuery> updatePost(PostComand postComand) {
        //Código a implementar
        return Optional.empty();
    }

    @Override
    public void deletePost(int id) {
        //Código a implementar
    }
}
