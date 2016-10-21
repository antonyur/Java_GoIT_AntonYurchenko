package module9.module5;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        List<Room> r1 = ctrl.requestRooms(400, 3, "Kyiv", "Hotel2");
        List<Room> r2 = ctrl.requestRooms(500, 3, "Kyiv", "Hotel2");
        List<Room> r3 = ctrl.requestRooms(700, 3, "Dnipro", "Hotel3");
        API api1 = new GoogleAPI();
        API api2 = new BookingComAPI();
        API api3 = new TripAdvisorAPI();
        List<Room> rooms = ctrl.check(api1, api2);
        List<Room> rooms1 = ctrl.check(api1, api3);
        List<Room> rooms2 = ctrl.check(api2, api3);
    }
}
