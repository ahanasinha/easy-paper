import java.util.*;  
import java.sql.*;  
  
public class UserDao {  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            String jdbcUrl="jdbc:mysql://localhost:3306/easypaper";
            String username = "root";
            String password = "ahana15";
          
            con = DriverManager.getConnection(jdbcUrl,username,password);
       
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    public static int save(Users u){  
        int status=0;  
        try{  
            
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into user(username,name,email,mobile,address,role,pw) values (?,?,?,?,?,?,?)");  
            ps.setString(1,u.getUsername());  
            ps.setString(2,u.getName()); 
            ps.setString(3,u.getEmail());   
            ps.setString(4,u.getMobile()); 
            ps.setString(5,u.getAddress()); 
            ps.setString(6,u.getRole()); 
            ps.setString(7,u.getPw()); 
     
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }

    public static String loginUser(String user,String pw){  
        String role=""; 
          
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select role from user where (email=? OR mobile=?) AND pw=?");  
            ps.setString(1, user);  
            ps.setString(2, user);
            ps.setString(3, pw);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){   
                role=rs.getString(1);
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return role;
    }

    public static List<Users> getAllUsers(){  
        List<Users> list=new ArrayList<Users>();  
          
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Users u=new Users();  
                
                u.setEmail(rs.getString(1));
                u.setName(rs.getString(2)); 
                u.setMobile(rs.getString(3));
                u.setRole(rs.getString(4));
                list.add(u);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }

}  