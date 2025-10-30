package com.bcf.arquitectura.Post.domain.modelEntitys;

import lombok.Builder;
import lombok.Getter;

/**
 * REQUEST
 */
@Getter
@Builder
public class PostComand {
    private String title;
    private String body;
    private Long userId;
}
