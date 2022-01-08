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
SELECT country, count_of_states
FROM (
         SELECT co.name AS country, COUNT(s.name) AS count_of_states
         FROM countries co
                  JOIN states s ON co.id = s.country_id
         GROUP BY country
     ) AS t
GROUP BY country, count_of_states
HAVING count_of_states > (SELECT AVG(count_of_states) FROM t);
--HAVING COUNT(s.name) > (SELECT AVG(count_of_states) FROM t);

--9
SELECT DISTINCT count, country
FROM (
         SELECT DISTINCT co.name AS country, COUNT(s.name) OVER (PARTITION BY co.name) AS count
         FROM countries co
                  JOIN states s ON co.id = s.country_id
         GROUP BY country, s.name ) t
ORDER BY count, country;


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