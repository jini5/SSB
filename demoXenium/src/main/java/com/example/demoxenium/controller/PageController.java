package com.example.demoxenium.controller;

import com.example.demoxenium.member.dto.Member;
import com.example.demoxenium.member.service.MemberService;
import com.example.demoxenium.product.dto.ProductList;
import com.example.demoxenium.product.service.ProductService;
import com.example.demoxenium.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    ProductService ps;
    @Autowired
    MemberService ms;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/signupPage")
    public String signupPage() {
        return "user/signup";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/productList")
    public String productList(SearchDto params, Model model, HttpSession session) {
        List<HashMap<String, String>> par = new ArrayList<HashMap<String, String>>();
        ProductList product = ps.findAll(params);
        model.addAttribute("product", product);
        String key=params.getKeyword();
        if (session.getAttribute("id") != null) {
            List<HashMap<String, Object>> cList = ms.selectUserCart(((Member)session.getAttribute("id")).getId());
            model.addAttribute("cartList", cList);
            for (Map<String, Object> component : cList) {
                HashMap<String, String> comMap = new HashMap<String, String>();
                comMap.put("id", String.valueOf(component.get("pid")));
                comMap.put("amount", String.valueOf(component.get("amount")));
                comMap.put("name", String.valueOf(component.get("productName")));
                comMap.put("price", String.valueOf(component.get("price")));
                par.add(comMap);
            }
        }

        model.addAttribute("paramText", par);
        if(key!=null){
            model.addAttribute("keyword", params.getKeyword());
        }

        return "productlist";
    }

    @GetMapping("/orderList")
    public String orderList(HttpSession session,Model m) {
        List<Map<String, Object>> param = new ArrayList<Map<String, Object>>();
        String userid = null;
        Map<String, String> accParam = new HashMap<>();
        if (session.getAttribute("id") != null) {

            userid=((Member) session.getAttribute("id")).getId();
        }
        List<HashMap<String, Object>> cList = ms.selectOrderBook(userid);
        m.addAttribute("orderList", cList);

        return "orderhistory";
    }

}
