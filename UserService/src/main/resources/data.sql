
   insert into role(role_id,role_name) values (2,'admin');
   insert into role(role_id,role_name) values (1,'user');
   insert into role(role_id,role_name) values (3,'Manager');
   
   insert into permission(permission_id,permission_name) values(1,'read_user');
   insert into permission(permission_id,permission_name) values(2,'create_user');
   insert into permission(permission_id,permission_name) values(3,'update_user');
   insert into permission(permission_id,permission_name) values(4,'delete_user');
   insert into permission(permission_id,permission_name) values(5,'read_users');
   insert into permission(permission_id,permission_name) values(6,'read_utility');
   insert into permission(permission_id,permission_name) values(7,'create_utility');
   insert into permission(permission_id,permission_name) values(8,'update_utility');
   
   


INSERT INTO USER (user_id,user_name,password,contact_number ,rating,role_role_id) VALUES (
   1, 'Sam','aaaa',43243,5,2);

INSERT INTO USER (user_id,user_name,password,contact_number ,rating,role_role_id) VALUES (
   2, 'Gaby','aaaa',43243,5,1); 
   
INSERT INTO USER (user_id,user_name,password,contact_number ,rating,role_role_id) VALUES (
   3, 'Jim','aaaa',42435,3,3); 
   

   
   
   
   insert into role_permission (role_id,permission_id) values (1,1);
   insert into role_permission (role_id,permission_id) values (1,2);
   insert into role_permission (role_id,permission_id) values (1,3);
   insert into role_permission (role_id,permission_id) values (1,4);
   insert into role_permission (role_id,permission_id) values (1,5);
   insert into role_permission (role_id,permission_id) values (2,1);
   insert into role_permission (role_id,permission_id) values (2,2);
   insert into role_permission (role_id,permission_id) values (2,3);
   insert into role_permission (role_id,permission_id) values (2,4);
   insert into role_permission (role_id,permission_id) values (2,5);
   insert into role_permission (role_id,permission_id) values (2,6);
   insert into role_permission (role_id,permission_id) values (2,7);
   insert into role_permission (role_id,permission_id) values (2,8);
   insert into role_permission (role_id,permission_id) values (3,1);
   insert into role_permission (role_id,permission_id) values (3,2);
   insert into role_permission (role_id,permission_id) values (3,3);
   insert into role_permission (role_id,permission_id) values (3,4);
   insert into role_permission (role_id,permission_id) values (3,5);
   insert into role_permission (role_id,permission_id) values (3,6);
   insert into role_permission (role_id,permission_id) values (3,7);
--   insert into role_permission (role_id,permission_id) values ();
--   insert into role_permission (role_id,permission_id) values ();
   
   
   
   
