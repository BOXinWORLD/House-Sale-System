package all;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.sql.*;
import java.util.Date; 
import java.text.SimpleDateFormat; 



public class data {
	public static String a[][];//���ݱ����Ϣ
	public static String c[][];//�˺ű����Ϣ
	public static String b[][];//���������Ϣ
	public static String get[]=new String[4];//������Ϣ
	public static int counta=0;
	public static int countc=0;
	public static int countb=0;
	public static int countb2=0;
	public static int juese=0;
	static String nowuser[]=new String[4];//��ǰ�û���Ϣ
	static Connection connection;
	static Statement statement;
	static PreparedStatement preparedstatement;
	static ResultSet resultSet;
	static String driverName="com.mysql.jdbc.Driver";               // �������ݿ�������
    static String url="jdbc:mysql://localhost:3306/hsms";       // �������ݿ��URL
    static String user="root";                                      // ���ݿ��û�
    static String password="A1936587";

	public static  void connectToDatabase() throws SQLException, ClassNotFoundException{
			Class.forName(driverName);
			connection=DriverManager.getConnection(url, user, password);
	}
	public static void disconnectFromDatabase(){
		
			try{
				resultSet.close();
				statement.close();
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		
	}
	public static boolean login(String a,String p) throws SQLException{
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql="select * from customer where account='"+a+"' and pwd='"+p+"'";
		resultSet =statement.executeQuery(sql);
		if(resultSet.next())
		{
			nowuser[0]=a;
			nowuser[2]=resultSet.getString("cTel");
			nowuser[3]=resultSet.getString("cID");
			nowuser[1]=p;
			if(nowuser[0].equals("root"))juese=1;
			
			return true;
		}
		else return false;
	
}
	public static void inithouse(int t) throws IOException, SQLException {//��ʼ��

		counta=0;
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = null;
		if(juese==1&&t==1)sql="select * from house ORDER BY `hPrice`";
		if(juese==1&&t==2)sql="select * from house ORDER BY `hArea`";
		if(juese==1&&t==0)sql="select * from house";		
		if(juese==0&&t==1)sql="select * from house WHERE `hState` = '����' ORDER BY `hPrice`";
		if(juese==0&&t==2)sql="select * from house WHERE `hState` = '����' ORDER BY `hArea`";
		if(juese==0&&t==0)sql="select * from house where hState ='����'";
		
        resultSet = statement.executeQuery(sql);		
		while (resultSet.next()){
			counta++;
		}
		a=new String[counta][4];
		int i =0;
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			a[i][0]=resultSet.getString("hAddress");
			a[i][2]=resultSet.getString("hArea");
			a[i][3]=resultSet.getString("hState");
			a[i][1]=resultSet.getString("hPrice");
			i++;
		}        
	}
	public static boolean gethouse(String a) throws SQLException{
		
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql="select * from house where hAddress='"+a+"' ";
		resultSet =statement.executeQuery(sql);
		
		if(resultSet.next())
		{

			get[0]=resultSet.getString("hAddress");
			get[2]=resultSet.getString("hType");
			get[1]=resultSet.getString("hArea");
			get[3]=resultSet.getString("hPrice");
			return true;

		}
		return false;
		
	}
	public static boolean addhouse(String a,String b,String c,String d) throws SQLException {//���

		String sql="INSERT INTO house(hAddress,hType,hArea,hState,hPrice) VALUES(?,?,?,?,?)";		
		preparedstatement=connection.prepareStatement(sql);
		  preparedstatement.setString(1,a);
		  preparedstatement.setString(2,c);
		  preparedstatement.setString(3,b);
		  preparedstatement.setString(4,"����");
		  preparedstatement.setString(5,d);
		  
		  int temp = preparedstatement.executeUpdate();
		if(temp!=0){
			return true;
		}
		else
			return false;
	}
	public static boolean sethouse(String a,String b,String c,String d,String a0) throws SQLException {//�޸�

		String sql = "UPDATE house SET hType=?,hArea=?,hPrice=?,hAddress=? where hAddress=?";
		  preparedstatement=connection.prepareStatement(sql);
		  preparedstatement.setString(1,c);
		 preparedstatement.setString(2,b);
		 preparedstatement.setString(3,d);
		 preparedstatement.setString(4,a);
		 preparedstatement.setString(5,a0);
		 int temp = preparedstatement.executeUpdate();
			if(temp!=0){
				get[0]=a;
				get[1]=b;
				get[2]=c;
				get[3]=d;
				return true;
			}
			else
				return false;
	}
	public static void inituser() throws IOException, SQLException {//��ʼ��

		countc=0;
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql="select * from customer";
        resultSet = statement.executeQuery(sql);		
		while (resultSet.next()){
			countc++;
		}
		c=new String[countc][4];
		int i =0;
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			c[i][0]=resultSet.getString("account");
			c[i][2]=resultSet.getString("cTel");
			c[i][3]=resultSet.getString("cID");
			c[i][1]=resultSet.getString("pwd");
			i++;
		}        
	}
	public static boolean adduser(String a,String p,String t,String d) throws SQLException {//���

		String sql="INSERT INTO customer(account,cTel,cID,pwd) VALUES(?,?,?,?)";		
		preparedstatement=connection.prepareStatement(sql);
		  preparedstatement.setString(1,a);
		  preparedstatement.setString(2,t);
		  preparedstatement.setString(3,d);
		  preparedstatement.setString(4,p);
		  
		  int temp = preparedstatement.executeUpdate();
		if(temp!=0){
			return true;
		}
		else
			return false;
	}
	public static boolean setuser(String a,String p,String t,String d,String a0) throws SQLException {//�޸�

		String sql = "UPDATE customer SET pwd=?,cTel=?,cID=?,account=? where account=?";
		  preparedstatement=connection.prepareStatement(sql);
		  preparedstatement.setString(1,p);
		 preparedstatement.setString(2,t);
		 preparedstatement.setString(3,d);
		 preparedstatement.setString(4,a);
		 preparedstatement.setString(5,a0);
		 int temp = preparedstatement.executeUpdate();
			if(temp!=0){
				nowuser[0]=a;
				nowuser[1]=p;
				nowuser[2]=t;
				nowuser[3]=d;
				return true;
			}
			else
				return false;
	}
	public static boolean deleteuser(String a) throws SQLException{//ɾ��
		if(a.equals("root"))return false;

        String sql="DELETE FROM customer where account=?";
		preparedstatement=connection.prepareStatement(sql);
		  preparedstatement.setString(1, a);
		  int temp = preparedstatement.executeUpdate();
			if(temp!=0){
				return true;
			}
			else
				return false;
		
	}
	public static boolean getuser(String a) throws SQLException{
		
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql="select * from customer where account='"+a+"' ";
		resultSet =statement.executeQuery(sql);
		
		if(resultSet.next())
		{

			nowuser[0]=resultSet.getString("account");
			nowuser[2]=resultSet.getString("cTel");
			nowuser[3]=resultSet.getString("cID");
			nowuser[1]=resultSet.getString("pwd");
			return true;

		}
		return false;
		
	}
	public static void initbuy() throws IOException, SQLException {//��ʼ��

		countb=0;
		countb2=0;
		statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql;
		if(juese==1)
			 sql="select * from buy";
		else 
			 {sql="select * from buy where account ='"+nowuser[0]+"'";
		     String sql2="select * from buy";
		     resultSet = statement.executeQuery(sql2);		
				while (resultSet.next()){
					countb2++;
				}
			 }
        resultSet = statement.executeQuery(sql);		
		while (resultSet.next()){
			countb++;
		}
		b=new String[countb][4];
		int i =0;
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()){

			b[i][2]=resultSet.getString("account");
			b[i][0]=resultSet.getString("hAddress");
			b[i][1]=resultSet.getString("bMoney");
			b[i][3]=resultSet.getString("bDate");
			i++;
		}        
	}
	public static boolean deletebuy(String a) throws SQLException{//ɾ��


        String sql="DELETE FROM buy where hAddress=?";
		preparedstatement=connection.prepareStatement(sql);
		  preparedstatement.setString(1, a);
		  int temp = preparedstatement.executeUpdate();
			if(temp!=0){
				String sql2 = "UPDATE house SET `hState` = '����' where `hAddress`=?";
				  preparedstatement=connection.prepareStatement(sql2);
				  preparedstatement.setString(1,a);
				  if(preparedstatement.executeUpdate()!=0)return true;
				  else return false;
			}
			else
				return false;
		
	}
	public static boolean addbuy(String a) throws SQLException {//���

		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");//���Է�����޸����ڸ�ʽ 
		String time = dateFormat.format( now ); 
		
		String sql="INSERT INTO buy(bNo,account,hAddress,bMoney,bDate) VALUES(?,?,?,?,?)";		
		preparedstatement=connection.prepareStatement(sql);
		  preparedstatement.setString(1,String.valueOf(countb2+1));
		  preparedstatement.setString(2,nowuser[0]);
		  preparedstatement.setString(3,a);
		  preparedstatement.setString(4,get[3]);
		  preparedstatement.setString(5,time);
		  
		  int temp = preparedstatement.executeUpdate();
		if(temp!=0){
			String sql2 = "UPDATE house SET `hState` = '����' where `hAddress`=?";
			  preparedstatement=connection.prepareStatement(sql2);
			  preparedstatement.setString(1,a);
			  if(preparedstatement.executeUpdate()!=0)return true;
			  else return false;
		}
		else
			return false;
	}
	    // ��ȡ����ͼƬ��ȡ������
	    public static  FileInputStream readImage(String path) throws IOException {
	        return new FileInputStream(new File(path));
	    }
	    // ��ȡ����ͼƬ��ȡ�����
	    public static  void readBin2Image(InputStream in, String targetPath) {
	        File file = new File(targetPath);
	        String path = targetPath.substring(0, targetPath.lastIndexOf("/"));
	        if (!file.exists()) {
	            new File(path).mkdir();
	        }
	        FileOutputStream fos = null;
	        try {
	            fos = new FileOutputStream(file);
	            int len = 0;
	            byte[] buf = new byte[1024];
	            while ((len = in.read(buf)) != -1) {
	                fos.write(buf, 0, len);
	            }
	            fos.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (null != fos) {
	                try {
	                    fos.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	public static boolean readImage2DB(String path,String path2,String a) {
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        FileInputStream in2 = null;
        try {
            in = readImage(path);
            in2 = readImage(path2);
            conn = connection;
            String sql = "UPDATE house SET img_1 =?,img_2 =? where hAddress=?";
            ps = conn.prepareStatement(sql);
            ps.setBinaryStream(1, in, in.available());
            ps.setBinaryStream(2, in2, in2.available());
            ps.setString(3, a);

            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("����ɹ���");
                return true;
            } else {
                System.out.println("����ʧ�ܣ�");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		return false;

	}
	public static void readDB2Image(String a) {
        String targetPath1 = "D:/temp/1.png";
        String targetPath2 = "D:/temp/2.png";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = connection;
            String sql = "select * from house where hAddress =?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("img_1");
                readBin2Image(in, targetPath1);
                InputStream in2 = rs.getBinaryStream("img_2");
                readBin2Image(in2, targetPath2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

	
	
	//	public static void main(String[] args) throws IOException {  
//		data.init();
//	}
//	

}
