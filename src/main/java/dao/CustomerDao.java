package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.JsysException;
import model.Customer;

public class CustomerDao extends BaseDao {
	private String sql = "INSERT INTO Customer (customer_code, customer_name, customer_telno, customer_postalcode, customer_address, discount_rate, delete_flag) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public CustomerDao() throws JsysException {
		super();
	}

	public List<Customer> findAllCustomer() throws JsysException {
		ArrayList<Customer> CustomerList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM Customer";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				boolean deleteFlag = rs.getBoolean("delete_flag");
				if (deleteFlag == true) {
					continue;
				}

				String customerCode = rs.getString("customer_code");
				String customerName = rs.getString("customer_name");
				String customerTelno = rs.getString("customer_telno");
				String customerPostalcode = rs.getString("customer_postalcode");
				String customerAddress = rs.getString("customer_address");
				int discountRate = rs.getInt("discount_rate");

				Customer Customer = new Customer(customerCode, customerName, customerTelno, customerPostalcode,
						customerAddress, discountRate, deleteFlag);

				CustomerList.add(Customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new JsysException("情報の取得に失敗しました");
		} finally {
			close();
		}

		return CustomerList;
	}

	public List<Customer> findCustomer(String search) throws JsysException {
		ArrayList<Customer> CustomerList = new ArrayList<>();

		try {
			String sql = "select * from customer where customer_name LIKE ?";

			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + search + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				boolean deleteFlag = rs.getBoolean("delete_flag");
				if (deleteFlag == true) {
					continue;
				}

				String customerCode = rs.getString("customer_code");
				String customerName = rs.getString("customer_name");
				String customerTelno = rs.getString("customer_telno");
				String customerPostalcode = rs.getString("customer_postalcode");
				String customerAddress = rs.getString("customer_address");
				int discountRate = rs.getInt("discount_rate");

				Customer Customer = new Customer(customerCode, customerName, customerTelno, customerPostalcode,
						customerAddress, discountRate, deleteFlag);

				CustomerList.add(Customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new JsysException("情報の取得に失敗しました");
		} finally {
			close();
		}

		return CustomerList;
	}

	public void registerCustomer(Customer customer) throws SQLException {
		ps = con.prepareStatement(sql);
		ps.setString(1, customer.getCustomerCode());
		ps.setString(2, customer.getCustomerName());
		ps.setString(3, customer.getCustomerTelno());
		ps.setString(4, customer.getCustomerPostalcode());
		ps.setString(5, customer.getCustomerAddress());
		ps.setInt(6, customer.getDiscountRate());
		ps.setBoolean(7, customer.isDeleteFlag());

		ps.executeUpdate();
	}

	public void registerCustomer(String customerCode, String customerName, String customerTelno, String customerPostalcode,
			String customerAddress, int discountRate, boolean deleteFlag) throws SQLException {
		ps = con.prepareStatement(sql);
		ps.setString(1, customerCode);
		ps.setString(2, customerName);
		ps.setString(3, customerTelno);
		ps.setString(4, customerPostalcode);
		ps.setString(5, customerAddress);
		ps.setInt(6, discountRate);
		ps.setBoolean(7, deleteFlag);

		ps.executeUpdate();
	}
}