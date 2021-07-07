select
    ifnull((
               select distinct Salary
               from Employee e
               order by Salary desc
               limit 1 offset 1
           ), null)
        as SecondHighestSalary;