package com.entertainment;
import java.util.Objects;

//Be consistent with equals. natural order must used the same properties that is used in equals
public class Television implements Comparable<Television> {

    //instance variables
    private String brand;
    private int volume;

    //Television has a tuner
    private Tuner tuner = new Tuner();

    //constructors
    public Television() {
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    //business methods
    public int getCurrentChannel() {
        return tuner.getChannel(); //delegate to contained tuner object
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel); //delegate to contained Tuner object
    }

    //accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //to be consitant with equals, you must use same properties for natural order than
    //use in equals

    //comparator method
    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {
            result = Integer.compare(this.getVolume(), other.getVolume());
        }

        return result;
    }

    @Override
    public int hashCode() {
        //poorly written hash function because it yields has collisions
        //Hash collision is when different objects hash to the same value -dumb luck
        //return getBrand().length() + getVolume();

        //delegate to objects hash to minimize hash collisions
        return Objects.hash(getBrand(), getVolume());
    }


    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Television) {
            //downcast obj to more specific type Television, to call Television methods
            Television other = (Television) obj;

            //Do the checks: business equality is defined by brand and volume
            result = Objects.equals(this.getBrand(), other.getBrand()) &&  //null safe check
                     this.getVolume() == other.getVolume();
        }
        return result;
    }



//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//
//        if (obj == null || this.getClass() != obj.getClass()) return false;
//
//        Television that = (Television) obj;
//
//        return this.getVolume() == that.getVolume() &&
//                Objects.equals(this.getBrand(), that.getBrand());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getBrand(), getVolume());
//    }
//
//
//    //toString method
//    @Override
//    public String toString() {
//        return String.format("%s: Brand = %S, " + "Volume = %S, Channel = %S",
//                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
//    }
//
//

}