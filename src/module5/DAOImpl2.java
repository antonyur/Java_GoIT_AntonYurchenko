package module5;


public class DAOImpl2 implements DAO{
    private int maxLength = 10;
    private Room[] rooms = new Room[maxLength];

    @Override
    public Room save(Room room) {
        int length = countLenght();
        if (length < maxLength)
            rooms[length] = room;

        return room;
    }

    @Override
    public boolean delete(Room room) {
        int length = countLenght();
        int deleteIndex = -1;
        int i = 0;
        Room r1 = rooms[0];
        while(r1 != null && i < length)
        {
            if (r1.getId() == room.getId()) {
                deleteIndex = i;
            }

            if (deleteIndex > -1 && i >= deleteIndex)
            {
                rooms[i] = i < (length-1) ? rooms[i+1] : null;
            }

            i++;
            r1 = i < length ? rooms[i] : null;
        }

        return deleteIndex > -1;
    }

    @Override
    public Room update(Room room) {
        int length = countLenght();
        Room r1 = rooms[0];
        int i = 0;
        while(r1 != null && i < length)
        {
            if (r1.getId() == room.getId()) {
                rooms[i] = room;
                break;
            }

            i++;
            r1 = i < length ? rooms[i] : null;
        }

        return room;
    }

    @Override
    public Room findById(long id) {
        for(Room r : rooms)
            if(r != null && r.getId() == id)
            {
                return r;
            }

        return null;
    }

    @Override
    public Room[] getAll() {
        int length = countLenght();
        Room[] allRooms = new Room[length];
        for(int i=0; i< length; i++)
            allRooms[i] = rooms[i];
        return allRooms;
    }

    private int countLenght()
    {
        int result = 0;
        for(int i=0; i < maxLength; i++) {
            if (rooms[i] == null) {
                result = i;
                break;
            }
        }

        return result;
    }

}
