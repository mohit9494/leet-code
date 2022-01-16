# Write your MySQL query statement below
SELECT e1.name as Employee FROM Employee e1 inner join Employee e2 on e1.managerid = e2.id 
where e1.salary > e2.salary;