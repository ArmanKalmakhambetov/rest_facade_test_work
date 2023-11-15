-- Добавление тестовых данных для таблицы students
INSERT INTO students (first_name, last_name, email)
VALUES ('John', 'Doe', 'john.doe@example.com'),
       ('Jane', 'Smith', 'jane.smith@example.com'),
       ('Bob', 'Johnson', 'bob.johnson@example.com');

-- Добавление тестовых данных для таблицы courses
INSERT INTO courses (name_of_course)
VALUES ('Computer Science'),
       ('Mathematics'),
       ('Physics');

-- Добавление связей между студентами и курсами
INSERT INTO student_course (student_id, course_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 3);
