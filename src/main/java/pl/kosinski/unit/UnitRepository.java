package pl.kosinski.unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kosinski.client.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
