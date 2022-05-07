# Write your MySQL query statement below
update Salary
set sex = case when sex in ('m') then 'f' 
               when sex in ('f') then 'm' end;
