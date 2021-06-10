package com.company.devices;

import java.util.Objects;

public class Phone {
    public String producer;
    public String model;
    public Double screenSize;
    public String phoneOSVersion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return producer.equals(phone.producer) && model.equals(phone.model) && screenSize.equals(phone.screenSize) && phoneOSVersion.equals(phone.phoneOSVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, screenSize, phoneOSVersion);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", screenSize=" + screenSize +
                ", phoneOSVersion='" + phoneOSVersion + '\'' +
                '}';
    }
}
