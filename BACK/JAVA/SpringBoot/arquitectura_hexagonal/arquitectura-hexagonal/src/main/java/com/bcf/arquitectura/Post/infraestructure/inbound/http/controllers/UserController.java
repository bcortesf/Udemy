package com.bcf.arquitectura.Post.infraestructure.inbound.http.controllers;

import com.bcf.arquitectura.Post.application.PostResponse;
import com.bcf.arquitectura.Post.application.usecaseFind.PostFindUseCase;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final PostFindUseCase postFindUseCase;

    // Obtener:  todos los posts por usuario.
    @GetMapping(path = "/{id}/posts")
    public ResponseEntity<PostResponse<List<PostQuery>>> findAllPostByUser(@PathVariable Integer id) {
        return ResponseEntity.ok(
                postFindUseCase.findAllPostByUser(id)
        );
    }

}
