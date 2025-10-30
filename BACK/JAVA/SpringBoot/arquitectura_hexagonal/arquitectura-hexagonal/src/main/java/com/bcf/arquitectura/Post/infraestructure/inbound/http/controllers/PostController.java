package com.bcf.arquitectura.Post.infraestructure.inbound.http.controllers;

import com.bcf.arquitectura.Post.application.PostResponse;
import com.bcf.arquitectura.Post.application.usecaseCreate.PostCreateUseCase;
import com.bcf.arquitectura.Post.application.usecaseFind.PostFindUseCase;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostComand;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
@Log4j2
public class PostController {

    private final PostFindUseCase postFindUseCase;
    private final PostCreateUseCase postCreateUseCase;

    /*ENDPOINTS, UNIDOS*/
    /*
    *  - Todos los post
    *  - Filtrar(parámetros-de-consulta.): todas las publicaciones que pertenecen al primer usuario.
          https://jsonplaceholder.typicode.com/posts?userId=1
    * */

//    @GetMapping
//    public ResponseEntity<PostResponse<List<PostQuery>>> findAllPost(
//            @RequestParam(value = "userId", required = false) String userId
//    ) {
//        if (userId != null) {
//            return ResponseEntity.ok(
//                    postFindUseCase.findAllPostByFilteringResources( Map.of("userId", userId) )
//            );
//        }
//
//        return ResponseEntity.ok(
//                postFindUseCase.findAllPost()
//        );
//    }

    /*
        1.Se recibe cualquier número de parámetros de consulta en params.
        2.Si params contiene "userId", se llama a findAllPostByFilteringResources(params), lo que significa que se usará el filtrado.
        3.Si params está vacío o no tiene "userId", se llama a findAllPost(), devolviendo todos los posts.
     */
    @GetMapping
    public ResponseEntity<PostResponse<List<PostQuery>>> findAllPost(@RequestParam Map<String, String> params) {
        if (params.containsKey("userId")) {
            return ResponseEntity.ok(postFindUseCase.findAllPostByFilteringResources(params));
        }
        return ResponseEntity.ok(postFindUseCase.findAllPost());
    }


/*ENDPOINTS, POR SEPARADO*/
/*
    @GetMapping(path = "/all")
    public ResponseEntity<PostResponse<List<PostQuery>>> findAllPost() {
        return ResponseEntity.ok(
                postFindUseCase.findAllPost()
        );
    }

    @GetMapping
    public ResponseEntity<PostResponse<List<PostQuery>>> findAllPostByFilteringResources(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(
                postFindUseCase.findAllPostByFilteringResources(params)
        );
    }
 */


    /*------------------------------------------------------------------------------------------
      ------------------------------------------------------------------------------------------
      ------------------------------------------------------------------------------------------
     */

    @GetMapping(path = "/{postId}")
    public ResponseEntity<PostResponse<PostQuery>> findById(@PathVariable int postId) {
        return ResponseEntity.ok(
                postFindUseCase.findById(postId)
        );
    }


    @PostMapping
    public ResponseEntity<PostResponse<PostQuery>> creatingResource(@RequestBody PostComand postComand) throws JsonProcessingException {

        log.info( "Creando el recurso: {}", (new ObjectMapper().writeValueAsString(postComand)) );
        return ResponseEntity.ok(
                postCreateUseCase.creatingResource(postComand)
        );
    }

}
