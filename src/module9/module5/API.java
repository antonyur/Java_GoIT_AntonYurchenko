package module9.module5;


import java.util.ArrayList;
import java.util.List;

public interface API {
    List<Room> findRooms(int price, int persons, String city, String hotel);
    List<Room> getAll();
}
