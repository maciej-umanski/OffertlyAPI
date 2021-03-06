DROP schema public cascade;

CREATE schema offertlyapi;
GRANT ALL ON SCHEMA offertlyapi TO "admin";
ALTER ROLE "admin" IN DATABASE "offertlyapi" SET search_path TO offertlyapi;

-- offertlyapi.availability definition

-- Drop table

-- DROP TABLE offertlyapi.availability;

CREATE TABLE offertlyapi.availability (
                                          id bigserial NOT NULL,
                                          CONSTRAINT availability_pkey PRIMARY KEY (id)
);


-- offertlyapi.category definition

-- Drop table

-- DROP TABLE offertlyapi.category;

CREATE TABLE offertlyapi.category (
                                      id bigserial NOT NULL,
                                      name_eng varchar(255) NULL,
                                      name_pl varchar(255) NULL,
                                      CONSTRAINT category_pkey PRIMARY KEY (id)
);


-- offertlyapi."comments" definition

-- Drop table

-- DROP TABLE offertlyapi."comments";

CREATE TABLE offertlyapi."comments" (
                                        id bigserial NOT NULL,
                                        author_id int8 NULL,
                                        "comment" varchar(255) NULL,
                                        created timestamp NULL,
                                        rate float8 NULL,
                                        CONSTRAINT comments_pkey PRIMARY KEY (id)
);


-- offertlyapi.availability_fri definition

-- Drop table

-- DROP TABLE offertlyapi.availability_fri;

CREATE TABLE offertlyapi.availability_fri (
                                              availability_id int8 NOT NULL,
                                              fri int4 NULL,
                                              CONSTRAINT fkht7arsnbwawp7f43ico6eigkl FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.availability_mon definition

-- Drop table

-- DROP TABLE offertlyapi.availability_mon;

CREATE TABLE offertlyapi.availability_mon (
                                              availability_id int8 NOT NULL,
                                              mon int4 NULL,
                                              CONSTRAINT fk3xc7fytf30scupa9x49ogpmp3 FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.availability_sat definition

-- Drop table

-- DROP TABLE offertlyapi.availability_sat;

CREATE TABLE offertlyapi.availability_sat (
                                              availability_id int8 NOT NULL,
                                              sat int4 NULL,
                                              CONSTRAINT fktmf8aog9nrtdaopsy5exjvhjh FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.availability_sun definition

-- Drop table

-- DROP TABLE offertlyapi.availability_sun;

CREATE TABLE offertlyapi.availability_sun (
                                              availability_id int8 NOT NULL,
                                              sun int4 NULL,
                                              CONSTRAINT fkn3kyipdjky39tamqyycegas61 FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.availability_thu definition

-- Drop table

-- DROP TABLE offertlyapi.availability_thu;

CREATE TABLE offertlyapi.availability_thu (
                                              availability_id int8 NOT NULL,
                                              thu int4 NULL,
                                              CONSTRAINT fkbf1fot2646gixmllycw4kndwx FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.availability_tue definition

-- Drop table

-- DROP TABLE offertlyapi.availability_tue;

CREATE TABLE offertlyapi.availability_tue (
                                              availability_id int8 NOT NULL,
                                              tue int4 NULL,
                                              CONSTRAINT fk1n4c3bslbts2xa8fefqo6tb8 FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.availability_wed definition

-- Drop table

-- DROP TABLE offertlyapi.availability_wed;

CREATE TABLE offertlyapi.availability_wed (
                                              availability_id int8 NOT NULL,
                                              wed int4 NULL,
                                              CONSTRAINT fkde3gedwm8jbiq7k2tn7gnquo FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.users definition

-- Drop table

-- DROP TABLE offertlyapi.users;

CREATE TABLE offertlyapi.users (
                                   id bigserial NOT NULL,
                                   average_rate float8 NULL,
                                   city varchar(255) NULL,
                                   created timestamp NULL,
                                   last_active timestamp NULL,
                                   last_name varchar(255) NULL,
                                   "name" varchar(255) NULL,
                                   "password" varchar(255) NULL,
                                   phone_number varchar(255) NULL,
                                   photo_url varchar(255) NULL,
                                   username varchar(255) NULL,
                                   availability_id int8 NULL,
                                   CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username),
                                   CONSTRAINT users_pkey PRIMARY KEY (id),
                                   CONSTRAINT fkqjsci4umgx5r0aa1ho9bnyk0s FOREIGN KEY (availability_id) REFERENCES offertlyapi.availability(id)
);


-- offertlyapi.users_comments definition

-- Drop table

-- DROP TABLE offertlyapi.users_comments;

CREATE TABLE offertlyapi.users_comments (
                                            user_id int8 NOT NULL,
                                            comments_id int8 NOT NULL,
                                            CONSTRAINT uk_8a9ff54pt2w205r0hlcbe8mm6 UNIQUE (comments_id),
                                            CONSTRAINT fk3b83nq9ncocq7tb4e90dyqmqg FOREIGN KEY (comments_id) REFERENCES offertlyapi."comments"(id),
                                            CONSTRAINT fklpp3854cd31i91y1pc26727p6 FOREIGN KEY (user_id) REFERENCES offertlyapi.users(id)
);


-- offertlyapi.posts definition

-- Drop table

-- DROP TABLE offertlyapi.posts;

CREATE TABLE offertlyapi.posts (
                                   id bigserial NOT NULL,
                                   city varchar(255) NULL,
                                   created timestamp NULL,
                                   currency varchar(255) NULL,
                                   description varchar(255) NULL,
                                   photo_url varchar(255) NULL,
                                   price float8 NULL,
                                   report_count int4 NULL,
                                   title varchar(255) NULL,
                                   author_id int8 NULL,
                                   CONSTRAINT posts_pkey PRIMARY KEY (id),
                                   CONSTRAINT fk6xvn0811tkyo3nfjk2xvqx6ns FOREIGN KEY (author_id) REFERENCES offertlyapi.users(id)
);


-- offertlyapi.posts_categories definition

-- Drop table

-- DROP TABLE offertlyapi.posts_categories;

CREATE TABLE offertlyapi.posts_categories (
                                              post_id int8 NOT NULL,
                                              categories_id int8 NOT NULL,
                                              CONSTRAINT fk7erlncb1g9yeikbq6dloii4cf FOREIGN KEY (categories_id) REFERENCES offertlyapi.category(id),
                                              CONSTRAINT fkq4402eed597exuj50g73c7kmg FOREIGN KEY (post_id) REFERENCES offertlyapi.posts(id)
);