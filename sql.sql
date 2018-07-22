CREATE TABLE aberrant
(
   aberrant_id INT NOT NULL AUTO_INCREMENT,
   order_no INT,
   reason VARCHAR(64),
   created TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
   PRIMARY KEY (aberrant_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO aberrant (aberrant_id, order_no, reason, created) VALUES (1, 3, 'ds01', '2018-06-27 16:37:39');
INSERT INTO aberrant (aberrant_id, order_no, reason, created) VALUES (2, 2, 'fagrgas', '2018-06-21 16:28:25');
INSERT INTO aberrant (aberrant_id, order_no, reason, created) VALUES (6, 4, 'fdsafagsa', '2018-06-28 09:40:35');
INSERT INTO aberrant (aberrant_id, order_no, reason, created) VALUES (7, 1, 'aaa', '2018-06-28 09:40:35');
INSERT INTO aberrant (aberrant_id, order_no, reason, created) VALUES (8, 2, '333', '2018-07-02 21:57:47');
INSERT INTO aberrant (aberrant_id, order_no, reason, created) VALUES (2323, 1, 'dddd', '2018-07-17 22:12:30');
