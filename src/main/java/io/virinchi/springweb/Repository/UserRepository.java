package io.virinchi.springweb.Repository;

import io.virinchi.springweb.Model.UserTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//@Repository - communicates with the MODEL table for CRUD Operations
//Rule:
//1.Model table needs to be provided to REPOSITORY
//2. CRUD Operations needs to be extended by REPOSITORY
@Repository
public interface UserRepository extends JpaRepository<UserTbl, Integer> {
//Custom function however, notice that existsBy function is provided by repo itself

boolean existsByUsernameAndPassword(String username, String password);

}
