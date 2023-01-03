package com.cafe.admin.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/customerList")
    public String customerList() {
        return "customerlist";
    }

    @GetMapping("/categoryList")
    public String categoryList() {
        return "categorylist";
    }

    @GetMapping("/productList")
    public String productList() {
        return "productlist";
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "addproduct";
    }

    @GetMapping("/selltimeList")
    public String selltimeList() {
        return "selltimelist";
    }

    @GetMapping("/addSelltime")
    public String addSelltime() {
        return "addselltime";
    }

    @GetMapping("/orderList")
    public String orderList() {
        return "orderlist";
    }

}
