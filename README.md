# ДЗ: 8. Spring security

Реализовал три контроллера, в каждом по одному эндпоинту

- public/api - `PublicController` - работает без логина/пароля
- admin/api - `AdminController` - работает с пользователем, если у него есть роль _ADMIN_
- support/api - `SupportController` - работает с пользователем, если у него роль _SUPPORT_

Защищённые эндпоинты возвращают информацию по пользователю.

Существующие пользователи:

1. admin/admin - роль _ADMIN_
2. support/support - роль _SUPPORT_
3. superuser/superuser - роль _ADMIN, SUPPORT_

