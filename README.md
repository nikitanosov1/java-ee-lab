# Лабораторная работа #1 по курсу "Архитектура корпоративных систем"

## О сервисе
Сервис предоставляет возможность создавать владельцев автомобителей и сами автомобили. Владельны связаны с авто как один ко многим. Также имеется возможность удалять владельцев и авто, а также обновлять их. При удалении владельца также удаляются все его автомобили.

## Кто выполнил
6132 Лаптев Владислав
6132 Носов Никита

## Общая информация по стеку
Java 17, Jakarta 9, Hibernate 5.5.3.Final, GlassFish 6.2.5

GlassFish устанавливался [отсюда](https://glassfish.org/download). Полное название: Eclipse GlassFish 6.2.5, Jakarta EE Platform, 9.1

## Подготовка к запуску
Команда для запуска БД PostgreSQL в докер контейнере
```bash
docker run --name my-postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -v pgdata:/var/lib/postgresql/data -d postgres
```

# Используемые сущности

В проекте используются две сущности: Car и Owner

Car содержит id (УИД), brand (бренд машины), modelName (название модели)
Owner содержит id (УИД), firstName (имя), lastName (фамилия), birthdate (дата рождения)

Диаграмма БД выглядит следующим образом: ![image](https://github.com/user-attachments/assets/a6412184-1a26-4c25-82ac-522ce57b02e7)


# Демо работы

![image](https://github.com/user-attachments/assets/e90e266c-a9bb-4332-9413-16b289daaf06)
![image](https://github.com/user-attachments/assets/61b3de8d-a896-49f3-8314-cd929bec6402)
![image](https://github.com/user-attachments/assets/9f68ac5f-3102-4d77-9c80-6e48fb2e968b)
![image](https://github.com/user-attachments/assets/129ad1e0-b274-4dcb-8f36-669aa6150733)
Удаляем ownerId = 9:
![image](https://github.com/user-attachments/assets/0a6c8fc0-51ca-4a79-b672-85a3770d915a)




