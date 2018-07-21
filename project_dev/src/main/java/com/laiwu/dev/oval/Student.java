package com.laiwu.dev.oval;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.sf.oval.constraint.*;

@Setter
@Getter
@Data
public class Student {

  @NotNull(message = "学号不能为空")
  @NotEmpty(message = "学号不能为空")
  private Integer stuId;

  @NotNull(message = "姓名不能为空")
  @NotEmpty(message = "姓名不能为空")
  @MaxLength(value = 50, message = "姓名不能超过50个字符")
  @MinLength(value = 2, message = "姓名不能少于2个字符")
  private String stuName;

  @Max(value = 30, message = "年龄不得高于30岁")
  @Min(value = 20, message = "年龄不得低于20岁" )
  @NotNegative(message = "年龄不得为负数")
  private Integer stuAge;

  @Email(message = "邮箱地址不合法，请核查")
  private String stuEmail;

  @NotEqualToField(value = "loginPassword", message = "登录名与密码相同")
  @HasSubstring(value = "stu_", message = "登录名必须以stu_开头")
  private String loginName;

  @NotEqualToField(value = "loginName", message = "登录名与密码相同")
  private String loginPassword;

}
