package com.bcf.arquitectura.Post.domain.modelEntitys;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * RESPONSE
 */
@AllArgsConstructor
@Getter
public class PostQuery {
    private Long id;
    private String title;
    private String body;
    private Long userId;
}
