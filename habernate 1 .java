CREATE TABLE Person (
    person_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL
);
CREATE TABLE PassportDetails (
    passport_id INT PRIMARY KEY,
    passport_number VARCHAR(50) NOT NULL UNIQUE,
    issue_date DATE NOT NULL,
    expiry_date DATE NOT NULL,
    person_id INT UNIQUE,
    FOREIGN KEY (person_id) REFERENCES Person(person_id)
);
INSERT INTO Person (person_id, name, date_of_birth)
VALUES (1, 'John Doe', '1980-01-01');
INSERT INTO PassportDetails (passport_id, passport_number, issue_date, expiry_date, person_id)
VALUES (1, 'A1234567', '2020-01-01', '2030-01-01', 1);
SELECT p.person_id, p.name, p.date_of_birth, pd.passport_number, pd.issue_date, pd.expiry_date
FROM Person p
LEFT JOIN PassportDetails pd ON p.person_id = pd.person_id;
