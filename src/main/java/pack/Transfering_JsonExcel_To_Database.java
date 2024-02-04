package pack;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.*;

@SuppressWarnings("serial")
@WebServlet("/Transfering_JsonExcel_To_Database")
public class Transfering_JsonExcel_To_Database extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://38.242.196.35:35777/extio_db", "extio_user",
					"7Aw$S(5+7aKF0R6p");
			JSONParser jsonParser = new JSONParser();
			// Parsing the contents of the JSON file
			JSONObject jsonObject = (JSONObject) jsonParser
					.parse(new FileReader("C:\\Users\\extio\\Downloads\\utility-json.txt"));
			// Retrieving the array
			out.println(jsonObject);
			out.println(
					"****************************************************************************************************");
			JSONObject requestDataObj = (JSONObject) jsonObject.get(/* "request_identifier" +*/"request_data" );
			// Insert a row into the playground table
			out.println(requestDataObj);
			out.println(
					"****************************************************************************************************");
			// out.println("String=" +requestDataObj.get("utility_number"));
			PreparedStatement pst = con.prepareStatement(
					"insert into tz_az_prc_utility_nofin_azam values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			JSONObject record = (JSONObject) requestDataObj;
			Object user_reference = record.get("user_reference");
			Object xref = record.get(" xref");
			Object user_id = record.get("user_id");
			Object exchange_id = record.get("exchange_id");
			Object timestamp = record.get("timestamp");
			Object exchange_start_time = record.get("exchange_start_time");
			Object exchange_end_time = record.get("exchange_end_time ");
			Object channel = record.get("channel");
			Object request_type = record.get("request_type");
			Object bank_id = record.get(" bank_id");
			Object reference_id = record.get("reference_id");
			Object block_sms = record.get("block_sms");
			Object txn_mode = record.get("txn_mode");
			Object cell_id = record.get("cell_id");
			Object ftxn_id = record.get("ftxn_id");
			Object utility_code = record.get("utility_code");
			Object utility_numbe = record.get("utility_number");
			Object cbs_reference = record.get("cbs_reference");
			Object maintained_account = record.get("maintained_account");
			Object maintained_branch = record.get("maintained_branch");
			Object transaction_amount = record.get("transaction_amount");
			Object payment_datetime = record.get("payment_datetime");
			Object transaction_currency = record.get("transaction_currency");
			Object customer_name = record.get("customer_name");
			Object customer_mobile = record.get("customer_mobile");
			Object customer_email = record.get("customer_email");
			Object narration = record.get("narration");
			Object recordstatus = record.get("recordstatus");
			Object error_code = record.get("error_code");
			Object error_status = record.get("error_status");
			Object error_description = record.get("error_description");
			Object error_friendly = record.get(" error_friendly");

			pst.setString(1, (String) user_reference);
			pst.setString(2, (String) xref);
			pst.setString(3, (String) user_id);
			pst.setString(4, (String) exchange_id);
			pst.setDate(5, (Date) timestamp);
			pst.setString(6, (String) exchange_start_time);
			pst.setString(7, (String) exchange_end_time);
			pst.setString(8, (String) channel);
			pst.setString(9, (String) request_type);
			pst.setString(10, (String) bank_id);
			pst.setString(11, (String) reference_id);
			pst.setString(12, (String) block_sms);
			pst.setString(13, (String) txn_mode);
			pst.setString(14, (String) cell_id);
			pst.setString(15, (String) ftxn_id);
			pst.setString(16, (String) utility_code);
			pst.setString(17, (String) utility_numbe);
			pst.setString(18, (String) cbs_reference);
			pst.setString(19, (String) maintained_account);
			pst.setString(20, (String) maintained_branch);
			pst.setLong(21, (long) transaction_amount);
			pst.setString(22, (String) payment_datetime);
			pst.setString(23, (String) transaction_currency);
			pst.setString(24, (String) customer_name);
			pst.setString(24, (String) customer_mobile);
			pst.setString(25, (String) customer_email);
			pst.setString(26, (String) narration);
			pst.setString(27, (String) recordstatus);
			pst.setString(28, (String) error_code);
			pst.setString(29, (String) error_status);
			pst.setString(30, (String) error_description);
			pst.setString(31, (String) error_friendly);
			pst.executeUpdate();
			out.println("DATA SUCCESSFULLY INSERTED TO DATABASE.......");
		} catch (Exception e) {
			e.printStackTrace();
			out.println(e);
		}
	}

}