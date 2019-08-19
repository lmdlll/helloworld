-- 一、
Create table Person (
PersonId int primary key,
FirstName varchar(255), 
LastName varchar(255));
Create table Address (
AddressId int primary key, 
PersonId int, 
City varchar(255),
State varchar(255))
Truncate table Person
insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')
Truncate table Address
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York');

-- 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：FirstName, LastName, City, State
select FirstName, LastName, City, State from Person left join Address on Person.PersonId=Address.PersonId




-- 二、
Create table If Not Exists Employee (Id int, Salary int)
Truncate table Employee
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');
--编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
select ifnull((select distinct(Salary) from Employee order by Salary desc limit 1,1),null) SecondHighestSalary
-- 先去重 --> 使用order by # desc 得到Salary的排序 --> limit n,m   从n开始显示m行数据

--三、
Create table If Not Exists Scores (Id int, Score DECIMAL(3,2))
Truncate table Scores
insert into Scores (Id, Score) values ('1', '3.5')
insert into Scores (Id, Score) values ('2', '3.65')
insert into Scores (Id, Score) values ('3', '4.0')
insert into Scores (Id, Score) values ('4', '3.85')
insert into Scores (Id, Score) values ('5', '4.0')
insert into Scores (Id, Score) values ('6', '3.65')
--编写一个 SQL 查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。
--例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：
+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+

select a.Score as score ,  (select count(distinct b.Score) from Scores b where b.Score >=a.Score) as rank from Scores a order by Score DESC;
-- 对于a表中的每一个分数score，找出b表中有多少个大于或等于该分数的不同的分数，然后按降序排列



