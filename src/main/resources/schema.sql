SELECT product_name FROM orders o
         join customers c on c.id = o.customer_id
         WHERE c.name = :name
