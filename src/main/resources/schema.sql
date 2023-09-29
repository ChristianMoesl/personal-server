create table if not exists "todo"
(
    id         serial       not null primary key,
    text       varchar(255) not null,
    is_done    bool         not null,
    created_at timestamp    not null
);
