create table if not exists books (id bigserial primary key, book_title varchar(255), price int);
insert into books (book_title, price) values ('Academy', 100), ('Hyperion', 80), ('Lord of the Rings', 90);