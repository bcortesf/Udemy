INSERT INTO clients (name, lastname) VALUES ('Pepe', 'Doe');
INSERT INTO clients (name, lastname) VALUES ('Maria', 'Roe');


-- INSERT INTO invoices(description, total) VALUES ('', 0.0);


-- SELECT * FROM db_jpa_relationship.clients;
-- SELECT * FROM db_jpa_relationship.addresses;
-- SELECT * FROM db_jpa_relationship.clients_addresses;

-- SELECT C.*, A.street, a.number  FROM db_jpa_relationship.clients AS C
-- INNER JOIN db_jpa_relationship.clients_addresses AS CA ON C.id = CA.client_id
-- INNER JOIN db_jpa_relationship.addresses AS A ON CA.addresses_id = A.id;