INSERT INTO users(active,password,roles,user_name)
    values(true,'pass','ROLE_USER','user');

INSERT INTO users(active,password,roles,user_name)
    values(true,'pass','ROLE_ADMIN','admin');

INSERT INTO authorities(username,authority)
    values('user','ROLE_USER');
INSERT INTO authorities(username,authority)
    values('admin','ROLE_ADMIN');