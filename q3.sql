SELECT movie.title FROM movie WHERE movie.id IN(
SELECT movie.id FROM movie
EXCEPT
SELECT checkout_item.movie_id FROM checkout_item)
UNION ALL
SELECT book.title FROM book WHERE book.id IN(
SELECT book.id FROM book
EXCEPT
SELECT checkout_item.book_id FROM checkout_item);