package com.graphql.learn.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInput {
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
