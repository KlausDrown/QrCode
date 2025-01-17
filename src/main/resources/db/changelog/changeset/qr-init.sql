CREATE SCHEMA IF NOT EXISTS qr;
CREATE TABLE IF NOT EXISTS qr.code(
    id bigint PRIMARY KEY,
    qr varchar
);