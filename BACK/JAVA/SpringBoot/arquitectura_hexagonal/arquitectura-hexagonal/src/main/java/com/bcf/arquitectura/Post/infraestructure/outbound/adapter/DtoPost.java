package com.bcf.arquitectura.Post.infraestructure.outbound.adapter;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DtoPost<T> {
    private T responseDto;
}


/*

public class PostDto<T> {
    private T responseDto;

    public PostDto(T responseDto) { this.responseDto = responseDto; }

    public T getResponseDto() {
        return responseDto;
    }
}

 */