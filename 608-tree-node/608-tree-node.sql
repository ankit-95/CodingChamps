# Write your MySQL query statement below
select 
distinct t1.id,(
case when t1.p_id is null then 'Root'
    when t1.p_id is not null and t2.id is not null then 'Inner' 
    when t1.p_id is not null and t2.id is null then 'Leaf'
    end) as Type
from Tree t1
left join Tree t2
on t1.id = t2.p_id;

