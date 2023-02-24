package com.ming.city.controller;

import com.ming.city.pojo.CityInfo;
import com.ming.city.service.CityService;
import com.ming.city.vo.ResultVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 贺春明
 * @date 2023/2/16
 */

@RestController
@RequiredArgsConstructor
@Tag(name = "CityController",description = "城市API文档")
public class CityController extends BaseController{

    private final CityService cityService;

    @GetMapping("/get")
    @Operation(summary="用户列表设置",description = "分页城市信息数据",method = "GET")
    @Parameters({
            @Parameter(name="pageNum",description = "页码",required = true,in = ParameterIn.QUERY),
            @Parameter(name="pageSize",description = "显示条数",required = true,in = ParameterIn.QUERY)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "响应成功"),
            @ApiResponse(responseCode = "500",description = "响应失败")
    })
    public ResultVo<CityInfo> listCity(int pageNum, int pageSize){
        return success(cityService.listCity(pageNum,pageSize));
    }
}
