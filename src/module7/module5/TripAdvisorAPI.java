package module7.module5;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TripAdvisorAPI implements API{
    private List<Room> rooms;

    public TripAdvisorAPI() {
        rooms = new ArrayList<>();
        rooms.add(new Room(6, 300, 2, new Date(2016, 10, 12), "Hotel1", "Kyiv"));
        rooms.add(new Room(2, 400, 3, new Date(2016, 8, 1), "Hotel2", "Kyiv"));
        rooms.add(new Room(3, 400, 3, new Date(2016, 11, 1), "Hotel2", "Kyiv"));
        rooms.add(new Room(7, 700, 3, new Date(2016, 4, 1), "Hotel3", "Dnipro"));
        rooms.add(new Room(8, 200, 1, new Date(2016, 10, 1), "Hotel4", "Dnipro"));
    }

    @Override
    public List<Room> findRooms(int price, int persons, String city, String hotel) {
        List<Room> tempRooms = new ArrayList<>();
        for (Room r : rooms)
        {
            if (r.getPrice() == price  && r.getPersons() == persons && r.getCityName().equals(city) && r.getHotelName().equals(hotel)){
                tempRooms.add(r);
            }
        }

        return tempRooms;
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }
}
