CREATE DATABASE zeitplan_api;

USE zeitplan_api;

CREATE TABLE IF NOT EXISTS users(
    username            VARCHAR(100) NOT NULL,
    password            VARCHAR(100) NOT NULL,
    name                VARCHAR(100) NOT NULL,
    token               VARCHAR(100),
    token_expired_at    BIGINT,
    PRIMARY KEY (username),
    UNIQUE (token)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS projects(
    id                  VARCHAR(100) NOT NULL,
    username            VARCHAR(100) NOT NULL,
    title               VARCHAR(100) NOT NULL,
    description         LONGTEXT,
    status              ENUM("NOT_STARTED","ON_PROGRESS","PENDING","DONE","ABORTED"),
    deadline            DATE,
    PRIMARY KEY (id),
    FOREIGN KEY fk_users_projects (username) REFERENCES users(username)
) ENGINE InnoDB;

CREATE TABLE IF NOT EXISTS clients(
    id                  VARCHAR(100) NOT NULL,
    project_id          VARCHAR(100) NOT NULL,
    name                VARCHAR(100) NOT NULL,
    email               VARCHAR(100),
    phone               VARCHAR(100),
    address             VARCHAR(100),
    PRIMARY KEY (id),
    FOREIGN KEY fk_projects_clients (project_id) REFERENCES projects(id)
) ENGINE InnoDB;
