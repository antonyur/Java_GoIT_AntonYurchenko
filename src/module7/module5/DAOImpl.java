package module7.module5;

import java.util.ArrayList;
import java.util.List;

public class DAOImpl implements DAO{
    @Override
    public Room save(Room room) {
        System.out.println("Save room:" + room);
        return null;
    }

    @Override
    public boolean delete(Room room) {
        System.out.println("Delete room:" + room);
        return false;
    }

    @Override
    public Room update(Room room) {
        System.out.println("Update room:" + room);
        return null;
    }

    @Override
    public List<Room> getAll() {
        return new ArrayList<>();
    }

    @Override
    public Room findById(long id) {
        System.out.println("findById room:" + id);
        return null;
    }
}
