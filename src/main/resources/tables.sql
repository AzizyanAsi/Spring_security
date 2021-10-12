
create table users(
                      username varchar not null primary key,
                      password varchar not null,
                      enabled boolean default true
);
create table authorities(
                            username varchar,
                            authority varchar,
                            primary key (username,authority),
                            constraint  fk_authorities_users foreign key (username)references users(username)
);

