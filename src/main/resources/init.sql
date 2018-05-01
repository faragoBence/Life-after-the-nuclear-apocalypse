DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS survivors;

CREATE TABLE users (
    id  SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE survivors (
	id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
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
	FOREIGN KEY (user_id) REFERENCES users("id")
);