SELECT Customers.Name as 'Customers' from Orders RIGHT JOIN Customers ON Orders.CustomerId = Customers.ID WHERE Orders.CustomerId is NULL ORDER BY Customers.NAME;
