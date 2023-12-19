-- INSERT INTO user (id, name, email, password) VALUES (1, 'Berkay', 'Akkus', '123456');
-- INSERT INTO user (name, email, password) VALUES ('Serkan', 'Akkus', '456123');
-- INSERT INTO user (name, email, password) VALUES ('Aysema', 'Kasap', '1321654321');

INSERT INTO user (name, email, biography, nationality, birth_date, password)
VALUES ('John Doe', 'johndoe@example.com', 'Aspiring language learner', 'USA', '1990-01-01', 'secret_password');

-- This will directly use the LAST_INSERT_ID() in the next INSERT statement
INSERT INTO language_learner (user_id, last_seen_time)
VALUES (LAST_INSERT_ID(), NOW());

