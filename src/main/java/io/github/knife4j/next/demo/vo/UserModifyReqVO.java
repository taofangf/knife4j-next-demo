/*
 * Copyright 2024-present the original author or authors.
 */

package io.github.knife4j.next.demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.validator.constraints.Range;

/**
 * 用户修改VO
 *
 * @author Fangtao
 * @since 2026.10
 */
@Getter
@Setter
@ToString
@Schema(description = "新增用户VO")
public class UserModifyReqVO {
    @Schema(description = "用户ID")
    @NotBlank(message = "用户ID不能为空")
    private String userId;

    @Schema(description = "用户名，唯一")
    @NotBlank(message = "用户名不能为空")
    @Size(max = 128, message = "用户名不能超过128个字符")
    @Pattern(regexp = "^\\w+$", message = "用户名不能包含特殊字符和中文")
    private String username;

    @Schema(description = "昵称")
    @Size(max = 128, message = "昵称不能超过128个字符")
    private String nickname;

    @Schema(description = "邮箱")
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @Schema(description = "手机号码")
    @Pattern(regexp = "^(1[3-9]\\d{9})?$", message = "请输入有效的手机号码")
    private String phone;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "用户级别（1级最高，5级最低）", defaultValue = "5")
    @NotNull(message = "用户级别不能为空")
    @Range(min = 1, max = 5, message = "用户级别必须在1-5之间")
    private Integer userLevel;
}
