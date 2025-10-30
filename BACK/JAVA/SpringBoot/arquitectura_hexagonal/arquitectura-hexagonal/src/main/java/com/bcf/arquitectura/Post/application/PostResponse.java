package com.bcf.arquitectura.Post.application;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostResponse<T> {
    private T response;
}


/*

public class PostResponse<T> {
    private T response;

    public PostResponse(T response) { this.response = response; }

    public T getResponse() {
        return response;
    }
}

 */