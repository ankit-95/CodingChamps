# Write your MySQL query statement below

select customer_id,count(*) count_no_trans from Visits where visit_id not in
(select Visits.visit_id from Visits inner join Transactions on Transactions.visit_id = Visits.visit_id)
group by customer_id;
