package ru.grisha.myspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.grisha.myspring.entity.Courier;

@Repository
public interface CouriersRepository extends JpaRepository<Courier, Long> {

}