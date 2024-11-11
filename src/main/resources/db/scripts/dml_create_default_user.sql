INSERT INTO users (login, password, role)
VALUES ('admin', '$2a$10$1O96CtxbO7frjP5F3eyLN.QKNhJoK.aDhYC6D6DaQ/SLPeV3Iggpu', 'ADMIN')
ON CONFLICT DO NOTHING;