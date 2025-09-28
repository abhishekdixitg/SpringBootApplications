## Inventory Service 

Demo application to show the inventory service in a microservices architecture

## Create Table

This table stores information about inventory available in the system.

```sql
CREATE TABLE inventory (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_code VARCHAR(255) NOT NULL UNIQUE,
    quantity INT NOT NULL,
    item_name VARCHAR(255),
    price DECIMAL(10, 2),
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);