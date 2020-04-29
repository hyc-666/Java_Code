select name,score.score from student,score where
student.id = score.student_id and name = '许仙';

select student.id,student.sn,student.name,
student.qq_mail,student.classes_id,score.score from
student,score where student.id = score.student_id
group by student.id;


select student.id,student.sn,student.name,
student.qq_mail,student.classes_id,sum(score.score) from
student join score on student.id = score.student_id;

select student.id,student.sn,student.name,
student.qq_mail,student.classes_id,sum(score.score) from
student join score on student.id = score.student_id
group by student.id;

select student.id,student.name, course.name,score.score
from student,score,course where student.id = score.student_id and
score.course_id = course.id;

select name from student where classes_id = (
select classes_id from student where name = '不想毕业'
);