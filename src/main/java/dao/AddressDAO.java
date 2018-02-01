package dao;

import entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {

    // create
    void addAddress(Address address) throws SQLException;

    // read
    List<Address> getAllAddresses() throws SQLException;

    Address getAddressById(int addressID) throws SQLException;

    // update
    void updateAddress(Address address) throws SQLException;

    // delete
    void removeAddress(Address address) throws SQLException;
}
