package uk.hpkns.dvdrentalpos.data;

public interface Updatable<T> {

    void overlay(T other);
}
