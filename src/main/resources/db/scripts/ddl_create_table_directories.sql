CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS directories (
    id uuid DEFAULT uuid_generate_v4() NOT NULL,
    name VARCHAR(255) UNIQUE NOT NULL
);