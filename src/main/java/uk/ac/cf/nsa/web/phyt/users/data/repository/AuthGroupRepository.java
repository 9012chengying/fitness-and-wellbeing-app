package uk.ac.cf.nsa.web.phyt.users.data.repository;

import org.springframework.stereotype.Repository;
import uk.ac.cf.nsa.web.phyt.users.data.DTO.Authorities;
import java.util.List;

@Repository
public interface AuthGroupRepository {

    List<Authorities> findByUserName(String username);
}
