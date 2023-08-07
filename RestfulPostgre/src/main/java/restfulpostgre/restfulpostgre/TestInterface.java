package restfulpostgre.restfulpostgre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//import java.util.Operation;

//import mainApplication.Database;
//import org.springframework.stereotype.Component;

@Repository
public interface TestInterface extends JpaRepository<Database, Long> {
    List<Database> findBySalamContainingIgnoreCase(String string);
}