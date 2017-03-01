package Module5;

import static Module5.UtilityClass.addRoom;

public class Controller {
    private API [] api = new API[3];

    public Controller(API api1, API api2, API api3) {
        this.api[0] = api1;
        this.api[1] = api2;
        this.api[2] = api3;
    }

    Room[] requstRooms(int price, int persons, String city, String hotel){
        Room [] rooms = new Room[0];
        for (int i = 0; i < api.length; i++) {
            Room [] foundRooms = api[i].findRooms(price,persons,city,hotel);
            if (foundRooms.length > 0){
                rooms = addCountRooms(rooms, foundRooms);
                System.arraycopy(foundRooms,0, rooms,rooms.length-foundRooms.length, foundRooms.length);
            }
        }
        return rooms;
    }

    Room[] check(API api1, API api2) {
        Room[] roomsResult = new Room[0];
        APIImpl apiImpl1 = (APIImpl) api1;
        APIImpl apiImpl2 = (APIImpl) api2;
        for (int i = 0; i < apiImpl1.getDao().getAll().length; i++) {
            for (int j = 0; j < apiImpl2.getDao().getAll().length; j++) {
                if (apiImpl1.getDao().getAll()[i].equals(apiImpl2.getDao().getAll()[j])) {
                    if (!(duplicateRoom(roomsResult, apiImpl1.getDao().getAll()[i]))) {
                        roomsResult = addRoom(roomsResult);
                        roomsResult[roomsResult.length-1] = apiImpl1.getDao().getAll()[i];
                    }
                }
            }
        }
        return roomsResult;
    }

    private boolean duplicateRoom(Room [] roomsResult, Room room){
        if (roomsResult.length == 0) {
           return false;
        }
        for (Room roomFound : roomsResult) {
            if (room.equals(roomFound)) return true; }
         return false;
    }

    private Room[] addCountRooms(Room[] oldRooms, Room[] foundRooms) {
        Room [] rooms = new Room[oldRooms.length + foundRooms.length];
        System.arraycopy(oldRooms, 0, rooms, 0, oldRooms.length);
        return rooms;
    }
}
