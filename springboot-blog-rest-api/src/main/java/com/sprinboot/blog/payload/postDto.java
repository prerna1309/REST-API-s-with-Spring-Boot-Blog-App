package com.sprinboot.blog.payload;

import lombok.Data;

@Data
public class postDto {
    private long id;
    private String title;
    private String description;
    private String content;
}
