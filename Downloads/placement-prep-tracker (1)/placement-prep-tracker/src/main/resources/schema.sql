CREATE DATABASE IF NOT EXISTS placement_tracker;
USE placement_tracker;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL
);

CREATE TABLE aptitude_topic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at DATE NOT NULL
);

CREATE TABLE aptitude_attempt (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    score DOUBLE NOT NULL,
    attempt_date DATE NOT NULL,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (topic_id) REFERENCES aptitude_topic(id) ON DELETE CASCADE
);

CREATE TABLE coding_topic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    difficulty VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL
);

CREATE TABLE coding_problem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    topic_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    difficulty VARCHAR(50) NOT NULL,
    solved BOOLEAN NOT NULL DEFAULT FALSE,
    solved_date DATE,
    notes TEXT,
    FOREIGN KEY (topic_id) REFERENCES coding_topic(id) ON DELETE CASCADE
);

CREATE TABLE company (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    package DOUBLE,
    website VARCHAR(255),
    created_at DATE NOT NULL
);

CREATE TABLE company_stage (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    company_id BIGINT NOT NULL,
    stage_name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    stage_date DATE NOT NULL,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE
);

CREATE TABLE mock_interview (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    company_id BIGINT,
    interview_date DATE NOT NULL,
    interviewer_name VARCHAR(255),
    feedback TEXT,
    rating DOUBLE,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE SET NULL
);
