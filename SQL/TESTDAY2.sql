-- 四
Create table If Not Exists Person (Id int, Email varchar(255))
Truncate table Person
insert into Person (Id, Email) values ('1', 'a@b.com')
insert into Person (Id, Email) values ('2', 'c@d.com')
insert into Person (Id, Email) values ('3', 'a@b.com')
-- 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。根据以上输入，你的查询应返回以下结果：
+---------+
| Email   |
+---------+
| a@b.com |
+---------+

-- 解法1
select email from person group by email having count(email)>1
--解法2
select distinct a.Email from Person a,Person b where a.Email=b.Eamil and a.id!=b.id   #先找到所以重复的(编号不等，内容相等)，然后对其进行去重


-- 五
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, ManagerId int)
Truncate table Employee
insert into Employee (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3')
insert into Employee (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4')
insert into Employee (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', 'None')
insert into Employee (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', 'None')
-- Employee 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
-- 给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。
+----------+
| Employee |
+----------+
| Joe      |
+----------+

select a.Name as Employee from Employee a,Employee b where a.Salary>b.Salary and a.ManagerId=b.Id;
--判断条件：员工薪水 > 经理薪水 and 员工的经理id=经理id


--六

Create table If Not Exists World (name varchar(255), continent varchar(255), area int, population int, gdp int)
Truncate table World
insert into World (name, continent, area, population, gdp) values ('Afghanistan', 'Asia', '652230', '25500100', '20343000000')
insert into World (name, continent, area, population, gdp) values ('Albania', 'Europe', '28748', '2831741', '12960000000')
insert into World (name, continent, area, population, gdp) values ('Algeria', 'Africa', '2381741', '37100000', '188681000000')
insert into World (name, continent, area, population, gdp) values ('Andorra', 'Europe', '468', '78115', '3712000000')
insert into World (name, continent, area, population, gdp) values ('Angola', 'Africa', '1246700', '20609294', '100990000000')
-- 这里有张 World 表如果一个国家的面积超过300万平方公里，或者人口超过2500万，那么这个国家就是大国家。
-- 编写一个SQL查询，输出表中所有大国家的名称、人口和面积。例如，根据上表，我们应该输出:
+--------------+-------------+--------------+
| name         | population  | area         |
+--------------+-------------+--------------+
| Afghanistan  | 25500100    | 652230       |
| Algeria      | 37100000    | 2381741      |
+--------------+-------------+--------------+

select name,population,area from world where area>3000000 or population>25000000