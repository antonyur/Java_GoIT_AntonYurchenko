package module5;


public class Main {
    public static void main(String[] args) {
        Controller ctrl = new Controller();
        ctrl.requestRooms(400, 3, "Kyiv", "Hotel2");
        ctrl.requestRooms(500, 3, "Kyiv", "Hotel2");
        ctrl.requestRooms(700, 5, "Dnipro", "Hotel3");
        API api1 = new GoogleAPI();
        API api2 = new BookingComAPI();
        API api3 = new TripAdvisorAPI();
        Room[] rooms = ctrl.check(api1, api2);
        Room[] rooms1 = ctrl.check(api1, api3);
        Room[] rooms2 = ctrl.check(api2, api3);
    }
}
