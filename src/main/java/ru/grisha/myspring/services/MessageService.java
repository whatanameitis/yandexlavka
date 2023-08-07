package ru.grisha.myspring.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.grisha.myspring.entity.Message;
import ru.grisha.myspring.repositories.MessagesRepository;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessagesRepository messagesRepository;

    public Long newMessage(String message) {
        final Message msg = messagesRepository.save(Message.builder().message(message).build());
        return msg.getId();
    }

    public Message getById(Long id) {
        return messagesRepository.findById(id).orElse(Message.builder().build());
    }
    public Long getByMessage(String message) {
        return messagesRepository.findAllByMessage(message).stream().findFirst().orElse(Message.builder().build()).getId();
    }
}
