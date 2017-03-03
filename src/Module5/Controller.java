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

    Room[] check(API api1, API api2)  {
        Room[] roomsResult = new Room[0];
        DAOImpl [] daoImpl = getImplAPI(api1,api2);
        for (int i = 0; i < daoImpl[0].getAll().length; i++) {
            for (int j = 0; j < daoImpl[1].getAll().length; j++) {
                if (daoImpl[0].getAll()[i].equals(daoImpl[1].getAll()[j])) {
                    if (!(duplicateRoom(roomsResult, daoImpl[0].getAll()[i]))) {
                        roomsResult = addRoom(roomsResult);
                        roomsResult[roomsResult.length - 1] = daoImpl[0].getAll()[i];
                    }
                }
            }
        }
        return roomsResult;
    }

    private DAOImpl[] getImplAPI(API api1, API api2)  {
        DAOImpl [] resultArray = new DAOImpl[2];
        if (api1 instanceof BookingComAPI) {
            BookingComAPI apiImpl1 = (BookingComAPI) api1;
            resultArray[0] = (DAOImpl) apiImpl1.getDao();
        } else if (api1 instanceof TripAdvisorAPI){
            TripAdvisorAPI apiIml1 = (TripAdvisorAPI) api1;
            resultArray[0] = (DAOImpl) apiIml1.getDao();
        } else {
            GoogleAPI apiImpl1 = (GoogleAPI) api1;
            resultArray[0] = (DAOImpl) apiImpl1.getDao();
        }
        if (api2 instanceof BookingComAPI) {
            BookingComAPI apiImpl2 = (BookingComAPI) api2;
            resultArray[1] = (DAOImpl) apiImpl2.getDao();
        } else if (api2 instanceof TripAdvisorAPI){
            TripAdvisorAPI apiIml2 = (TripAdvisorAPI) api1;
            resultArray[1] = (DAOImpl) apiIml2.getDao();
        } else {
            GoogleAPI apiImpl2 = (GoogleAPI) api2;
            resultArray[1] = (DAOImpl) apiImpl2.getDao();
        }
        return resultArray;
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
