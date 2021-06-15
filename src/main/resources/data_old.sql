-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

TRUNCATE TABLE brands
RESTART IDENTITY cascade;
-- insert 	into brands("name")
-- values ('marca 1'),
-- ('marca 2'),
-- ('marca 3');

TRUNCATE TABLE users
RESTART IDENTITY cascade;
-- INSERT INTO users ("name", "password")
-- VALUES ('bianca', '123'),
-- ('ingrid', '123'),
-- ('luiza', '123'),
-- ('ronaldo', '123'),
-- ('wendel', '123');

TRUNCATE TABLE vehicles
RESTART IDENTITY cascade;
-- insert into vehicles ("model", "price", "years", "brand_id")
-- values ('modelo 1', 10000.00, 2010, 1),
-- ('modelo 2', 20000.00, 2011, 2);

