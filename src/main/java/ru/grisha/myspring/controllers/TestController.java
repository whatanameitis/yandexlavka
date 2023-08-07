package ru.grisha.myspring.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.grisha.myspring.entity.Message;
import ru.grisha.myspring.services.MessageService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
    private final MessageService messageService;
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.getById(id));
    }
    @PostMapping("")
    public ResponseEntity<Long> newMessage(@RequestBody String msg) {
        return ResponseEntity.ok(messageService.newMessage(msg));
    }
    @GetMapping("/msg/{msg}")
    public ResponseEntity<Long> getIdByMessage(@PathVariable String msg) {
        return ResponseEntity.ok(messageService.getByMessage(msg));
    }

}
