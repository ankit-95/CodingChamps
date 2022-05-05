# Write your MySQL query statement below
select name as Customers from Customers where id not in (
select Customers.id from Customers 
inner join Orders on Orders.customerId = Customers.id);