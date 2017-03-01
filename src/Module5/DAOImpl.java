package Module5;

import java.util.Date;

import static Module5.UtilityClass.addRoom;

public class DAOImpl implements DAO {
    private Room[] rooms;

    private DAOImpl() {
        rooms = new Room[5];
        for (int i = 0; i < 5; i++) {
            rooms[i] = new Room(i+1, (i+1)*100, i+1, new Date(), "GreatHotel", "London");
        }
    }

    public static DAOImpl createDb() {
        return new DAOImpl();
    }

    @Override
    public Room save(Room room) {
        if (room == null) {
            return null;
        }
        rooms = addRoom(rooms);
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                return rooms[i] = room;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Room room) {
        for (int i = 0; i < rooms.length; i++) {
            if (room.equals(rooms[i])) {
                rooms[i] = null;
                rooms = refreshRooms(rooms);
                return true;
            }
        }
        return false;
    }

    @Override
    public Room update(Room room) {
        if (room == null) {
            return null;
        }
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null){
                if (room.getId() == rooms[i].getId()) {
                    return rooms[i] = room;
                }
            }
        }
        return null;
    }

    @Override
    public Room findById(long id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    @Override
    public Room[] getAll() {
        Room[] rooms = new Room[0];
        for (Room room : this.rooms) {
                rooms = addRoom(rooms);
                rooms[rooms.length - 1] = room;
        }
        return rooms;
    }

    private Room[] refreshRooms(Room[] rooms) {
        if (rooms == null) {
            return null;
        }
        Room [] newRooms = new Room[rooms.length-1];
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null){
               System.arraycopy(rooms, i+1, rooms, i, rooms.length-i-1);
               System.arraycopy(rooms, 0, newRooms, 0, rooms.length-1);
               return newRooms;
            }
        }
        return null;
    }
}
