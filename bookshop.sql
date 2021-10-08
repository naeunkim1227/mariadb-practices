-- scheme 확인

desc book;
desc author;

-- insert author
insert into author values (null, '스테파니 메이어');
-- insert book
insert into book values (null, '이클립스', 1 , '대여가능');

-- select book
select a.no , a.title , a.status , b.name as authorname
from book a, author b
where a.author_no = b.no;


-- update book's status(no,status)
update book set status = '대여중' where no=1;

