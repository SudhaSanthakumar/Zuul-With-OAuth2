
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
   1, 'Sam','{bcrypt}$2y$12$WBcP53NiC20Gyksn2nN5SOttJWN.kdHQz71Vt7pkSQXVbcqx/trVK',43243,5,2);

INSERT INTO USER (user_id,user_name,password,contact_number ,rating,role_role_id) VALUES (
   2, 'Gaby','{bcrypt}$2y$12$WBcP53NiC20Gyksn2nN5SOttJWN.kdHQz71Vt7pkSQXVbcqx/trVK',43243,5,1); 
   
INSERT INTO USER (user_id,user_name,password,contact_number ,rating,role_role_id) VALUES (
   3, 'Sudha Santha Kumar','sudha.santhakumar@gmail.com',42435,3,3); 
   

   
   
   
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
   
   
   
   
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	1,
	'User', 
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/welcome,http://localhost:8085/login,http://localhost:8084/callback,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource,oauth2-resource',null,'false'
	);
	

	   
   
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	2,
	'Util', 
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource,oauth2-resource',null,'false'
	);
	
	
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	3,
	'Utility', 
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource,oauth2-resource',null,'false'
	);
	
		
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	4,
	'oauthclient1', 
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/forwardLogin,http://localhost:8084/welcome', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource,oauth2-resource',null,'false'
	);
	
		
INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	5,
	'mvcClient', 
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login,http://localhost:8084/callback', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource,oauth2-resource',null,'false'
	);
	
	
	INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	6,
	'oauth2', 
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/login', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource,oauth2-resource',null,'false'
	);
	

	INSERT INTO oauth_client_details (
	id,
	client_id, 
	client_secret, 
	scope, 
	authorized_grant_types,
	web_server_redirect_uri, 
	authorities, 
	access_token_validity,
	refresh_token_validity,resource_ids, additional_information, autoapprove
	 )
VALUES
	(
	7,
	'Zuul', 
	'{bcrypt}$2y$12$s/vsquzVWfiEf/CmWPrHn.8U0febzYnF6pmvhPljJU4MVWwXgdiF.', 
	'foo,read,write',
	'password,authorization_code,refresh_token,client_credentials', 
	'http://localhost:8082/login,http://localhost:8083/login,http://localhost:8084/welcome', 
	'ROLE_CLIENT', 
	36000, 
	36000,
	'user-resource,utility-resource,zuul-resource,oauth2-resource',null,'false'
	);
	
	