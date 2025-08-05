CREATE TABLE author(
    id SERIAL PRIMARY KEY,
    name VARCHAR(127)
);

CREATE TABLE reader(
    id SERIAL PRIMARY KEY,
    name VARCHAR(127)
);

CREATE TABLE book(
    id SERIAL PRIMARY KEY,
    title VARCHAR(127),
    author_id INT REFERENCES author(id),
    count INT
);

CREATE TABLE reader_book(
    reader_id INT NOT NULL REFERENCES reader(id),
    book_id INT NOT NULL REFERENCES book(id),
    PRIMARY KEY (reader_id, book_id)
);

INSERT INTO author (name) VALUES
                              ('Лев Толстой'),
                              ('Фёдор Достоевский'),
                              ('Александр Пушкин'),
                              ('Николай Гоголь'),
                              ('Антон Чехов');

INSERT INTO book (title, author_id, count) VALUES
                                               ('Война и мир', 1, 10),
                                               ('Преступление и наказание', 2, 7),
                                               ('Евгений Онегин', 3, 5),
                                               ('Мёртвые души', 4, 8),
                                               ('Вишнёвый сад', 5, 4),
                                               ('Анна Каренина', 1, 6),
                                               ('Идиот', 2, 3);

INSERT INTO reader (name) VALUES
                              ('Иван Петров'),
                              ('Мария Иванова'),
                              ('Алексей Смирнов'),
                              ('Ольга Кузнецова'),
                              ('Дмитрий Соколов');
