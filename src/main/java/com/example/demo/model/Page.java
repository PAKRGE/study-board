package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Page<T> {
    private final T list;
    private final int totalPage;
    @Setter
    private int currentPage;

    public Page(T list, int totalCount, int limit) {
        this.list = list;
        this.totalPage = calculateTotalPage(totalCount, limit);
    }

    private static int calculateTotalPage(double totalCount, int limit) {
        return (int) Math.ceil(totalCount / limit);
    }

    @Override
    public String toString() {
        return "Paging{" +
                "list=" + list +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                '}';
    }
}