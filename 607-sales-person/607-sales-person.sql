# Write your MySQL query statement below
select s.name from SalesPerson s where s.sales_id not in(
select s.sales_id from SalesPerson s,Company c,Orders o
where s.sales_id = o.sales_id and o.com_id = c.com_id and c.name = 'RED');