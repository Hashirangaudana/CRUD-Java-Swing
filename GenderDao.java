
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GenderDao {
    
    public static Gender getById(int id){
   
        Gender gender = new Gender();
    

    try {

    
    String qry = "select * FROM gender where id =" + id;
    ResultSet rslt = commenDao.get(qry);

    rslt.next();
    gender.setId(rslt.getInt("id"));
    gender.setName(rslt.getString("name"));

    }catch (SQLException e){
        //to do:handle exception
    }
    
    return gender;      
 }

public static List<Gender> getAll(){

List<Gender> genders = new ArrayList<Gender>();

try{

    String qry = "select * from gender";
    ResultSet rslt = commenDao.get(qry);

    while(rslt.next()){

        Gender gender = new Gender();

        gender.setName(rslt.getString("name"));
        gender.setId(rslt.getInt("id"));

        genders.add(gender);

    }

}catch(SQLException ex){
    System.out.println("connection erro" + ex.getMessage());

}

return genders;
}
}






