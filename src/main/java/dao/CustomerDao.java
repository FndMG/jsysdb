package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.JsysException;
import model.Customer;

public class CustomerDao extends BaseDao {
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
				String customerCode = rs.getString("customer_code");
				String customerName = rs.getString("customer_name");
				String customerTelno = rs.getString("customer_telno");
				String customerPostalcode = rs.getString("customer_postalcode");
				String customerAddress = rs.getString("customer_address");
				int discountRate = rs.getInt("discount_rate");
				boolean deleteFlag = rs.getBoolean("delete_flag");

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
}