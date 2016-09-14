package module5;

import java.util.Date;

public class Room {
    private long id;
    private int price;
    private int persons;
    private Date dateAvailableFrom;
    private String hotelName;
    private String cityName;

    public Room(long id, int price, int persons, Date dateAvailableFrom, String hotelName, String cityName) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotelName = hotelName;
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Room other = (Room) obj;
        if (other.id == id && other.price == price && other.persons == persons && other.cityName.equals(cityName))
            return true;

        return false;
    }

    @Override
    public int hashCode()
    {
        final int prime = 7;
        int result = 1;
        result = prime*result + price;
        result = prime*result + persons;
        result = prime*result + CountStringNumber(cityName);
        return result;
    }

    private int CountStringNumber(String str)
    {
        int res = 0;
        for (int i = 0; i< str.length(); i++)
            res += str.charAt(i)*i;
        return res;
    }

    @Override
    public String toString()
    {
       return String.format("{Room: id=%1$d, price=%2$d, persons=%3$d, hotelName=%4$s, cityName=%5$s", id, price, persons, hotelName, cityName);
    }

}
