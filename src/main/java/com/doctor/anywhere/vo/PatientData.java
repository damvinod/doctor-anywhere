package com.doctor.anywhere.vo;

import java.util.LinkedList;
import java.util.List;

public class PatientData {

  private Integer current;
  private Integer rowCount;
  private Long total;
  private List<Rows> rows = new LinkedList<>();

  public Integer getCurrent() {
    return current;
  }
  public Integer getRowCount() {
    return rowCount;
  }
  public List<Rows> getRows() {
    return rows;
  }
  public Long getTotal() {
    return total;
  }
  public void setCurrent(Integer current) {
    this.current = current;
  }
  public void setRowCount(Integer rowCount) {
    this.rowCount = rowCount;
  }
  public void setRows(List<Rows> rows) {
    this.rows = rows;
  }
  public void setTotal(Long total) {
    this.total = total;
  }



}
