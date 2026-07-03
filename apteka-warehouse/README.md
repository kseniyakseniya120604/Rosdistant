# Аптечный склад — учебное веб-приложение (Java EE)

Учебный проект по модулю «Технологии конструирования программного обеспечения».
Предметная область — вариант 2, «Аптечный склад».

## Структура репозитория

```
webapp/
  task2/   — задание 2: JSP-страницы + модель (JavaBean, in-memory)
  task3/   — задание 3: + сервлет-контроллер, web.xml, jspf-сегменты
  task4/   — задание 4: + JPA-сущность, EJB-компонент, JDBC-пул, SQL-скрипт
docs/
  Задание_1_Бирюкова.docx  — отчёт: развёртывание среды разработки
  Задание_2_Бирюкова.docx  — отчёт: разработка JSP-страниц (MVC)
  Задание_3_Бирюкова.docx  — отчёт: дескриптор развёртывания и сервлет
  Задание_4_Бирюкова.docx  — отчёт: JDBC-пул, JPA, EJB
```

Каждая папка `task2`/`task3`/`task4` — самостоятельная стадия одного и того же
приложения: код каждой следующей стадии дополняет предыдущую (task3 добавляет
сервлет к task2, task4 добавляет JPA/EJB к task3).

## Как развернуть

1. Установить JDK 8, GlassFish 5.1, MySQL Server, NetBeans IDE — см.
   `docs/Задание_1_Бирюкова.docx`.
2. Для task4 — выполнить `webapp/task4/sql/init.sql` на MySQL и настроить
   пул соединений в GlassFish — см. `docs/Задание_4_Бирюкова.docx`.
3. Открыть соответствующую папку (`task2`, `task3` или `task4`) как проект
   Java Web Application в NetBeans, добавить сервер GlassFish 5, выполнить
   Clean and Build → Deploy.

## Публикация на GitLab

```bash
cd webapp-apteka         # корень репозитория с этим README
git init
git add .
git commit -m "Аптечный склад: задания 1-4"
git remote add origin https://gitlab.com/<ваш-логин>/apteka-warehouse.git
git branch -M main
git push -u origin main
```

После этого в отчётах указывается ссылка на созданный репозиторий,
например: `https://gitlab.com/<ваш-логин>/apteka-warehouse`.
