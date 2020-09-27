package com.offcn.demo.controller;

import com.offcn.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class FirstThymeleafController {

    @RequestMapping("/first")
    public String indexPage(Model model){
        String message = "hello Thymeleaf";
        model.addAttribute("message",message);
        return "index";
    }

    @GetMapping("/showUser")
    public String showUser(Model model){
        String message = "hello Thymeleaf";
        User u = new User();
        u.setId(1);
        u.setName("优就业");
        u.setAge(18);

        Map<String,Object> map=new HashMap<>();
        map.put("src1","1.jpg");
        model.addAttribute("message", message);
        model.addAttribute("user", u);
        model.addAttribute("src", map);
        return "show";
    }

    @GetMapping("showList")
    public String showList(Model model){
        List<User> list = new ArrayList<>();
        list.add(new User(){{setId(1);setName("小白");setAge(23);}});
        list.add(new User(){{setId(2);setName("小白2");setAge(22);}});
        list.add(new User(){{setId(3);setName("小白3");setAge(24);}});
        model.addAttribute("userList",list);
        return "showList";
    }

    @GetMapping("/showString")
    public String  showString(Model model){
        String username = "小黑";
        model.addAttribute("username",username);
        return "showString";
    }

    @GetMapping("/showIf")
    public String showIf(Model model){
        model.addAttribute("flag","yes");
        model.addAttribute("users","admin");
        model.addAttribute("manager","manager");
        return "showIf";
    }

    @GetMapping("/showHead")
    public String showHead(Model model){
        return "showHead";
    }

    @GetMapping("/showMethod")
    public String showMethod(Model model) {
        //日期时间
        Date date = new Date();
        model.addAttribute("date", date);
        //小数的金额
        double price=128.5678D;
        model.addAttribute("price", price);
        //定义大文本数据
        String str="Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。\r\n" +
                "Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。\r\n" +
                "Thymeleaf也从一开始就设计了Web标准 - 特别是HTML5 - 允许您创建完全验证的模板，如果这是您需要的\r\n" ;
        model.addAttribute("strText", str);
        //定义字符串
        String str2="JAVA-offcn";
        model.addAttribute("str2", str2);
        return "showMethod";
    }

}
