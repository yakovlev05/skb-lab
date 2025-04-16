package ru.yakovlev05.school.skblab.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.yakovlev05.school.skblab.dto.MessageIn;
import ru.yakovlev05.school.skblab.entity.Message;
import ru.yakovlev05.school.skblab.eventlistener.event.EmailSendEvent;
import ru.yakovlev05.school.skblab.eventlistener.event.MessageCreatedEvent;
import ru.yakovlev05.school.skblab.eventlistener.event.MessageReceivedEvent;
import ru.yakovlev05.school.skblab.repository.MessageRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageService {

    public final MessageRepository messageRepository;

    private final ApplicationEventPublisher applicationEventPublisher;


    @Transactional
    public void createMessage(MessageIn messageIn) {
        log.info("Публикация MessageReceivedEvent");
        applicationEventPublisher.publishEvent(new MessageReceivedEvent(messageIn.content()));

        Message message = new Message();
        message.setContent(messageIn.content());

        messageRepository.save(message);

        log.info("Публикация MessageCreatedEvent");
        applicationEventPublisher.publishEvent(new MessageCreatedEvent(message.getId()));

        log.info("Публикация EmailSendEvent");
        applicationEventPublisher.publishEvent(new EmailSendEvent("example@example.com"));
    }

    public Message getById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Сообщение с id " + id + " не найдено"));
    }

    public void save(Message message) {
        messageRepository.save(message);
    }

    // Нет транзакции - значит листенер с @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT) не сработает
    public void updateMessage(Long id, MessageIn messageIn) {
        Message message = getById(id);
        message.setContent(messageIn.content());
        messageRepository.save(message);

        log.info("Публикация MessageCreatedEvent");
        applicationEventPublisher.publishEvent(new MessageCreatedEvent(message.getId()));
    }
}
