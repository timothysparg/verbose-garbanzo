CREATE TABLE quote
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    quote_id INT,
    type VARCHAR(255),
    value VARCHAR(255)
);
CREATE UNIQUE INDEX "quote_id_uindex" ON quote (id);