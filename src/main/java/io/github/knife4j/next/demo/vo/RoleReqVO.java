/*
 * Copyright 2024-present the original author or authors.
 */

package io.github.knife4j.next.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.Range;

/**
 * 角色VO
 *
 * @author Fangtao
 * @since 2026.10
 */
@Getter
@Setter
@ToString
@Schema(description = "角色VO")
public class RoleReqVO {
    @Schema(description = "角色ID", hidden = true)
    private String roleId;

    @Schema(description = "租户ID")
    private String tenantId;

    @Schema(description = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 128, message = "角色名称不能超过128个字符")
    @Pattern(regexp = "^[\\p{IsHan}A-Za-z0-9]+$", message = "角色名称不能包含特殊字符")
    private String roleName;

    @Schema(description = "角色编码")
    @Size(max = 64, message = "角色名称不能超过64个字符")
    private String roleCode;

    @Schema(description = "角色级别（1级最高，5级最低）", defaultValue = "5")
    @NotNull(message = "角色级别不能为空")
    @Range(min = 1, max = 5, message = "角色级别必须在1-5之间")
    private Integer roleLevel;

    @Schema(description = "角色状态（1：启用；0：未启用）", defaultValue = "0")
    @NotNull(message = "角色状态不能为空")
    @Range(min = 0, max = 1, message = "状态值必须在0-1之间")
    private Integer roleStatus;

    @Schema(description = "角色类型（1：xxx、2：xxx、3：xxx）", defaultValue = "1")
    @NotNull(message = "角色类型不能为空")
    @Range(min = 1, max = 3, message = "角色类型必须在1-3之间")
    private Integer roleType;

    @Schema(description = "角色描述")
    @Size(max = 256, message = "角色描述不能超过256个字符")
    private String roleDesc;
}
