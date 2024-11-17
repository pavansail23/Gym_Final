package com.gym;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class gym_reg_trail
 */
@WebServlet("/register_membership")
public class Gym_final extends HttpServlet {
private static final String query = "INSERT INTO gym_final(NAME,PHONE_NUM,EMAIL,MEMBERSHIP_TYPE,PERSONAL_TRAINING) VALUES (?,?,?,?,?)";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String name = req.getParameter("name");
		String phone = req.getParameter("phone_num");
		String email = req.getParameter("email");
		String membership = req.getParameter("mem");
		String pt = req.getParameter("pt");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","mancity2023");
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, membership);
			ps.setString(5, pt);
			
			int count  = ps.executeUpdate();
			if(count ==0 )
			{
				pw.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Document</title>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"registration_failed.css\">\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"img-form\">\r\n"
						+ "        \r\n"
						+ "        <div class=\"form\">\r\n"
						+ "            <form>\r\n"
						+ "                <table>\r\n"
						+ "                    <tr>\r\n"
						+ "                        <td class=\"reg-name\">REGISTER</td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                    \r\n"
						+ "                        <td><input type=\"text\" class=\"ip\" placeholder=\"Name\" size=\"30\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                       \r\n"
						+ "                        <td><input type=\"text\" class=\"ip\" placeholder=\"Phone-num\" maxlength=\"10\" size=\"30\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        \r\n"
						+ "                        <td><input type=\"text\" class=\"ip\" placeholder=\"Email\" size=\"30\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        \r\n"
						+ "                        <td>\r\n"
						+ "                            <select size=\"0\" class=\"ip-select\" >\r\n"
						+ "                                <option disabled selected class=\"onle-white\">Membership</option>\r\n"
						+ "                                <option>1 Month</option>\r\n"
						+ "                                <option>3 Months</option>\r\n"
						+ "                                <option>6 Months</option>\r\n"
						+ "                                <option>1 Year</option>\r\n"
						+ "                            </select>\r\n"
						+ "                        </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        <td><input type=\"reset\" value=\"RESET\" class=\"ip-rs\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
						+ "                        <input type=\"submit\" value=\"SUBMIT\" class=\"ip-rs\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr class=\"message\">\r\n"
						+ "                        <td>sorry!! Registration failed</td>\r\n"
						+ "                    </tr>\r\n"
						+ "                </table>\r\n"
						+ "            </form>\r\n"
						+ "        </div>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>");
			}
			else
			{
				pw.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Registration Successfull</title>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"registration_successfull.css\">\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"img-form\">\r\n"
						+ "        \r\n"
						+ "        <div class=\"form\">\r\n"
						+ "            <form>\r\n"
						+ "                <table>\r\n"
						+ "                    <tr>\r\n"
						+ "                        <td class=\"reg-name\">REGISTER</td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                    \r\n"
						+ "                        <td><input type=\"text\" class=\"ip\" placeholder=\"Name\" size=\"30\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                       \r\n"
						+ "                        <td><input type=\"text\" class=\"ip\" placeholder=\"Phone-num\" maxlength=\"10\" size=\"30\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        \r\n"
						+ "                        <td><input type=\"text\" class=\"ip\" placeholder=\"Email\" size=\"30\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        \r\n"
						+ "                        <td>\r\n"
						+ "                            <select size=\"0\" class=\"ip-select\" >\r\n"
						+ "                                <option disabled selected class=\"onle-white\">Membership</option>\r\n"
						+ "                                <option>1 Month</option>\r\n"
						+ "                                <option>3 Months</option>\r\n"
						+ "                                <option>6 Months</option>\r\n"
						+ "                                <option>1 Year</option>\r\n"
						+ "                            </select>\r\n"
						+ "                        </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                        <td><input type=\"reset\" value=\"RESET\" class=\"ip-rs\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
						+ "                        <input type=\"submit\" value=\"SUBMIT\" class=\"ip-rs\"></td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr class=\"message\">\r\n"
						+ "                        <td>Thank You!! We will contact you shortly</td>\r\n"
						+ "                    </tr>\r\n"
						+ "                </table>\r\n"
						+ "            </form>\r\n"
						+ "        </div>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			pw.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e)
		{
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		pw.close();
	}
}
