package com.egg;

public class Building {
	
	private int roomID;
	private int floorNo;
	private String buildingName;
	
	public Building(int floorNo, String buildingName) {
		super();
		this.floorNo = floorNo;
		this.buildingName = buildingName;
	}
	
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	


}
