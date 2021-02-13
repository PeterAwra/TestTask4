package com.stud.awra.testtask4.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Respond implements Serializable {

  @SerializedName("personal")
  @Expose
  private List<Person> person = null;
  private final static long serialVersionUID = 4936617872930625660L;

  public List<Person> getPerson() {
    return person;
  }

  public void setPerson(List<Person> person) {
    this.person = person;
  }
}

