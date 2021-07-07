
# 无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
# 注意：如果没有某个人的地址信息，使用 where 子句过滤记录将失败，因为它不会显示姓名信息


# 1）左联结（left join），联结结果保留左表的全部数据
#
# 2）右联结（right join），联结结果保留右表的全部数据
#
# 3）内联结（inner join），取两表的公共数据

select p.FirstName, p.LastName, a.City, a.State
from Person p left join Address a
                        on p.PersonId = a.PersonId
;