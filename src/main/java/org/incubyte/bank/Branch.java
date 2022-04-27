package org.incubyte.bank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Branch {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String city;
  private String state;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }
}
