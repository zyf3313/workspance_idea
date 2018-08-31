package com.jk.controller;

import com.jk.entity.User;
import com.jk.entity.WebSet;
import com.jk.service.WebSetService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/8/27 10:10
 * @描述
 */
@Controller
public class OpenWebSetController {

    @Autowired
    private WebSetService webSetService;

    /**
     * 查询当前用户的所有应用
     *
     * @param model
     * @return
     */
    @RequestMapping("queryWebSet")
    public String queryWebSet(Model model) {
        Subject sub = SecurityUtils.getSubject();
        User user = (User) sub.getPrincipal();
        List<WebSet> list = webSetService.queryWebSet(user.getUserId());
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setUrl("/deleteWebSet?id=" + list.get(i).getId());
        }
        model.addAttribute("list", list);
        return "webSet";
    }

    /**
     * 根据编号删除
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteWebSet")
    public String deleteWebSet(String id) {
        webSetService.deleteWebSet(id);
        return "redirect:queryWebSet";
    }

}
