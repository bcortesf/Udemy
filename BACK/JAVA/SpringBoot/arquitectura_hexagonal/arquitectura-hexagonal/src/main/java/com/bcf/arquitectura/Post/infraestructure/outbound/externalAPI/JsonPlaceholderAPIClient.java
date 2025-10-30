package com.bcf.arquitectura.Post.infraestructure.outbound.externalAPI;

import com.bcf.arquitectura.Post.domain.modelEntitys.PostComand;
import com.bcf.arquitectura.Post.domain.modelEntitys.PostQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * https://jsonplaceholder.typicode.com/
 * https://jsonplaceholder.typicode.com/guide/
 */

@FeignClient(name = "${json-placeholder.client.name}", url = "${json-placeholder.url}")
public interface JsonPlaceholderAPIClient {
    /*  Listing all resources
     *  'https://jsonplaceholder.typicode.com/posts'
     */
    @GetMapping(path = "/posts")
    List<PostQuery> getAllPost();

    /*  Getting a resource
     *  'https://jsonplaceholder.typicode.com/posts/1'
     */
    @GetMapping(path = "/posts/{id}")
    PostQuery findPostById(@PathVariable Integer id);


    // /////////////////////////////////////////////////////////////////////
    ///            **USUARIO**
    /*  Get all posts by user. */
    @GetMapping(path = "/users/{id}/posts")
    List<PostQuery> findPostsByUserId(@PathVariable int id);


    /*  Filtering resources
     *  'https://jsonplaceholder.typicode.com/posts?userId=1'
     */
    @GetMapping(path = "/posts")
    List<PostQuery> searchPostsByFilteringParams(@RequestParam Map<String, String> params);
    // /////////////////////////////////////////////////////////////////////


    /*  Creating a resource
     *  'https://jsonplaceholder.typicode.com/posts'
     */
    @PostMapping(path = "posts")
    PostQuery create(@RequestBody PostComand request);
}
