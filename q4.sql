INSERT INTO book VALUES (100, "The Pragmatic Programmer");

INSERT INTO member VALUES (150, "Alex Westcott");

INSERT INTO checkout_item(member_id, book_id) VALUES (150, 100);

SELECT member.name FROM member, checkout_item, book
WHERE member.id = checkout_item.member_id AND
checkout_item.book_id = book.id
AND book.title = 'The Pragmatic Programmer';