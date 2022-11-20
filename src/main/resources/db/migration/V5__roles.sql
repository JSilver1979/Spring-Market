CREATE TABLE IF NOT EXISTS market_roles (id bigserial primary key, name varchar(255));
INSERT INTO market_roles(name)
VALUES
    ('ROLE_USER'),
    ('ROLE_ADMIN');