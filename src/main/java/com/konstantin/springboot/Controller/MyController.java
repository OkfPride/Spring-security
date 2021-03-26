/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.springboot.Controller;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JavaDev
 */
@Controller
public class MyController {

    @GetMapping(path = "/")
    public String startPage() {
        return "/startPage"; 
    }
    @GetMapping(path = "/hr_page")
    public String hrInfo(){
        return "/view_for_HR_page";
    }
    @GetMapping(path = "/manager_page")
    public String managerOnfo(){
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        return "/manager_view";
    }
}
