# Write your MySQL query statement below

select user_id, time_stamp as last_stamp from (
select user_id,time_stamp,ROW_NUMBER() OVER (Partition by user_id order by time_stamp desc) as count from Logins where YEAR(time_stamp)=2020) as data where count=1;