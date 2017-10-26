SELECT Customers.Name as 'Customers' from Orders RIGHT JOIN Customers ON Orders.CustomerId = Customers.ID WHERE Orders.CustomerId is NULL ORDER BY Customers.NAME;


Order only 1

select o.customerNumber as customer from ORDERS as o group by customerNumber order by count (orderNumber) desc limit 1;
