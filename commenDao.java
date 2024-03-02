import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class commenDao {

    public static ResultSet get(String qry) {

        ResultSet rslt = null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/euc", "root", "Hashi123@");
            Statement stm = conn.createStatement();
            rslt = stm.executeQuery(qry);

        } catch (SQLException ex) {
            System.out.println("can't connect as" + ex.getMessage());
        }
        return rslt;

    }

        public static String modify(String qry) {

        String msg ="0";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/euc", "root", "Hashi123@");
            Statement stm = conn.createStatement();
            int row = stm.executeUpdate(qry);
            if(row != 0){
                msg = "1";
            }else {
                msg = "Db Error";
            }

        } catch (SQLException ex) {
            System.out.println("can't connect as" + ex.getMessage());
        }
        return msg;

    }

}
