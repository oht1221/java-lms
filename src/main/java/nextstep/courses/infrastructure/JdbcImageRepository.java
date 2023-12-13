package nextstep.courses.infrastructure;

import nextstep.courses.domain.image.*;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcImageRepository implements ImageRepository {

    private final JdbcOperations jdbcTemplate;

    public JdbcImageRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Image> findAllBySessionId(Long sessionId) {
        String sql = "select id, session_id, height, width, image_format, volume" +
                " from image" +
                " where session_id = ?";
        RowMapper<Image> rowMapper = (rs, rowNum) -> {
            ImageSize size = new ImageSize(rs.getLong(3), rs.getLong(4));
            ImageInformation information = new ImageInformation(size,
                                                                rs.getLong(6),
                                                                ImageFormat.valueOf(rs.getString(5)));
            return new Image(rs.getLong(1), rs.getLong(2), information);
        };
        return jdbcTemplate.query(sql, rowMapper, sessionId);
    }
}