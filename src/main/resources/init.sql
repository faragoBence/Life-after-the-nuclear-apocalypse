DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS backpacks;
DROP TABLE IF EXISTS survivors;
DROP TABLE IF EXISTS outposts;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    "id"  SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE outposts (
    "id"  SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE survivors (
	id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	outpost_id INTEGER NOT NULL,
	name TEXT NOT NULL,
	action_points INTEGER NOT NULL,
	max_action_points INTEGER NOT NULL,
	hunger INTEGER NOT NULL,
	max_hunger INTEGER NOT NULL,
	health INTEGER NOT NULL,
	radiation INTEGER NOT NULL,
	max_radiation INTEGER NOT NULL,
	strength INTEGER NOT NULL,
	agility INTEGER NOT NULL,
	location TEXT NOT NULL,
	type TEXT NOT NULL,
	fraction TEXT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users("id"),
	FOREIGN KEY (outpost_id) REFERENCES outposts("id")

);

CREATE TABLE backpacks (
	id SERIAL PRIMARY KEY,
  survivor_id INTEGER NOT NULL,
  max_slots INTEGER NOT NULL,
  FOREIGN KEY (survivor_id) REFERENCES survivors("id")
);

CREATE TABLE items (
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	durability INTEGER,
  backpack_id INTEGER,
  outpost_id INTEGER,
  FOREIGN KEY (backpack_id) REFERENCES backpacks("id"),
	FOREIGN KEY (outpost_id) REFERENCES outposts("id")
	);

INSERT INTO outposts ("name") VALUES
	('Lost Hills'),
	('Sniper''s hideout'),
	('The Institute');



