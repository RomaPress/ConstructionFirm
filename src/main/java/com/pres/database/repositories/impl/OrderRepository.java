package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;
import com.pres.database.repositories.get.GetOrder;
import com.pres.model.Order;
import com.pres.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderRepository  implements Repository {

    public void setOrder(){
        CustomerRepository cs = new CustomerRepository();
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("insert into db_construction_firm.\"order\" (date, status_id, customer_id) values (current_date, ?,?);");
            int i = 0;
            statement.setInt(++i, 1);
            statement.setInt(++i, cs.getLastCustomerId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastOrderId() {
        int result = 0;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select max(order_id) as order_id  from db_construction_firm.\"order\";");
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Order> orderInfo (Map<Integer, List<Service>> orderedServices){

        List<Order> result = new ArrayList<>();
        try (Connection connection = getConnection()) {

            for (Integer key : orderedServices.keySet()) {

                PreparedStatement statement = connection.prepareStatement("select ord.date, ord.order_id, cus.customer_id, cus.first_name, cus.last_name, cus.patronymic, cus.phone_number, st.name_status from db_construction_firm.\"order\" ord left join db_construction_firm.customer cus on ord.customer_id = cus.customer_id left join db_construction_firm.status st on ord.status_id = st.status_id  where ord.order_id = ?;");
                statement.setInt(1, key);
                ResultSet rs = statement.executeQuery();

                Order order = new Order();
                rs.next();

                order.setOrder_id(rs.getInt("order_id"));

                java.sql.Date date = rs.getDate("date");
                order.setData(new java.util.Date(date.getTime()));

                order.setCustomer_id(rs.getInt("customer_id"));
                order.setFirst_name(rs.getString("first_name"));
                order.setLast_name (rs.getString("last_name"));
                order.setPatronymic (rs.getString("patronymic"));
                order.setPhone_number(rs.getInt("phone_number"));
                order.setStatus(rs.getString("name_status"));
                order.setOrderedServices(orderedServices.get(key));

                float price = 0;
                for(int i = 0; i<orderedServices.get(key).size(); i++){
                    price += orderedServices.get(key).get(i).getAmount() * orderedServices.get(key).get(i).getUnit_price();
                }
                order.setPrice(price);

                result.add(order);
            }
            for (Order i : result){
                i.toString();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteOrder(int order_id){

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("delete from db_construction_firm.\"order\"  where order_id = ?");

            statement.setInt(1, order_id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }









    public static void main(String[] args) {
        GetOrder w = new GetOrder();
        ServiceRepository c = new ServiceRepository();
        OrderRepository q = new OrderRepository();


        q.orderInfo(c.getOrderedService(w.getOrderId()));
    }
}
