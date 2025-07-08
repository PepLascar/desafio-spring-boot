-- Insert Users
INSERT INTO app_users (username, email) VALUES ('Jose Lascar', 'peplascar@gmail.com');
INSERT INTO app_users (username, email) VALUES ('Antonio Saavedra', 'antonio@gmail.com');
INSERT INTO app_users (username, email) VALUES ('Constanza', 'conie@liquo.com');

-- Insert Tasks
INSERT INTO tasks (title, description, completed, created_at, user_id) VALUES ('Create readme', 'Add fully step readme', FALSE, '2025-07-01', 1);
INSERT INTO tasks (title, description, completed, created_at, user_id) VALUES ('Handle exceptions', 'Finish exception handling', FALSE, '2025-07-01', 1);
INSERT INTO tasks (title, description, completed, created_at, user_id) VALUES ('Implement Eureka', 'Expose local host in Eureka', TRUE, '2025-07-01', 2);
INSERT INTO tasks (title, description, completed, created_at, user_id) VALUES ('Improve task logic', 'Create add massive task', FALSE, '2025-07-01', 3);
INSERT INTO tasks (title, description, completed, created_at, user_id) VALUES ('Add all task you want', 'Create backlog task for developer', FALSE, '2025-07-01' ,3);