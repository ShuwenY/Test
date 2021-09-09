package jdbcldap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcLdap {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        Class.forName("com.octetstring.jdbcLdap.sql.JdbcLdapDriver");
        String ldapConnectString = "jdbc:ldap://172.16.32.154/dc=sys,dc=com?SEARCH_SCOPE:=subTreeScope";
        Connection con = DriverManager.getConnection(ldapConnectString, "cn=admin,dc=sys,dc=com", "secret");

        String sql = "SELECT * FROM dc=sys,dc=com";

        Statement sat = con.createStatement();
        ResultSet rs = sat.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }

        if (con != null)
            con.close();
    }
}