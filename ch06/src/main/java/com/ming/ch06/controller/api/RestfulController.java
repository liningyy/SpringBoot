package com.ming.ch06.controller.api;

import com.ming.ch06.controller.BaseController;
import com.ming.ch06.entity.Card;
import com.ming.ch06.entity.User;
import com.ming.ch06.vo.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author 贺春明
 * @date 2023/2/17
 */

@RestController
@RequestMapping("/api/v1")
@Tag(name = "RestfulController", description = "用户API文档")
public class RestfulController extends BaseController {

    @GetMapping("/users")
    @Operation(summary = "用户列表查询", description = "查询所有用户信息", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "响应成功"),
            @ApiResponse(responseCode = "500", description = "请求无效")
    })
    public ResultVo<List<User>> listUser() {
        List<User> userList = Arrays.asList(new User(1001, "user1", 20, new Card("23454123454321")),
                new User(1002, "user2", 21, new Card("1212421423123323")),
                new User(1003, "user3", 22, new Card("3215765434567633")));
        return success(userList);
    }

    /**
     * @Paramter注解的in属性指定参数是从什么地方传进来的
     * @param uid
     * @return
     */
    @GetMapping("/user")
    @Operation(summary = "aaa", description = "根据ID查询用户明细", method = "GET")
    @Parameters({
            @Parameter(name = "uid", description = "用户唯一标识",required = true,in = ParameterIn.PATH)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "响应成功"),
            @ApiResponse(responseCode = "500", description = "请求无效")
    })
    public ResultVo<User> getUser(Integer uid) {
        User user = new User(uid, "user2", 21, new Card("1212421423123323"));
        return success(user);
    }

}
