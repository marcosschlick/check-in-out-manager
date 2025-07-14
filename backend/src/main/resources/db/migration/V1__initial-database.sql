-- users table
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    document VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    birth_date DATE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    image_url VARCHAR(255),
    created_at DATETIME NOT NULL,
    deactivated_at DATETIME
);

-- events table
CREATE TABLE events (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(6) NOT NULL UNIQUE,
    owner_id BIGINT NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    created_at DATETIME NOT NULL,
    deactivated_at DATETIME,
    FOREIGN KEY (owner_id) REFERENCES users(id)
);

-- sessions table
CREATE TABLE sessions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT,
    event_id BIGINT NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    created_at DATETIME NOT NULL,
    deactivated_at DATETIME,
    FOREIGN KEY (event_id) REFERENCES events(id)
);

-- attendance records table
CREATE TABLE attendances (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    session_id BIGINT NOT NULL,
    check_in_time DATETIME NOT NULL,
    check_out_time DATETIME,
    created_at DATETIME NOT NULL,
    deactivated_at DATETIME,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (session_id) REFERENCES sessions(id)
);
