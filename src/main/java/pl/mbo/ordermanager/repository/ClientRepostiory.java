package pl.mbo.ordermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbo.ordermanager.model.Client;

public interface ClientRepostiory extends JpaRepository<Client, Long> {
}
