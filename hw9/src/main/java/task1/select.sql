--1
SELECT co.name, COUNT(s.name) AS count_of_states
FROM countries co
         JOIN states s ON co.id = s.country_id
GROUP BY co.name
ORDER BY count_of_states DESC
LIMIT 1;

--2
SELECT co.name, COUNT(c.name) AS count_of_cities
FROM countries co
         JOIN states s ON co.id = s.country_id
         JOIN cities c ON s.id = c.state_id
GROUP BY co.name
ORDER BY count_of_cities DESC
LIMIT 1;

--3
SELECT co.id, co.name, COUNT(s.name) AS count_of_states
FROM countries co
         JOIN states s ON co.id = s.country_id
GROUP BY co.id, co.name
ORDER BY count_of_states DESC, co.name, co.id;

--4
SELECT co.id, co.name, COUNT(c.name) AS count_of_cities
FROM countries co
         JOIN states s ON co.id = s.country_id
         FULL JOIN cities c ON s.id = c.state_id
GROUP BY co.id, co.name
ORDER BY count_of_cities DESC, co.name, co.id;

--5
SELECT co.name, COUNT(DISTINCT s.name) AS count_of_states, COUNT(c.name) AS count_of_cities
FROM countries co
         JOIN states s ON co.id = s.country_id
         FULL JOIN cities c ON s.id = c.state_id
GROUP BY co.name;

--6
SELECT DISTINCT s.name AS state, co.name AS country, COUNT(c.name) AS count_of_cities
FROM countries co
         JOIN states s ON co.id = s.country_id
         FULL JOIN cities c ON s.id = c.state_id
GROUP BY co.name, s.name
ORDER BY count_of_cities DESC
LIMIT 10;

--7
(SELECT DISTINCT co.name AS country, COUNT(s.name) AS count_of_states
 FROM countries co
          JOIN states s ON co.id = s.country_id
 GROUP BY country
 ORDER BY count_of_states DESC
 LIMIT 10)
UNION ALL
(SELECT DISTINCT co.name AS country, COUNT(s.name) AS count_of_states
 FROM countries co
          JOIN states s ON co.id = s.country_id
 GROUP BY country
 ORDER BY count_of_states
 LIMIT 10)
ORDER BY country;

--8
SELECT co.name, COUNT(s.name)
FROM (
         SELECT AVG(count_of_states) as average
         FROM (
                  SELECT co.name AS country, COUNT(s.name) AS count_of_states
                  FROM countries co
                           JOIN states s ON co.id = s.country_id
                  GROUP BY country
              ) t1
     ) t2,
     countries co
         JOIN states s on co.id = s.country_id
GROUP BY co.name, average
HAVING COUNT(s.name) > average;

--9
WITH t1 AS
         (SELECT DISTINCT COUNT(s.name) OVER (PARTITION BY co.name) AS count_of_states,
                          co.id,
                          co.sortname,
                          co.name                                   AS country,
                          co.phonecode
          FROM countries co
                   JOIN states s ON co.id = s.country_id
          GROUP BY country, co.id, co.sortname, co.phonecode, s.name),
     t2 AS
         (SELECT DISTINCT ON (count_of_states) count_of_states AS count_of_states, id, sortname, country, phonecode
          FROM t1)
SELECT id, sortname, country, phonecode, count_of_states
FROM t2;

--10
SELECT state, country
FROM (
         SELECT s.name AS state, co.name AS country, COUNT(s.name) OVER (PARTITION BY s.name) AS count
         FROM countries co
                  JOIN states s ON co.id = s.country_id
     ) t
WHERE count > 1
ORDER BY count DESC, state;

--11
SELECT s.name AS state, c.name AS city
FROM states s
         LEFT JOIN cities c ON s.id = c.state_id
GROUP BY state, city
HAVING COUNT(c.name) = 0;