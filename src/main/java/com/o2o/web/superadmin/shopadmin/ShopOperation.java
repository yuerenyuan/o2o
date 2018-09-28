package com.o2o.web.superadmin.shopadmin;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tanke on 2018/9/22.
 */
@Controller
@RequestMapping("/shopAdmin")
public class ShopOperation {
    @GetMapping("/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
    }
}
