CREATE TABLE IF NOT EXISTS users_roles (user_id bigint, role_id bigint,
    constraint fk_users foreign key (user_id) references market_users(id),
    constraint fk_roles foreign key (role_id) references market_roles(id));
INSERT INTO users_roles(user_id, role_id)
VALUES
    (1,1),
    (2,1),
    (2,2);