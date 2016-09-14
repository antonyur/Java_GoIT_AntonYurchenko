package module5;


import java.util.Date;

public class TripAdvisorAPI implements API{
    private Room[] rooms;
    int maxLength = 5;

    public TripAdvisorAPI() {
        rooms = new Room[maxLength];
        rooms[0] = new Room(6, 300, 2, new Date(2016, 10, 12), "Hotel1", "Kyiv");
        rooms[1] = new Room(2, 400, 3, new Date(2016, 8, 1), "Hotel2", "Kyiv");
        rooms[2] = new Room(3, 400, 3, new Date(2016, 11, 1), "Hotel2", "Kyiv");
        rooms[3] = new Room(7, 700, 3, new Date(2016, 4, 1), "Hotel3", "Dnipro");
        rooms[4] = new Room(8, 200, 1, new Date(2016, 10, 1), "Hotel4", "Dnipro");
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] tempRooms = new Room[maxLength];
        int count = 0;
        for (Room r : rooms)
        {
            if (r.getPrice() == price  && r.getPersons() == persons && r.getCityName().equals(city) && r.getHotelName().equals(hotel))
            {
                tempRooms[count] = r;
                count++;
            }
        }

        if (count > 0)
        {
            Room[] result = new Room[count];
            for(int i = 0; i < count; i++)
                result[i] = tempRooms[i];

            return result;
        }
        else
            return new Room[0];
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
