-- INSERT INTO user (id, name, email, password) VALUES (1, 'Berkay', 'Akkus', '123456');
-- INSERT INTO user (name, email, password) VALUES ('Serkan', 'Akkus', '456123');
-- INSERT INTO user (name, email, password) VALUES ('Aysema', 'Kasap', '1321654321');

INSERT INTO user (name, email, biography, nationality, birth_date, password)
VALUES ('John Doe', 'johndoe@example.com', 'Aspiring language learner', 'USA', '1990-01-01', 'secret_password');
-- This will directly use the LAST_INSERT_ID() in the next INSERT statement
INSERT INTO language_learner (user_id, last_seen_time)
VALUES (LAST_INSERT_ID(), NOW());

INSERT INTO user (name, email, biography, nationality, birth_date, password)
VALUES ('Berkay Akkuş', 'berkayakkus@example.com', 'I am Berkay', 'TR', '2000-04-26', 'password');
-- This will directly use the LAST_INSERT_ID() in the next INSERT statement
INSERT INTO language_learner (user_id, last_seen_time)
VALUES (LAST_INSERT_ID(), NOW());


-- Insert an appointment for the user with id 1 and id 2 here is the database table:
# CREATE TABLE appointment(
#                             sender_id BIGINT NOT NULL,
#                             receiver_id BIGINT NOT NULL,
#                             message VARCHAR(50),
#                             start_time DATETIME NOT NULL,
#                             end_date DATETIME NOT NULL,
#                             is_approved BIT(1),
#                             sender_rating INT,
#                             receiver_rating INT,
#                             PRIMARY KEY(sender_id , receiver_id , start_time),
#                             FOREIGN KEY (sender_id) REFERENCES language_learner(user_id),
#                             FOREIGN KEY (receiver_id ) REFERENCES language_learner(user_id)
# );
-- Insert an appointment for the user with id 1 and id 2
INSERT INTO appointment (sender_id, receiver_id, message, start_time, end_date, is_approved, sender_rating, receiver_rating)
VALUES (1, 2, 'First Appointment', '2021-05-01 10:00:00', '2021-05-01 11:00:00', 1, 5, 5);