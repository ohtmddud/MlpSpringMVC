package emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmpDAOImpl implements EmpDAO {
	private JdbcTemplate myTemplate;
	private SqlSession sqlSession;
	
	@Autowired
	public EmpDAOImpl(JdbcTemplate myTemplate, SqlSession sqlSession) {
		super();
		this.myTemplate = myTemplate;
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(EmpDTO user) {
		String sql = "insert into myemp values(?, ?, ?, ?, ?, 1000, ?)";
		return myTemplate.update(sql, user.getDeptno(), user.getName(), user.getId(), user.getPass(), user.getAddr(),
				user.getGrade());
	}

	@Override
	public int update(EmpDTO user) {
		String sql = "update myemp set addr = ?, pass = ? where id = ?";
		return myTemplate.update(sql, user.getAddr(), user.getPass(), user.getId());
	}

	@Override
	public int delete(String id) {
		String sql = "delete myemp where id = ?";
		return myTemplate.update(sql, id);
	}

	@Override
	public EmpDTO login(String id, String pass) {
		EmpDTO user = null;
		try {
			user = myTemplate.queryForObject("select * from myemp where id = ? and pass = ?", new Object[] { id, pass },
					new EmpRowMapper());
		} catch (EmptyResultDataAccessException e) {

		}
		return user;
	}

	@Override
	public EmpDTO findById(String id) {
		return myTemplate.queryForObject("select * from myemp where id = ?", new Object[] { id }, new EmpRowMapper());

	}

	@Override
	public List<EmpDTO> getMemberList() {
		return myTemplate.query("select * from myemp", new EmpRowMapper());
	}

	@Override
	public List<EmpDTO> findBySearch(String category, String data) {
		String sql = "";
		switch (category) {
		case "name":
			sql = "select * from myemp where name like ?";
			break;
		case "grade":
			sql = "select * from myemp where grade like ?";
			break;
		default:
			sql = "select * from myemp where addr like ?";
			break;
		}
		return myTemplate.query(sql, new Object[] { "%" + data + "%" }, new EmpRowMapper());
	}

	@Override
	public int SignUp(EmpDTO user) {
		return sqlSession.insert("com.multi.erp.board.insert", user);
	}

	@Override
	public List<EmpDTO> AllUserList() {
		return sqlSession.selectList("com.multi.erp.board.select");
	}
	
	

}
