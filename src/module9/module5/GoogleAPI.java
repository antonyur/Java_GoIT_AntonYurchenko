package module9.module5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleAPI implements API{
    private List<Room> rooms;

    public GoogleAPI() {
        rooms = new ArrayList<>();
        rooms.add(new Room(6, 300, 2, new Date(2016, 10, 12), "Hotel1", "Kyiv"));
        rooms.add(new Room(9, 400, 3, new Date(2016, 8, 1), "Hotel2", "Kyiv"));
        rooms.add(new Room(3, 400, 3, new Date(2016, 11, 1), "Hotel2", "Kyiv"));
        rooms.add(new Room(4, 700, 3, new Date(2016, 4, 1), "Hotel3", "Dnipro"));
        rooms.add(new Room(10, 200, 1, new Date(2016, 10, 1), "Hotel4", "Dnipro"));
    }

    @Override
    public List<Room> findRooms(int price, int persons, String city, String hotel) {
        List<Room> tempRooms = rooms.stream()
                .filter(r -> r.getPrice() == price  && r.getPersons() == persons && r.getCityName().equals(city) && r.getHotelName().equals(hotel))
                .collect(Collectors.toList());
        return tempRooms;
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }
}
