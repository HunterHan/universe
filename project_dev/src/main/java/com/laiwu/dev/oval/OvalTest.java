package com.laiwu.dev.oval;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.junit.Test;

import java.util.List;

public class OvalTest {

  @Test
  public void test() {
    Student stu = new Student();
    stu.setStuId(123);
    stu.setStuName("xiaoming");
    stu.setStuAge(-1);
    stu.setStuEmail("123123@qq.com");
    stu.setLoginName("");
    stu.setLoginPassword("pass");

    Validator validator = new Validator();
    final List<ConstraintViolation> validateRes = validator.validate(stu);
    if (!validateRes.isEmpty()) {
      for (ConstraintViolation violation : validateRes) {
        System.out.println(violation.getMessage());
      }
    } else {
      System.out.println("校验通过");
    }
  }
}
