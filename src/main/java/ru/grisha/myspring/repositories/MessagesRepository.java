package ru.grisha.myspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.grisha.myspring.entity.Message;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByMessage(String message);
}
