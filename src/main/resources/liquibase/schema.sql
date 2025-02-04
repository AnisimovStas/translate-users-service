--liquibase formatted sql

--changeset anisimovSA:USERS.create_schema
CREATE SCHEMA IF NOT EXISTS users;
