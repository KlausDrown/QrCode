package Project.DAO;

import Project.object.QrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QrCodeService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QrCodeService(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }


//    public int save(QrCode to_do_list){
//        return jdbcTemplate.update("insert into List(qrValue) values (?) returning id",
//                to_do_list.getQrValue()
//        );
//    }

    public int save(QrCode qrCode){
        return jdbcTemplate.queryForObject(
                "insert into List(qrValue) values (?) returning id", Integer.class , qrCode.getQrValue());
    }



    public List<QrCode> index(){
        return jdbcTemplate.query("SELECT * FROM List",
                new BeanPropertyRowMapper<>(QrCode.class));
    }

    public List<QrCode> index(int id){
        return jdbcTemplate.query("SELECT * FROM List WHERE id =?",
                new BeanPropertyRowMapper<>(QrCode.class), id);
    }

    public int update(int ID, String newValue){
        return jdbcTemplate.update("UPDATE List SET qrValue = ? WHERE id = ?",
                newValue,
                ID);
    }

    public int delete(int ID) {
        return jdbcTemplate.update("DELETE FROM List WHERE id = ?", ID);
    }
}
