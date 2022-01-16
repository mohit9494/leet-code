# Write your MySQL query statement below
SELECT p.firstName, p.lastName, a.city, a.state from PERSON p 
left join ADDRESS a on p.personId = a.personId;