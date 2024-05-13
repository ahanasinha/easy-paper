import java.util.*;  
import java.sql.*;  
  
public class PaperDao {  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            String jdbcUrl="jdbc:mysql://localhost:3306/student_db";
            String username = "root";
            String password = "ahana15";
          
            con = DriverManager.getConnection(jdbcUrl,username,password);
       
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    public static int save(Papers p){  
        int status=0;  
        try{  
            
            Connection con=PaperDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into paper(title,category,name,address,mobile,email,paper) values (?,?,?,?,?,?,?)");  
            ps.setString(1,p.getTitle());
            ps.setString(2,p.getCategory());  
            ps.setString(3,p.getName());  
            ps.setString(4,p.getAddress()); 
            ps.setString(5,p.getMobile());
            ps.setString(6,p.getEmail()); 
            ps.setString(7,p.getPaper()); 
     
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }

    public static List<Papers> getAllPapers(){  
        List<Papers> list=new ArrayList<Papers>();  
          
        try{  
            Connection con=PaperDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from paper");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Papers p=new Papers();  
                
                p.setId(rs.getInt(1));  
                p.setTitle(rs.getString(2));
                p.setCategory(rs.getString(3));  
                p.setName(rs.getString(4));        
                p.setAddress(rs.getString(5)); 
                p.setMobile(rs.getString(6));
                p.setEmail(rs.getString(7));
                p.setPaper(rs.getString(8));
                     
                list.add(p);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }

}  