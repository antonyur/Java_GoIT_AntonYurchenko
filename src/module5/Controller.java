package module5;


public class Controller {
    private API apis[] = new API[3];
    private DAO dao = new DAOImpl2();

    public Controller() {
        BookingComAPI bookingComAPI = new BookingComAPI();
        GoogleAPI googleAPI = new GoogleAPI();
        TripAdvisorAPI tripAPI = new TripAdvisorAPI();
        apis[0] = bookingComAPI;
        apis[1] = googleAPI;
        apis[2] = tripAPI;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel){
        Room[] tempRooms = new Room[100];
        int count = 0;

        for (API api : apis)
        {
           for (Room r : api.findRooms(price, persons, city, hotel))
           {
               tempRooms[count] = r;
               count++;

               if (findById(r.getId()) == null) {
                    save(r);
               }
               else
                    update(r);
           }
        }

        Room[] result = new Room[count];
        for(int i = 0; i < count; i++)
            result[i] = tempRooms[i];

        return result;
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

    public Room[] check(API api1, API api2){
        Room[] rooms1 = api1.getAll();
        Room[] rooms2 = api2.getAll();
        Room[] tempRooms = new Room[100];
        int count = 0;
        for(Room r1 : rooms1) {
            for (Room r2 : rooms2) {
                if (r1.equals(r2)) {
                    tempRooms[count] = r1;
                    count++;
                }
            }
        }

        Room[] result = new  Room[count];
        for(int i=0; i< count; i++) {
            result[i] = tempRooms[i];
        }

        if (count > 0)
            return result;
        else
            return null;
    }
}
