--liquibase formatted sql

--changeset anisimovSA:USERS.create_user
CREATE TABLE IF NOT EXISTS users.users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL,
    email    VARCHAR(32),
    role     VARCHAR(32) DEFAULT 'ROLE_USER'
);
--changeset anisimovSA:USERS.alter_fields
ALTER TABLE IF EXISTS users.users
ALTER COLUMN password TYPE text;
