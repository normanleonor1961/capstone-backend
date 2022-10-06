DROP SCHEMA IF EXISTS capstone cascade;
CREATE SCHEMA capstone;

CREATE TABLE capstone.USERS (
    user_id uuid,
    todo varchar(150),
    created_date TIMESTAMP WITH TIME ZONE,
    modified_date TIMESTAMP WITH TIME ZONE,
    PRIMARY KEY (user_id)
);