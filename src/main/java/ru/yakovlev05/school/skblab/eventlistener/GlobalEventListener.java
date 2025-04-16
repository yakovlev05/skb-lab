package ru.yakovlev05.school.skblab.eventlistener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.yakovlev05.school.skblab.entity.Message;
import ru.yakovlev05.school.skblab.eventlistener.event.EmailSendEvent;
import ru.yakovlev05.school.skblab.eventlistener.event.MessageCreatedEvent;
import ru.yakovlev05.school.skblab.eventlistener.event.MessageReceivedEvent;
import ru.yakovlev05.school.skblab.service.MessageService;

@Slf4j
@RequiredArgsConstructor
@Component
public class GlobalEventListener {

    private final MessageService messageService;

    @EventListener
    public void handleMessageReceivedEvent(MessageReceivedEvent event) {
        log.info("Обработка handleMessageReceivedEvent");
        log.info("Получено сообщение с текстом: {}", event.messageContent());
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleMessageCreatedEvent(MessageCreatedEvent event) {
        log.info("Обработка handleMessageCreatedEvent");

        // Все сообщения должны быть радостными
        Message message = messageService.getById(event.messageId());

        if (!message.getContent().endsWith("!")) {
            message.setContent(message.getContent() + "!");
        }

        messageService.save(message);
    }

    @Async
    @EventListener
    public void handleEmailSendEvent(EmailSendEvent event) throws InterruptedException {
        log.info("Обработка handleEmailSendEvent");

        // Отправляем сообщение...
        Thread.sleep(2000);
    }

}
