CREATE TABLE audit_trail (
  id BIGINT NOT NULL AUTO_INCREMENT,
  sale_id BIGINT NOT NULL,
  account_id BIGINT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (sale_id) REFERENCES  sale(id),
  FOREIGN KEY (account_id) REFERENCES account(id)
);