# Write your MySQL query statement below

# SELECT S.Score, COUNT(S2.Score) as `Rank`
# FROM Scores S,
# (SELECT DISTINCT Score FROM Scores) S2
# WHERE S.Score<=S2.Score
# GROUP BY S.Id
# ORDER BY S.Score DESC;

Select Score,
       Dense_rank() Over (Order By Score Desc) `Rank`
From Scores