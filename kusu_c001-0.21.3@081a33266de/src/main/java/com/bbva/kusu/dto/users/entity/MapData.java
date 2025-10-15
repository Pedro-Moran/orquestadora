package com.bbva.kusu.dto.users.entity;

import java.util.Map;

public class MapData {
  private Map<String, Object> map;
  
  public MapData(Map<String, Object> map) {
    this.map = map;
  }
  
  public Map<String, Object> getMap() {
    return this.map;
  }
  
  public void setMap(Map<String, Object> map) {
    this.map = map;
  }

	@Override
	public String toString() {
		return "MapData [map=" + map + "]";
	}
  
}
