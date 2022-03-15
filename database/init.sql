DROP schema public cascade;

CREATE schema offertlyapi;
GRANT ALL ON SCHEMA offertlyapi TO "admin";
ALTER ROLE "admin" IN DATABASE "offertlyapi" SET search_path TO offertlyapi;
