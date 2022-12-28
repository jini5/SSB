package com.example.demoxenium.product.dto;

import com.example.demoxenium.util.Pagination;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> list = new ArrayList<>();
    private Pagination pagination;

    public ProductList(List<Product> list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }

    public List<Product> getList() {
        return list;
    }

    public Pagination getPagination() {
        return pagination;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "list=" + list +
                ", pagination=" + pagination +
                '}';
    }
}
