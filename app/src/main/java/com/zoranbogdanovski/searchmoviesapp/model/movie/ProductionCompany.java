package com.zoranbogdanovski.searchmoviesapp.model.movie;

import java.io.Serializable;

/**
 * Model class which represents production company.
 */
public class ProductionCompany implements Serializable {

  private String name;
  private int id;

  /**
   * Constructor.
   *
   * @param name  the name of the production company
   * @param id    the id of the production company
   */
  public ProductionCompany(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
