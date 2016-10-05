package module7.module5;


import java.util.ArrayList;
import java.util.List;

public class DAOImpl2 implements DAO {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public Room save(Room room) {
        if (findById(room.getId()) == null)
            rooms.add(room);
        else
            update(room);

        return room;
    }

    @Override
    public boolean delete(Room room) {
        return rooms.remove(room);
    }

    @Override
    public Room update(Room room) {
        Room savedRoom = findById(room.getId());
        if (savedRoom != null)
            return rooms.set(rooms.indexOf(savedRoom), room);
        else
            return null;
    }

    @Override
    public Room findById(long id) {
        for (Room r : rooms)
            if (r != null && r.getId() == id) {
                return r;
            }

        return null;
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }
}
