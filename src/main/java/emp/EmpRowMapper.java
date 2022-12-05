package emp;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

// JdbcTemplate 에서 select 를 처리하는 query 메소드 내부에서 디비에서 조회한 레코드를 어떻게 매핑 시켜야하는지 정보를 담고 있는 객체
// 디비에서 조회한 레코드를 어떤 객체로 매핑해야 하는지 정보를 정의하는 객체
// while(rs.next()) {
//	 user = new CustomerDTO(rs.getString(1), ...);
//	  → 이 부분이 RowMapper 에 정의 되어야 하는 부분이다.
// }

public class EmpRowMapper implements RowMapper<EmpDTO> {

	@Override
	public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 레코드 하나를 DTO 에 매핑 한 후 리턴, query 메소드 내부에서 while 문 같은 반복문 안에서 이 메소드를 호출
		EmpDTO customer = new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
		return customer;
	}

}
