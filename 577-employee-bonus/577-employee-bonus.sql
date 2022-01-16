# Write your MySQL query statement below

select e.name, b.bonus from Employee e LEFT JOIN Bonus b on e.empId = b.empId 
where IFNULL(bonus,0) < 1000 ;