package module9.module5;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private List<API> apis = new ArrayList<API>();
    private DAO dao = new DAOImpl2();

    public Controller() {
        BookingComAPI bookingComAPI = new BookingComAPI();
        GoogleAPI googleAPI = new GoogleAPI();
        TripAdvisorAPI tripAPI = new TripAdvisorAPI();
        apis.add(bookingComAPI);
        apis.add(googleAPI);
        apis.add(tripAPI);
    }

    public List<Room> requestRooms(int price, int persons, String city, String hotel){
        List<Room> tempRooms = new ArrayList<>();

        apis.stream().forEach(a -> {
            a.findRooms(price, persons, city, hotel).stream()
                    .forEach(r -> {
                        tempRooms.add(r);
                        if (findById(r.getId()) == null) {
                            save(r);
                        }
                        else
                            update(r);
                    });
        });
        return tempRooms;
    }

    private Room save(Room room)
    {
        return dao.save(room);
    }

    private Room update(Room room)
    {
        return dao.update(room);
    }

    private boolean delete(Room room)
    {
        return dao.delete(room);
    }

    private Room findById(long id)
    {
        return dao.findById(id);
    }

    public List<Room> check(API api1, API api2){
        List<Room> rooms1 = api1.getAll();
        List<Room> rooms2 = api2.getAll();
        List<Room> tempRooms = rooms1.stream()
                .filter(r -> rooms2.stream().anyMatch(r1 -> r1.equals(r)))
                .collect(Collectors.toList());

        return tempRooms;
    }
}
