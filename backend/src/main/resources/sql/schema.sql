
DROP TABLE IF EXISTS notification;
DROP TABLE IF EXISTS learning_session;
DROP TABLE IF EXISTS target_language;
DROP TABLE IF EXISTS native_language;
DROP TABLE IF EXISTS knows;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS feedback;
DROP TABLE IF EXISTS resource;
DROP TABLE IF EXISTS announcement;
DROP TABLE IF EXISTS follows;
DROP TABLE IF EXISTS contact_request;
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS language_learner;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS user;


CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT,
    name VARCHAR(48) NOT NULL,
    email VARCHAR(48) NOT NULL,
    biography VARCHAR(140),
    nationality VARCHAR(48),
    birth_date DATE NOT NULL,
    password VARCHAR(32) NOT NULL,
    suspense_date DATETIME,
    -- suspense_admin_id BIGINT,
    PRIMARY KEY (user_id)
    -- FOREIGN KEY (suspense_admin_id) REFERENCES admin(user_id)
);

CREATE TABLE language_learner (
    user_id BIGINT NOT NULL,
    last_seen_time DATETIME,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    PRIMARY KEY (user_id)
);

CREATE TABLE admin (
    user_id BIGINT NOT NULL,
    start_date DATE,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    PRIMARY KEY(user_id)
);

CREATE TABLE teacher (
    user_id BIGINT NOT NULL,
    session_price_per_hour FLOAT,
    is_approved BIT(1) NOT NULL,
    request_date DATETIME,
    response_date DATETIME,
    activation_admin_id BIGINT,
    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (activation_admin_id) REFERENCES admin(user_id)
);

CREATE TABLE feedback(
    f_id INT AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    content VARCHAR(150) NOT NULL,
    PRIMARY KEY (f_id)
);

CREATE TABLE notification(
    n_id INT AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    description VARCHAR(50) NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (n_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE language(
    language_id INT AUTO_INCREMENT,
    language_name VARCHAR(48) NOT NULL,
    PRIMARY KEY (language_id)
);

CREATE TABLE learning_session(
    session_id INT AUTO_INCREMENT,
    is_cancelled BIT(1),
    rating FLOAT,
    learner_id BIGINT NOT NULL,
    grade INT,
    teacher_id BIGINT NOT NULL,
    language_id INT NOT NULL,
    f_id INT NOT NULL,
    start_date_time DATETIME NOT NULL,
    end_date_time DATETIME NOT NULL,
    PRIMARY KEY (session_id),
    FOREIGN KEY (learner_id) REFERENCES language_learner(user_id),
    FOREIGN KEY (teacher_id ) REFERENCES teacher(user_id),
    FOREIGN KEY (language_id) REFERENCES language(language_id),
    FOREIGN KEY (f_id) REFERENCES feedback(f_id)
);

CREATE TABLE resource(
    r_id INT AUTO_INCREMENT,
    title VARCHAR(48) NOT NULL,
    content VARCHAR(150),
    teacher_id BIGINT NOT NULL,
    PRIMARY KEY (r_id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(user_id)
);

CREATE TABLE announcement(
    a_id INT AUTO_INCREMENT,
    title VARCHAR(48) NOT NULL,
    content VARCHAR(150),
    teacher_id BIGINT NOT NULL,
    PRIMARY KEY (a_id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(user_id)
);

CREATE TABLE target_language(
    learner_id BIGINT NOT NULL,
    language_id INT NOT NULL,
    proficiency_level VARCHAR(30) NOT NULL,
    PRIMARY KEY (learner_id, language_id),
    FOREIGN KEY (learner_id) REFERENCES language_learner(user_id),
    FOREIGN KEY (language_id) REFERENCES language(language_id)
);

CREATE TABLE knows(
    teacher_id BIGINT NOT NULL,
    language_id INT NOT NULL,
    PRIMARY KEY (teacher_id, language_id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(user_id),
    FOREIGN KEY (language_id) REFERENCES language(language_id)
);

CREATE TABLE follows(
    follower_id BIGINT NOT NULL,
    following_id BIGINT NOT NULL,
    PRIMARY KEY(follower_id, following_id),
    FOREIGN KEY (follower_id) REFERENCES user(user_id),
    FOREIGN KEY (following_id) REFERENCES user(user_id)
);

CREATE TABLE native_language(
    user_id BIGINT NOT NULL,
    language_id INT NOT NULL,
    PRIMARY KEY(user_id, language_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (language_id) REFERENCES language(language_id)
);

CREATE TABLE contact_request(
    sender_id BIGINT NOT NULL,
    receiver_id BIGINT NOT NULL,
    is_approved BIT(1),
    PRIMARY KEY(sender_id , receiver_id),
    FOREIGN KEY (sender_id) REFERENCES language_learner(user_id),
    FOREIGN KEY (receiver_id ) REFERENCES language_learner(user_id)
);

CREATE TABLE appointment(
    sender_id BIGINT NOT NULL,
    receiver_id BIGINT NOT NULL,
    message VARCHAR(50),
    start_time DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    is_approved BIT(1),
    sender_rating INT,
    receiver_rating INT,
    PRIMARY KEY(sender_id , receiver_id),
    FOREIGN KEY (sender_id) REFERENCES language_learner(user_id),
    FOREIGN KEY (receiver_id ) REFERENCES language_learner(user_id)
);



