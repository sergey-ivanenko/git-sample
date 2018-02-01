package service;

import businesslogic.SessionUtil;
import dao.AddressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO{

    @Override
    public void addAddress(Address address) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.save(address);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public List<Address> getAllAddresses() throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM adress";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);

        List<Address> addressList = query.list();

        // close session with transaction
        closeTransactionSession();

        return addressList;
    }

    @Override
    public Address getAddressById(int addressID) throws SQLException {
        // open session with transaction
        openTransactionSession();

        String sql = "SELECT * FROM address WHERE addressID = :addressId";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("addressId", addressID);

        Address address = (Address)query.getSingleResult();

        // close session with transaction
        closeTransactionSession();

        return address;
    }

    @Override
    public void updateAddress(Address address) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        // close session with transaction
        closeTransactionSession();
    }

    @Override
    public void removeAddress(Address address) throws SQLException {
        // open session with transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        // close session with transaction
        closeTransactionSession();
    }
}
