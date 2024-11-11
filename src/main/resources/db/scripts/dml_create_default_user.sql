INSERT INTO users (login, password, role)
VALUES ('admin', '$2a$10$1Q7Z6', 'ADMIN')
ON CONFLICT DO NOTHING;