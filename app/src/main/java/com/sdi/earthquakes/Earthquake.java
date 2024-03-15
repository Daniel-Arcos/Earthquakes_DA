package com.sdi.earthquakes;

import java.util.Objects;

public class Earthquake {
    private String id;
    private String place;
    private double magnitud;
    private long time;
    private double loingitude;
    private double latitude;

    public Earthquake(String id, String place, double magnitud, long time, double loingitude, double latitude) {
        this.id = id;
        this.place = place;
        this.magnitud = magnitud;
        this.time = time;
        this.loingitude = loingitude;
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getLoingitude() {
        return loingitude;
    }

    public void setLoingitude(double loingitude) {
        this.loingitude = loingitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earthquake that = (Earthquake) o;
        return Double.compare(that.magnitud, magnitud) == 0 && time == that.time && Double.compare(that.loingitude, loingitude) == 0 && Double.compare(that.latitude, latitude) == 0 && Objects.equals(id, that.id) && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, place, magnitud, time, loingitude, latitude);
    }
}
