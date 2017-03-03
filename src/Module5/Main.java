package Module5;

import java.util.Arrays;
import java.util.Date;

public class Main {

    private static BookingComAPI bookingAPI;
    private static GoogleAPI googleAPI;
    private static TripAdvisorAPI tripVisorAPI;

    public static void main(String[] args) {
        createApi();
        Room room = new Room(10, 2000, 2, new Date(), "Capital", "Kiev");
        activityAPI(bookingAPI, room);
        Controller controller = new Controller(bookingAPI, googleAPI, tripVisorAPI);
        acivityController(controller, bookingAPI, googleAPI);
    }

    static void createApi(){
        bookingAPI = new BookingComAPI();
        googleAPI = new GoogleAPI();
        tripVisorAPI = new TripAdvisorAPI();
    }

    static void activityAPI(API api, Room room){
        BookingComAPI api1Impl = (BookingComAPI) api;
        Room roomForDelete = new Room(5, 500, 5, new Date(), "GreatHotel", "London");
        System.out.println("Saved "+api1Impl.getDao().save(room));
        System.out.println("Updated "+api1Impl.getDao().update(room));
        System.out.println("Found "+api1Impl.getDao().findById(room.getId()));
        System.out.println("Delete "+api1Impl.getDao().delete(roomForDelete)+ " after delete your DAO "+ Arrays.toString(api1Impl.getDao().getAll()));
        System.out.println("All rooms after activity "+Arrays.toString(api1Impl.getDao().getAll()));
    }

    static void acivityController(Controller controller, API api1, API api2){
        System.out.println("All rooms in BookingAPI "+Arrays.toString(bookingAPI.getDao().getAll()));
        System.out.println("request room to API "+Arrays.toString(controller.requstRooms(100, 1, "London", "GreatHotel")));
        System.out.println("check rooms in 2 different API "+Arrays.toString(controller.check(api1, api2)));
        System.out.println("request room to API "+Arrays.toString(controller.requstRooms(2000, 2, "Kiev", "Capital")));
    }
}
