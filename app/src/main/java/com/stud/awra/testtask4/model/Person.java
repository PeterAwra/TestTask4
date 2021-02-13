package com.stud.awra.testtask4.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Person implements Serializable {
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("surname")
  @Expose
  private String surname;
  @SerializedName("age")
  @Expose
  private String age;
  @SerializedName("sex")
  @Expose
  private String sex;
  @SerializedName("occupation")
  @Expose
  private String occupation;
  private final static long serialVersionUID = -6307735007800493257L;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }
}