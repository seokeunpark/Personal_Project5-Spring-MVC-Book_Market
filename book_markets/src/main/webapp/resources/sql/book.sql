CREATE DATABASE BOOK_MARKET DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE BOOK_MARKET;

CREATE TABLE IF NOT EXISTS book(
	b_bookId VARCHAR(10) NOT NULL,
	b_name VARCHAR(30),
	b_unitPrice  INTEGER,
	b_author VARCHAR(50),
	b_description TEXT,
	b_publisher VARCHAR(20),
	b_category VARCHAR(20),
	b_unitsInStock LONG,	
	b_releaseDate VARCHAR(20),
	b_condition VARCHAR(20),
	b_fileName  VARCHAR(20),
	PRIMARY KEY (b_bookId)
)DEFAULT CHARSET=utf8;

DELETE FROM book;
INSERT INTO book VALUES('ISBN1234', 'C# ������', 30000,'�ڿ���', 'C# ���������� ���� ù ���α׷��� ���� C#�� �����ϴ� ���ڸ� ������� �Ѵ�. Ư�� ���� ���α׷��Ӹ� ���� C# �Թ�����, C#�� ����Ͽ� ����(����Ƽ), ��, �����, IoT ���� ������ �� �ʿ��� C# ���� ������ ������ �⺻�⸦ źź�ϰ� ������ ���� �����̴�.','���','IT������', 1000,'2020/05/29','','ISBN1234.png');
INSERT INTO book VALUES('ISBN1235', 'Node.js ������', 36000, '������', '�� å�� ����Ʈ���� ����, �����ͺ��̽�, �������� �ƿ츣�� �������� ������ �ٷ��. �������� ���� �������� �������� �⺻ ������ Ȯ���� �����ϰ�, ����� ��ɰ� ���°踦 ����غ��鼭 ������ �����ϴ� ������ ������. ������ �ڵ�� �ֽ� ������ ����߰� �ǹ��� �����ϰų� ���� ������ �� �ִ�.','���','IT������',1000, '2020/07/25','', 'ISBN1235.png'); 
INSERT INTO book VALUES('ISBN1236', '��� XD CC 2020', 25000, '�����', '��� XD ���α׷��� ���� UI/UX �������� ������ �ϴ� ���� �����̳��� �����̿� �°� �⺻���� ������ Ȱ���� ������ �����ΰ� ��&�� ������ ������, UI ������, �� �����ο� �ִϸ��̼ǰ� ���ͷ����� ������ ������Ÿ������ �н��մϴ�.', '���', 'ITȰ�뼭', 1000, '2019/05/29', '','ISBN1236.png');

