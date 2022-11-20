CREATE TABLE IF NOT EXISTS market_users (id bigserial primary key, login varchar(255), password varchar(255));
INSERT INTO market_users(login, password)
VALUES
    ('user', 'user'),
    ('admin', 'admin');