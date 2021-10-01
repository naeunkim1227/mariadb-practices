-- abs : 절대값
select abs(-4);

-- mod(n, m) n을 m으로 나눈 나머지값
select mod(10, 3);


-- floor(x) x보다 크지 않은 정수
select floor(3.14);

-- ceil(x) x보다 작지 않은 정수
select ceil(3.14);
select ceiling(3.14);

-- round(x) : x에 가장 근접한 정수
-- round(x,y) : x값중에 소수점 d자리에 가장 근접한 실 수 
select round(1.498) ,round(1.498 , 1) , round(1.498 , 0);

-- pow(x,y) , power(x,y) x의 y승
select pow(2,10), power(10,2);

-- sign(x) 양수 1 음수 -1 0 0
select sign(20), sign(-100), sign(0);

-- greatest(x,y ...) , least(x,y ....) 최대값 최소값 문자도 가능하다.
select greatest(10,40,500,62,51) , least(10,1,59,85,15);
select greatest('b','A', 'C'), greatest('hello', 'hellp' , 'hellq');


 