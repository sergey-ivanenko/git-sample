package service;

import businesslogic.Util;
import dao.AddressDAO;
import entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements AddressDAO{

    //private Connection connection = getConnection();

    @Override
    public void addAddress(Address address) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO address (address_id, country, city, street, post_code) VALUES(?, ?, ?, ?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, address.getAddressID());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Address> getAllAddresses() throws SQLException {
        List<Address> addressList = new ArrayList<>();

        String sql = "SELECT address_id, country, city, street, post_code FROM address";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Address address = new Address();
                address.setAddressID(resultSet.getInt("address_id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setPostCode(resultSet.getString("post_code"));

                addressList.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return addressList;
    }

    @Override
    public Address getAddressById(int addressID) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "SELECT address_id, country, city, street, post_code FROM address WHERE address_id=?";

        Address address = new Address();

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, addressID);

            ResultSet resultSet = preparedStatement.executeQuery();

            address.setAddressID(resultSet.getInt("address_id"));
            address.setCountry(resultSet.getString("country"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setPostCode(resultSet.getString("post_code"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return address;
    }

    @Override
    public void updateAddress(Address address) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE address SET country=?, city=?, street=?, post_code=? WHERE address_id=?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,address.getCountry());
            preparedStatement.setString(2,address.getCity());
            preparedStatement.setString(3,address.getStreet());
            preparedStatement.setString(4,address.getPostCode());
            preparedStatement.setInt(5, address.getAddressID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void removeAddress(Address address) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM address WHERE address_id=?";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, address.getAddressID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
