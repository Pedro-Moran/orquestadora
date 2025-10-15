package com.bbva.kusu.dto.users.entity;

import com.bbva.kusu.dto.users.util.PaginationDTO;
import java.io.Serializable;
import java.util.List;

public class NcustUserProfilePagination implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private List<NcustUserProfileEntity> ncustUserProfileEntities;
  
  private PaginationDTO pagination;
  
  public List<NcustUserProfileEntity> getNcustUserProfileEntities() {
    return this.ncustUserProfileEntities;
  }
  
  public void setNcustUserProfileEntities(List<NcustUserProfileEntity> ncustUserProfileEntities) {
    this.ncustUserProfileEntities = ncustUserProfileEntities;
  }
  
  public PaginationDTO getPagination() {
    return this.pagination;
  }
  
  public void setPaginationDTO(PaginationDTO pagination) {
    this.pagination = pagination;
  }
  
  @Override
public String toString() {
	return "NcustUserProfilePagination [ncustUserProfileEntities=" + ncustUserProfileEntities + ", pagination="
			+ pagination + "]";
}
}
