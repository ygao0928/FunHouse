package wechat.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wechat.mbg.entity.AdminUser;
import wechat.mbg.service.AdminUserService;
import wechat.utils.GlobalResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin Gao
 * @version 1.0.0
 * @ClassName AdminLoginController.java
 * @date 2020/11/23 23:25
 * @Description
 * @Content:
 */
@Api("后台管理登录")
@RestController
@CrossOrigin
@RequestMapping("/admin/auth")
public class AdminLoginController {
    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/login")
    public GlobalResult AdminLogin(@RequestParam("userName") String userName, @RequestParam("pass") String pass) {
        AdminUser adminUser = adminUserService.checkLogin(userName, pass);
        return GlobalResult.ok(adminUser);
    }

    @CrossOrigin
    @GetMapping(value = "/logintest")
    @ResponseBody
    public Map login() {
        HashMap<String, Object> response = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("token", 1);
        response.put("code", 20000);
        response.put("msg", "登录成功");
        response.put("data", responseData);
        return response;
    }

    @GetMapping(value = "/user/info")
    public Map info() {
        HashMap<String, Object> responseInfo = new HashMap<>();
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("roles", "admin");
        responseData.put("name", "Super admin");
        responseData.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        responseInfo.put("code", 20000);
        responseInfo.put("msg", "登录成功");
        responseInfo.put("data", responseData);
        return responseInfo;
    }

}
