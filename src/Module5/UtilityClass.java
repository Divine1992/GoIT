package Module5;

public final class UtilityClass {

    public static Room[] addRoom(Room[] rooms) {
        if (rooms == null) {
            return null;
        }
        Room [] newRooms = new Room[rooms.length+1];
        System.arraycopy(rooms, 0, newRooms,0, rooms.length);
        return newRooms;
    }
}
