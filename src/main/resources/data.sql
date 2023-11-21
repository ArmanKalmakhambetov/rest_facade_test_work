-- Добавление тестовых данных для таблицы students
INSERT INTO students (first_name, last_name, email)
VALUES ('Иван', 'Иванов', 'ivanov@mail.ru'),
       ('Петр', 'Петров', 'petrov@mail.ru'),
       ('Максим', 'Сидоров', 'sidorov@mail.ru');

-- Добавление тестовых данных для таблицы courses
INSERT INTO courses (name_of_course)
VALUES ('Информатика'),
       ('Математика'),
       ('Физика');

-- Добавление связей между студентами и курсами
INSERT INTO student_course (student_id, course_id)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (3, 2),
       (3, 3);
