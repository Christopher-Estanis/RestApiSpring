package br.edu.uniso.apicombanco.Repository;

import br.edu.uniso.apicombanco.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepository extends JpaRepository<User, Long> {}
