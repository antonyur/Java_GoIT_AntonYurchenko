package module9.module5;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Room> result = rooms.stream()
                .filter(r -> r != null && r.getId() == id)
                .findFirst();
        if (!result.isPresent())
            return null;
        else
            return result.get();
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }
}
