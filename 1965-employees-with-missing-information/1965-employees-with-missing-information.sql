# Write your MySQL query statement below
select * from (
select employee_id from Employees where employee_id not in (
select Employees.employee_id from Employees inner join Salaries on Salaries.employee_id = Employees.employee_id)
union
select employee_id from Salaries where employee_id not in (
select Employees.employee_id from Employees inner join Salaries on Salaries.employee_id = Employees.employee_id)) as t order by employee_id;

