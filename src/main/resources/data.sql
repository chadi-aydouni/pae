insert into
    Course (id, title, credits)
values ('INT1', 'Introductions', 10),
    ('MAT1', 'Mathématiques II', 3),
    ('CAI1', 'Anglais I', 2),
    ('DEV1', 'Développement I', 10),
    (
        'DEV2',
        'Développement II',
        10
    ),
    (
        'WEBG2',
        'Développement web I',
        5
    );

insert into
    Student (id, name, gender, section)
values (6, 'Dracaufeu', 0, 0),
    (19, 'Rattata', 0, 0),
    (25, 'Pikachu', 1, 0),
    (39, 'Rondoudou', 1, 1),
    (309, 'Dynavolt', 0, 1),
    (378, 'Regice', 0, 2);

ALTER SEQUENCE student_sequence restart 400;

insert into
    COURSE_REGISTERED_STUDENTS (
        REGISTERED_STUDENTS_ID,
        REGISTERED_COURSES_ID
    )
values (6, 'INT1'),
    (19, 'INT1'),
    (19, 'DEV1');

INSERT INTO
    User (username, password, enabled)
values (
        'prof',
        '{bcrypt}$2a$10$s3b/SyANVjg6wB45RoJCmOqC/DuG7Huq2n.7Uhzsk1djlboink3Q2',
        true
    );

INSERT INTO
    Authority (id, username, authority)
values (1, 'prof', 'PROF');

INSERT INTO
    User (username, password, enabled)
values (
        'etu',
        '{bcrypt}$2a$10$EasnzMgBqcTbqrszvI5tZOofK9IiIdLgqZD24huusuMHOEgPADNeq',
        true
    );

INSERT INTO
    Authority (id, username, authority)
values (2, 'etu', 'USER');

INSERT INTO
    User (username, password, enabled)
values (
        'sec',
        '{bcrypt}$2a$10$hDsGi0dlzQERrw19Glnyk.8DFoM8WFFMNATIC3q7usNaQIZw3Q0gy',
        true
    );

INSERT INTO
    Authority (id, username, authority)
values (3, 'sec', 'SECRETARIAT');

INSERT INTO
    User (username, password, enabled)
values (
        'mcd',
        '{bcrypt}$2a$10$3.xwyz9H47yFziBOaL7DKuj6Upd/4UQNJlERItuClDbW7UZgzZHmy',
        true
    );

INSERT INTO
    Authority (id, username, authority)
values (4, 'mcd', 'PROF');