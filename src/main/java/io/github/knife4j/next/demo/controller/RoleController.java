/*
 * Copyright 2024-present the original author or authors.
 */

package io.github.knife4j.next.demo.controller;

import io.github.knife4j.next.demo.vo.RoleReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色管理
 *
 * @author Fangtao
 * @since 2026.10
 */
@Tag(name = "角色管理")
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysmgr/role")
public class RoleController {
    @Operation(summary = "新增角色")
    @PostMapping("/create")
    public Boolean create(@Valid @RequestBody RoleReqVO reqVO) {
        return true;
    }

    @Operation(summary = "修改角色")
    @Parameter(name = "roleId", description = "角色ID")
    @PostMapping("/modify")
    public Boolean modify(@RequestParam(required = false) @NotBlank(message = "roleId不能为空") String roleId,
            @Valid @RequestBody RoleReqVO reqVO) {
        return true;
    }
}
