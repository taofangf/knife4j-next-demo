/*
 * Copyright 2024-present the original author or authors.
 */

package io.github.knife4j.next.demo.controller;

import io.github.knife4j.next.demo.vo.UserModifyReqVO;
import io.github.knife4j.next.demo.vo.UserReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 *
 * @author Fangtao
 * @since 2025.10
 */
@Tag(name = "用户管理")
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysmgr/user")
public class UserController {

    @Operation(summary = "新增用户")
    @PostMapping("/create")
    public Boolean create(@Valid @RequestBody UserReqVO reqVO) {
        return true;
    }

    @Operation(summary = "修改用户")
    @PostMapping("/modify")
    public Boolean modify(@Valid @RequestBody UserModifyReqVO reqVO) {
        return true;
    }
}
