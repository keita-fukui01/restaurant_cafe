package restaurant_cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import restaurant_cafe.bean.ItemBean;

public class ItemDAO {
//一覧画面
private static final String SELECT = "select * from re_cafe";
//検索
private static final String CONDITIONAL_SELECT = "select * from re_cafe where name like ? and mail like ? and phoneNumber like ? and cellphoneNumber like ?";
private static final String ID_SELECT = "select * from re_cafe where id=?";
private static final String INSERT = "insert into re_cafe values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
private static final String UPDATE
           = "update re_cafe set id=?, name=?, course=?, mail=?, phoneNumber=?, cellphoneNumber=?, gender=?, year=?, month=?, day=?, time=?, minutes=? where id=?";
private static final String DELETE = "delete from re_cafe where id=?";
private static final String MAXID = "select max(id) from re_cafe";


private DataSource source;

    public ItemDAO() throws NamingException {
        InitialContext context = new InitialContext();
        source = (DataSource) context.lookup("java:comp/env/jdbc/datasource");
    }

    // MAXID
    public int getMaxID() throws SQLException {

    	int maxId = 0;

        Connection connection = source.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(MAXID);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
           	   maxId=result.getInt("max(id)")+1;
        }
           statement.close();

            } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return maxId;
    }

    // 一覧取得
    public List<ItemBean> getItemList() throws SQLException {

        List<ItemBean> itemList = new ArrayList<ItemBean>();
        Connection connection = source.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ItemBean item = new ItemBean();
                item.setId(result.getString("id"));
                item.setName(result.getString("name"));
                item.setCourse(result.getString("course"));
                item.setMail(result.getString("mail"));
//              item.setMailForCheck(result.getString("mailForCheck"));
                item.setPhoneNumber(result.getString("phoneNumber"));
                item.setCellphoneNumber(result.getString("cellphoneNumber"));
                item.setGender(result.getString("gender"));
                item.setYear(result.getString("year"));
                item.setMonth(result.getString("month"));
                item.setDay(result.getString("day"));
                item.setTime(result.getString("time"));
                item.setMinutes(result.getString("minutes"));
                itemList.add(item);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return itemList;
    }
  //条件指定で一覧取得
   	public List<ItemBean> getItemListConditionally(String name, String mail, String phoneNumber, String cellphoneNumber) throws SQLException {

        List<ItemBean> itemList = new ArrayList<ItemBean> ();
        Connection connection = source.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(CONDITIONAL_SELECT);

//          statement.setString(1, "%" + id + "%");
            statement.setString(1, "%" + name + "%");
            statement.setString(2, "%" + mail + "%");
//          statement.setString(4, "%" + mailForCheck + "%");
            statement.setString(3, "%" + phoneNumber + "%");
            statement.setString(4, "%" + cellphoneNumber + "%");
//          statement.setString(6, "%" + gender + "%");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ItemBean item = new ItemBean();

                item.setId(result.getString("id"));
                item.setName(result.getString("name"));
                item.setCourse(result.getString("course"));
                item.setMail(result.getString("mail"));
//              item.setMailForCheck(result.getString("mailForCheck"));
                item.setPhoneNumber(result.getString("phoneNumber"));
                item.setCellphoneNumber(result.getString("cellphoneNumber"));
                item.setGender(result.getString("gender"));
                item.setYear(result.getString("year"));
                item.setMonth(result.getString("month"));
                item.setDay(result.getString("day"));
                item.setTime(result.getString("time"));
                item.setMinutes(result.getString("minutes"));
                itemList.add(item);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return itemList;
    }


    //商品1件取得
    public ItemBean getItemById(String id) throws SQLException {

        ItemBean item = new ItemBean();
        Connection connection = source.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(ID_SELECT);
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
            	item.setId(result.getString("id"));
            	item.setName(result.getString("name"));
                item.setCourse(result.getString("course"));
                item.setMail(result.getString("mail"));
//              item.setMailForCheck(result.getString("mailForCheck"));
                item.setPhoneNumber(result.getString("phoneNumber"));
                item.setCellphoneNumber(result.getString("cellphoneNumber"));
                item.setGender(result.getString("gender"));
                item.setYear(result.getString("year"));
                item.setMonth(result.getString("month"));
                item.setDay(result.getString("day"));
                item.setTime(result.getString("time"));
                item.setMinutes(result.getString("minutes"));

            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return item;
    }


    //商品の追加
    	public void insertItem(String id, String name, String course, String mail,
    		    String phoneNumber, String cellphoneNumber, String gender, String year, String month, String day,
    		    String time, String minutes) throws SQLException {

        Connection connection = source.getConnection();

        try {


            PreparedStatement statement = connection.prepareStatement(INSERT);

            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, course);
            statement.setString(4, mail);
//          statement.setString(4, mailForCheck);
            statement.setString(5, phoneNumber);
            statement.setString(6, cellphoneNumber);
            statement.setString(7, gender);
            statement.setString(8, year);
            statement.setString(9, month);
            statement.setString(10, day);
            statement.setString(11, time);
            statement.setString(12, minutes);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    //商品を更新
    	public void updateItem(String id, String name, String course, String mail,	String phoneNumber, String cellphoneNumber,
    			String gender,String year, String month, String day, String time, String minutes, String oldId) throws SQLException {

        Connection connection = source.getConnection();

        try {

            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, course);
            statement.setString(4, mail);
//          statement.setString(4, mailForCheck);
            statement.setString(5, phoneNumber);
            statement.setString(6, cellphoneNumber);
            statement.setString(7, gender);
            statement.setString(8, year);
            statement.setString(9, month);
            statement.setString(10, day);
            statement.setString(11, time);
            statement.setString(12, minutes);
            statement.setString(13, oldId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    //商品の削除
       public void deleteItem(String id) throws SQLException {

        Connection connection = source.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setString(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
