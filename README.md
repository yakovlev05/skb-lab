# ДЗ: 9. Application Events and Listeners
Создал три EventListener'а:
- async
- обычный
- Transactional

### обычный Listener
- Событие: MessageReceivedEvent
- Действие: просто логирует


### async Listener
- Событие: EmailSendEvent
- Действие: эмулирует работу по отправке письма


### transactional Listener
- Событие: MessageCreatedEvent
- Описание: обрабатывает до коммита транзакции, изменяет сообщение (добавляет в конец `!`, если его нет)
- Событие порождается два раза: в транзакции и без неё, во втором случае событие не обрабатывается.

Также добавил логирование на порождении и обработке