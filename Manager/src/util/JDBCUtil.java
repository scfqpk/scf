package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	//数据库位置
	public static final String url = "jdbc:mysql://localhost:3306/back?characterEncoding=utf8";
	//数据库登录名
	public static final String name = "root";
	//数据库登录密码
	public static final String pwd = "123456";
	//mysql数据库驱动位置
	public static final String className = "com.mysql.jdbc.Driver";

	public static Connection getConnection()// 获取连接
	{

		try {
			// 1 加载驱动
			Class.forName(className);
			// 2 获取连接
			Connection con = DriverManager.getConnection(url, name, pwd);
			System.out.println("连接成功");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Map<String, Object>> doQuery(String sql) // 执行查询
	{
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		// 1 获取连接
		Connection con = getConnection();
		if (con == null)
			return null;

		Statement psm = null;
		ResultSet rs = null;
		try {
			// 2 执行查询
			psm = con.createStatement();
			rs = psm.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();// 获取列信息
			int numberOfColumns = rsmd.getColumnCount();// 列数
			while (rs.next()) {
				// 声明一个用来存放一条数据的信息。 该条数据肯定由一个 列和值 的map集合 构成
				Map<String, Object> rsTree = new HashMap<String, Object>();
				// 对每一列进行循环  (以1开头)
				for (int i = 1; i <= numberOfColumns; i++) {
					// 存放对应 列名 及值
					rsTree.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				resultList.add(rsTree);
			}
			return resultList;
		} catch (Exception ex) {
			return null;
		} finally {
			close(con, psm, null);
		}
	}

	/**
	 * 增加 修改 删除 语句的通用sql ,
	 * 
	 * @param sql
	 * @param paras
	 * @return  
	 */
	public static boolean doUpdate(String sql) {
		Connection con = getConnection();
		if (con == null)
			return false;

		Statement psm = null;
		try {
			psm = con.createStatement();
			//result表示 执行sql语句所受影响的条数,大于等于1可表示执行成功
			int result = psm.executeUpdate(sql);
			return result >= 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			 close(con, psm, null);
		}
	}

 
	/**关闭数据库连接 
	 * @param con
	 * @param sm
	 * @param rs
	 */
	private static void close(Connection con, Statement sm, ResultSet rs) {
		try {
			// 5 关闭。后面获取的对象先关闭。
			if (rs != null)
				rs.close();
			if (sm != null)
				sm.close();
			if (con != null)
				con.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	
}

