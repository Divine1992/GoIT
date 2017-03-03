package Module5;

import static Module5.DAOImpl.createDb;
import static Module5.UtilityClass.addRoom;

public class BookingComAPI implements API{
    private DAO dao;

    public BookingComAPI() { dao = createDb();
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room [] rooms = new Room[0];
        for (Room room : dao.getAll()) {
            if (room.getPrice() == price && room.getPersons() == persons && room.getCityName().equals(city) && room.getHotelName().equals(hotel)) {
                rooms = addRoom(rooms);
                rooms[rooms.length-1] = room;
            }
        }
        return rooms;
    }

    public DAO getDao() {
        return dao;
    }
}
