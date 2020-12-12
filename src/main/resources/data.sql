
INSERT INTO roles (name) VALUES
('ROLE_ADMIN'),
('ROLE_USER');


INSERT INTO users(user_name,password,active)
    values('user','pass',true);

INSERT INTO users(user_name,password,active)
    values('admin','pass',true);

insert into user_role(user_id, role_id)
    values (1,1), (1,2);



