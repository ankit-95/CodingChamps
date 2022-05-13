# Write your MySQL query statement below
select Users.user_id as buyer_id,Users.join_date,0 as orders_in_2019 from Users
where Users.user_id not in (select Orders.buyer_id
from Users left join Orders on Users.user_id = Orders.buyer_id where Year(Orders.order_date) = 2019 group by Orders.buyer_id,Users.join_date
)
Union
select Orders.buyer_id,Users.join_date,count(Orders.order_id) orders_in_2019 
from Users left join Orders on Users.user_id = Orders.buyer_id
where Year(Orders.order_date) = 2019 group by Orders.buyer_id,Users.join_date;
