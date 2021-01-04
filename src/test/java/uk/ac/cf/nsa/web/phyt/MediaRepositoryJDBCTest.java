package uk.ac.cf.nsa.web.phyt;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.jdbc.core.JdbcTemplate;


@DataJdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class MediaRepositoryJDBCTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    void testAddImage()throws Exception {

    }

}
