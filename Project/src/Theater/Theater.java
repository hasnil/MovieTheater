package Theater;

import java.util.ArrayList;

public class Theater {

	private int lastRoomId;
	private int numOfRooms;
	private ArrayList<Room> rooms;
	private String address;
	private String name;

	public Theater() {
		lastRoomId = 1;
		this.numOfRooms = 3;
		this.rooms = new ArrayList<Room>();
		for (int i = 0; i < numOfRooms; i++)
			addRoom();
	}
	
	private void addRoom() {
		Room r = new Room(lastRoomId, 20);
		getRooms().add(r);
		lastRoomId++;
	}
	
	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}
	
	public Room getRoomByNumber(int number) {
		for (Room room: rooms) {
			if(room.getRoomNumber() == number) {
				return room;
			}
		}
		
		return null;
	}
	
	public ArrayList<Room> getRooms() {
		return rooms;
	}
}
