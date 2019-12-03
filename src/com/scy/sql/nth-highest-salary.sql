# 编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。
#
# +------------------------+
# | getNthHighestSalary(2) |
# +------------------------+
# | 200                    |
# +------------------------+
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/nth-highest-salary
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
#one
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET n = N - 1;
    RETURN (
        SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT n,1
    );
END
#two
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN
(
    SELECT IF(count < N, NULL, min)
    FROM (SELECT MIN(Salary) AS min, COUNT(1) AS count
          FROM (SELECT DISTINCT Salary
                FROM Employee
                ORDER BY Salary DESC
                LIMIT N) AS a
         ) as b
);
END
