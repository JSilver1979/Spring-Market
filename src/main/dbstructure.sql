/* --- Таблица пользователей ---
   Предназначена для хранения пользовательских данных:
   - Имя пользователя
   - Фамилия пользователя
   - логин пользователя
   - пароль пользователя
   - адрес электронной почты
 */
create table if not exists users
(
    id           bigserial primary key,
    user_name    varchar(255),
    user_surname varchar(255),
    mail         varchar(255),
    user_login   varchar(255),
    user_pwd     varchar(255)
);
/* --- Таблица пользовательских ролей ---
   Предназначена для хранения информации о пользовательских ролях
   использующихся в реализации правил доступа
 */
create table if not exists roles
(
    id        bigserial primary key,
    role_name varchar(255)
);
/* --- Вспомогательная таблица ---
   Предназначена для реализации связи "многие ко многим"
   таблиц users и roles
 */
create table if not exists users_roles
(
    user_id bigint,
    role_id bigint,
    constraint fk_users foreign key (user_id) references users (id),
    constraint fk_roles foreign key (role_id) references roles (id)
);
/* --- Таблица товаров ---
   Предназначена для хранения даных о товаре:
   - Наименование
   - Описание
   - цена
   Таблица имеет связь с таблицей категорий
   Отношение "много товаров к одной категории"
 */
create table if not exists products
(
    id          bigserial primary key,
    title       varchar(255),
    description varchar(255),
    price       decimal(10, 2),
    category_id bigint,
    constraint fk_category foreign key (category_id) references categories (id)
);
/* --- Таблица категорий ---
    Предназначена для хранения данных о категориях товаров.
   Имеет только 1 поле - наименование.
 */
create table if not exists categories
(
    id    bigserial primary key,
    title varchar(255)
);
/* --- Таблица заказов ---
   Предназначена для хранения номера заказа (id),
   статуса заказа, а также идентификатора пользователя
   для реализации связи пользователя и заказа
   "один пользователь много заказов"
   и идентифиактора адреса доставки для реализации связи
   "1 адрес много заказов"
 */
create table if not exists orders
(
    id          bigserial primary key,
    user_id     bigint,
    delivery_id bigint,
    status      varchar(255),
    constraint fk_user foreign key (user_id) references users (id),
    constraint fk_delivery foreign key (delivery_id) references delivery_address (id)
);
/* --- Вспомогательная таблица ---
   Используется для реализации связи "многие ко многим"
   для таблиц продуктов и заказов
 */
create table if not exists products_orders
(
    product_id bigint,
    order_id   bigint,
    constraint fk_product foreign key (product_id) references products (id),
    constraint fk_order foreign key (order_id) references orders (id)
);
/* --- Таблица адреса доставки ---
   Предназначена для хранения информации об адресах доставки
   и дополнительной информации от клиента
   номер дома не поставлен как int потому что там может использоваться символ дроби
 */
create table if not exists delivery_address
(
    id              bigserial primary key,
    city            varchar(255),
    street          varchar(255),
    building_number varchar(10),
    entrance        int,
    room            int,
    add_info        varchar(255)
);
