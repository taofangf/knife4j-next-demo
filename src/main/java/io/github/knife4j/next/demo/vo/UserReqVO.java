/*
 * Copyright 2024-present the original author or authors.
 */

package io.github.knife4j.next.demo.vo;

import java.time.LocalDateTime;

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
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户请求VO
 *
 * @author Fangtao
 * @since 2026.10
 */
@Getter
@Setter
@ToString
@Schema(description = "新增用户VO")
public class UserReqVO {
    @Schema(description = "用户ID", hidden = true)
    private String userId;

    @Schema(description = "租户ID", hidden = true)
    private String tenantId;

    @Schema(description = "用户名，唯一")
    @NotBlank(message = "用户名不能为空")
    @Size(max = 128, message = "用户名不能超过128个字符")
    @Pattern(regexp = "^\\w+$", message = "用户名不能包含特殊字符和中文")
    private String username;

    @Schema(description = "昵称")
    @Size(max = 128, message = "昵称不能超过128个字符")
    private String nickname;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Schema(description = "密码盐值", hidden = true)
    private String salt;

    @Schema(description = "邮箱")
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @Schema(description = "手机号码")
    @Pattern(regexp = "^(1[3-9]\\d{9})?$", message = "请输入有效的手机号码")
    private String phone;

    @Schema(description = "用户头像")
    private String avatar;

    @Schema(description = "生效时间")
    @NotNull(message = "生效时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime effectiveAt;

    @Schema(description = "失效时间")
    @NotNull(message = "失效时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiredAt;

    @Schema(description = "用户级别（1级最高，5级最低）", defaultValue = "5")
    @NotNull(message = "用户级别不能为空")
    @Range(min = 1, max = 5, message = "用户级别必须在1-5之间")
    private Integer userLevel;

    @Schema(description = "需要修改密码（1：是；0：否），默认值：0", defaultValue = "1", hidden = true)
    private Integer passwordUpdate;
}
