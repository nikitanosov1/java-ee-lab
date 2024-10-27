# Лабораторная работа #1 по курсу "Архитектура корпоративных систем"

Команда для запуска БД PostgreSQL в докер контейнере
```bash
docker run --name my-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -v pgdata:/var/lib/postgresql/data -d postgres
```

