package Theater;

import java.util.ArrayList;

public class Theater {

	private int lastRoomId;
	private ArrayList<Room> rooms;
	private String address;
	private String name;
	
	public Theater() {
		lastRoomId = 1;
		this.rooms = new ArrayList<Room>(); 
	}
	
	private void addRoom() {
		Room r = new Room(lastRoomId, 10, 10);
		getRooms().add(r);
		lastRoomId++;
	}
	
	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}
}
