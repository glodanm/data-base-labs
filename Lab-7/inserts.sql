-- FILL TABLES
-- POSITION
INSERT INTO position (
name
)
VALUES 
('Doctor'),
('IT-specialist'),
('Lawyer');


-- ACADEMIC_STATUS
INSERT INTO academic_status (
name
)
VALUES 
('docent'),
('professor'),
('none');


-- DEGREE
INSERT INTO degree (
name
)
VALUES 
('KTN'),
('DTN'),
('None');


-- COWORKER
INSERT INTO coworker (
surname, 
name, 
seniority, 
dob, 
passport_number, 
position_id,
academic_status_id, 
degree_id
)
VALUES 
('Petrych', 'Petro', '4', '2003-12-23', 'DF-145648', '1', '1', '1'),
('Markych', 'Mark', '5', '1997-05-30', 'DG-245678', '2', '1', '3'),
('Vasich', 'Vasia', '0', '1923-11-11', 'DA-345678', '3', '2', '2');


-- ASSESSMENT
INSERT INTO assessment (
name
)
VALUES 
('examination'),
('test');


-- DISCIPLINE
INSERT INTO discipline (
name, 
semester_number, 
code, 
assessment_id
)
VALUES 
('Medicine', '1', '3453', '1'),
('IT', '1', '9877', '2'),
('Philology', '1', '2343', '1');


-- COWORKER_DISCIPLINE
INSERT INTO coworker_discipline (
coworker_id, 
discipline_id
)
VALUES 
('1', '1'),
('2', '2'),
('3', '3');