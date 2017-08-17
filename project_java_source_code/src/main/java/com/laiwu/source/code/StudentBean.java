package com.laiwu.source.code;

public class StudentBean {

  private Integer id;

  private String name;

  private String sex;

  public StudentBean(Integer id, String name, String sex) {
    this.id = id;
    this.name = name;
    this.sex = sex;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    StudentBean that = (StudentBean) o;

    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (sex != null ? sex.hashCode() : 0);
    return result;
  }

  @Override public String toString() {
    return "StudentBean{" + "id=" + id + ", name='" + name + '\'' + ", sex='" + sex + '\'' + '}';
  }
}
