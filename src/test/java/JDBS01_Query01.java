import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.sql.*;

public class JDBS01_Query01 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1 - Ilgili Driver' i yuklemeliyiz - MySQL kullandigimizi bildiriyoruz
        // Driver'i bulamama ihtimaline karsi forName methodu benden 'ClassNotFoundException'
        // icin main methoda exception firlatmami istiyor

        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2 - Baglantiyi olusturmak icin username ve password girisi yapmaliyiz
        // Burada da username ve password'un yanlis olmasi ihtimaline karsi getConnection metodu
        // SQLException firlatmami istiyor

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3 - SQL Query'leri icin bir Statement objesi olusturup , javada kendimize SQL sorgulari icin bir alan acacagiz.

        Statement st = con.createStatement();

        // 4 - SQL sorgularini yazip, calistirabiliriz

        ResultSet veri =st.executeQuery("SELECT * FROM calisanlar");



        while (veri.next()){
              System.out.println(veri.getInt("id")+ " " + veri.getString("isim")+ " " + veri.getString("sehir")+ " "
             + veri.getInt("maas")+ " " + veri.getString("sirket"));

        }

        // 6 - Olusturulan nesneleri close() ile kapatiyoruz ki bellekten kaldiralim

        con.close();
        st.close();
        veri.close();
    }
}
