CREATE TABLE cookie (
	id bigserial primary key,
    name text,
    type text,
    manufacturer text,
    ingredients text,
    calories int,
    cost numeric,
    barcode int,
    storage text
);

CREATE TABLE task_create_cookie (
	id bigserial primary key,
	cookieId bigserial references cookie(id),
	weight real,
    createdTime date,
    updateTime date,
    status text
);