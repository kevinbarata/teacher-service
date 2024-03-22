package com.project.resto.controller;

import com.project.resto.dto.AdminDto;
import com.project.resto.dto.AssetDto;
import com.project.resto.service.AdminService;
import com.project.resto.service.AssetService;
import com.project.resto.util.ErrorCodeEnum;
import com.project.resto.util.ResponseEntityBuilder;
import com.project.resto.util.ResponseEntityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto register(@RequestBody AdminDto adminDto) {
        logger.info("admin.register parameter = " + adminDto);
        if (adminDto != null){
            ResponseEntityDto register = adminService.register(adminDto);
            return register;
        }else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto get(@RequestBody AdminDto adminDto) {
        logger.info("admin.get parameter = " + adminDto);
        if (adminDto != null){
            List<AdminDto> list = adminService.get(adminDto);
            return ResponseEntityBuilder.buildNormalResponse(list);
        }else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntityDto update(@RequestBody AdminDto adminDto) {
        logger.info("admin.update parameter = " + adminDto);
        if (adminDto != null){
            int update = adminService.update(adminDto);
            return ResponseEntityBuilder.buildNormalResponse(update);
        }else {
            return ResponseEntityBuilder.buildErrorResponse(ErrorCodeEnum.PARAM_VALUE_ERROR);
        }
    }

}